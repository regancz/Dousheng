package com.charles.dousheng.search.service.impl;

import com.charles.dousheng.search.dao.EsVideoDao;
import com.charles.dousheng.search.domain.EsVideo;
import com.charles.dousheng.search.domain.EsVideoRelatedInfo;
import com.charles.dousheng.search.repository.EsVideoRepository;
import com.charles.dousheng.search.service.EsVideoService;
import org.elasticsearch.common.lucene.search.function.FunctionScoreQuery;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.elasticsearch.search.aggregations.AbstractAggregationBuilder;
import org.elasticsearch.search.aggregations.Aggregation;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.aggregations.bucket.filter.ParsedFilter;
import org.elasticsearch.search.aggregations.bucket.nested.ParsedNested;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedLongTerms;
import org.elasticsearch.search.aggregations.bucket.terms.ParsedStringTerms;
import org.elasticsearch.search.aggregations.bucket.terms.Terms;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author charles
 * @date 5/4/2023 6:59 PM
 */
@Service
public class EsVideoServiceImpl implements EsVideoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(EsVideoServiceImpl.class);

    @Autowired
    private EsVideoDao videoDao;

    @Autowired
    private EsVideoRepository videoRepository;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

    @Override
    public int importAll() {
        List<EsVideo> esVideoList = videoDao.getAllEsVideoList(null);
        Iterable<EsVideo> esVideoIterable = videoRepository.saveAll(esVideoList);
        Iterator<EsVideo> iterator = esVideoIterable.iterator();
        int result = 0;
        while (iterator.hasNext()) {
            result++;
            iterator.next();
        }
        return result;
    }

    @Override
    public void delete(Long id) {
        videoRepository.deleteById(id);
    }

    @Override
    public EsVideo create(Long id) {
        EsVideo result = null;
        List<EsVideo> esVideoList = videoDao.getAllEsVideoList(id);
        if (esVideoList.size() > 0) {
            EsVideo esVideo = esVideoList.get(0);
            result = videoRepository.save(esVideo);
        }
        return result;
    }

    @Override
    public void delete(List<Long> ids) {
        if (!CollectionUtils.isEmpty(ids)) {
            List<EsVideo> esVideoList = new ArrayList<>();
            for (Long id : ids) {
                EsVideo esVideo = new EsVideo();
                esVideo.setId(id);
                esVideoList.add(esVideo);
            }
            videoRepository.deleteAll(esVideoList);
        }
    }

    @Override
    public Page<EsVideo> search(String keyword, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        return videoRepository.findByVideoCategoryNameOrTitle(keyword, keyword, pageable);
    }

    @Override
    public Page<EsVideo> search(String keyword, Long MCNId, Long videoCategoryId, Integer pageNum, Integer pageSize,Integer sort) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        // 分页
        nativeSearchQueryBuilder.withPageable(pageable);
        // 过滤
        if (MCNId != null || videoCategoryId != null) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
            if (MCNId != null) {
                boolQueryBuilder.must(QueryBuilders.termQuery("MCNId", MCNId));
            }
            if (videoCategoryId != null) {
                boolQueryBuilder.must(QueryBuilders.termQuery("videoCategoryId", videoCategoryId));
            }
            nativeSearchQueryBuilder.withFilter(boolQueryBuilder);
        }
        // 搜索
        if (StringUtils.isEmpty(keyword)) {
            nativeSearchQueryBuilder.withQuery(QueryBuilders.matchAllQuery());
        } else {
            List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("name", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(10)));
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("title", keyword),
                    ScoreFunctionBuilders.weightFactorFunction(5)));
            FunctionScoreQueryBuilder.FilterFunctionBuilder[] builders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[filterFunctionBuilders.size()];
            filterFunctionBuilders.toArray(builders);
            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .setMinScore(2);
            nativeSearchQueryBuilder.withQuery(functionScoreQueryBuilder);
        }
        // 排序
        if(sort==1){
            // 按新品从新到旧
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("createTime").order(SortOrder.DESC));
        }else if(sort==2){
            // 按点赞数从高到低
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("favoriteCount").order(SortOrder.DESC));
        }else if(sort==3){
            // 按评论数从低到高
            nativeSearchQueryBuilder.withSort(SortBuilders.fieldSort("commentCount").order(SortOrder.ASC));
        }
        nativeSearchQueryBuilder.withSort(SortBuilders.scoreSort().order(SortOrder.DESC));
        NativeSearchQuery searchQuery = nativeSearchQueryBuilder.build();
        LOGGER.info("DSL:{}", Objects.requireNonNull(searchQuery.getQuery()));
        SearchHits<EsVideo> searchHits = elasticsearchRestTemplate.search(searchQuery, EsVideo.class);
        if(searchHits.getTotalHits() <= 0){
            return new PageImpl<>(null, pageable, 0);
        }
        List<EsVideo> searchVideoList = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        return new PageImpl<>(searchVideoList,pageable,searchHits.getTotalHits());
    }

    @Override
    public Page<EsVideo> recommend(Long id, Integer pageNum, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        List<EsVideo> esProductList = videoDao.getAllEsVideoList(id);
        if (esProductList.size() > 0) {
            EsVideo esVideo = esProductList.get(0);
            Long mcnId = esVideo.getMCNId();
            Long videoCategoryId = esVideo.getVideoCategoryId();
            //根据视频标题、品牌、分类进行搜索
            List<FunctionScoreQueryBuilder.FilterFunctionBuilder> filterFunctionBuilders = new ArrayList<>();
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("MCNId", mcnId),
                    ScoreFunctionBuilders.weightFactorFunction(5)));
            filterFunctionBuilders.add(new FunctionScoreQueryBuilder.FilterFunctionBuilder(QueryBuilders.matchQuery("videoCategoryId", videoCategoryId),
                    ScoreFunctionBuilders.weightFactorFunction(3)));
            FunctionScoreQueryBuilder.FilterFunctionBuilder[] builders = new FunctionScoreQueryBuilder.FilterFunctionBuilder[filterFunctionBuilders.size()];
            filterFunctionBuilders.toArray(builders);
            FunctionScoreQueryBuilder functionScoreQueryBuilder = QueryBuilders.functionScoreQuery(builders)
                    .scoreMode(FunctionScoreQuery.ScoreMode.SUM)
                    .setMinScore(2);
            // 用于过滤掉相同的视频
            BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
            boolQueryBuilder.mustNot(QueryBuilders.termQuery("id", id));
            // 构建查询条件
            NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
            builder.withQuery(functionScoreQueryBuilder);
            builder.withFilter(boolQueryBuilder);
            builder.withPageable(pageable);
            NativeSearchQuery searchQuery = builder.build();
            LOGGER.info("DSL:{}", Objects.requireNonNull(searchQuery.getQuery()));
            SearchHits<EsVideo> searchHits = elasticsearchRestTemplate.search(searchQuery, EsVideo.class);
            if(searchHits.getTotalHits()<=0){
                return new PageImpl<>(null,pageable,0);
            }
            List<EsVideo> searchProductList = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
            return new PageImpl<>(searchProductList,pageable,searchHits.getTotalHits());
        }
        return new PageImpl<>(null);
    }

    @Override
    public EsVideoRelatedInfo searchRelatedInfo(String keyword) {
        NativeSearchQueryBuilder builder = new NativeSearchQueryBuilder();
        // 搜索条件
        if(StringUtils.isEmpty(keyword)){
            builder.withQuery(QueryBuilders.matchAllQuery());
        }else{
            builder.withQuery(QueryBuilders.multiMatchQuery(keyword, "name", "title"));
        }
        // 聚合搜索视频名称
        builder.addAggregation(AggregationBuilders.terms("MCNName").field("MCNName"));
        // 集合搜索分类名称
        builder.addAggregation(AggregationBuilders.terms("videoCategoryName").field("videoCategoryName"));
        // 聚合搜索视频属性，去除type=1的属性
        AbstractAggregationBuilder aggregationBuilder = AggregationBuilders.nested("allAttrValues","attrValueList")
                .subAggregation(AggregationBuilders.filter("videoAttrs",QueryBuilders.termQuery("attrValueList.type",1))
                        .subAggregation(AggregationBuilders.terms("attrIds")
                                .field("attrValueList.videoAttributeId")
                                .subAggregation(AggregationBuilders.terms("attrValues")
                                        .field("attrValueList.value"))
                                .subAggregation(AggregationBuilders.terms("attrNames")
                                        .field("attrValueList.name"))));
        builder.addAggregation(aggregationBuilder);
        NativeSearchQuery searchQuery = builder.build();
        SearchHits<EsVideo> searchHits = elasticsearchRestTemplate.search(searchQuery, EsVideo.class);
        return convertProductRelatedInfo(searchHits);
    }

    /**
     * 将返回结果转换为对象
     */
    private EsVideoRelatedInfo convertProductRelatedInfo(SearchHits<EsVideo> response) {
        EsVideoRelatedInfo videoRelatedInfo = new EsVideoRelatedInfo();
        Map<String, Aggregation> aggregationMap = ((Aggregations)response.getAggregations().aggregations()).asMap();
        // 设置MCN
        Aggregation mcnName = aggregationMap.get("MCNName");
        List<String> mcnNameList = new ArrayList<>();
        for(int i = 0; i<((Terms) mcnName).getBuckets().size(); i++){
            mcnNameList.add(((Terms) mcnName).getBuckets().get(i).getKeyAsString());
        }
        videoRelatedInfo.setMCNNames(mcnNameList);
        // 设置分类
        Aggregation videoCategoryNames = aggregationMap.get("videoCategoryNames");
        List<String> videoCategoryNameList = new ArrayList<>();
        for(int i = 0; i < ((Terms) videoCategoryNames).getBuckets().size(); i++){
            videoCategoryNameList.add(((Terms) videoCategoryNames).getBuckets().get(i).getKeyAsString());
        }
        videoRelatedInfo.setVideoCategoryNames(videoCategoryNameList);
        // 设置参数
        Aggregation videoAttrs = aggregationMap.get("allAttrValues");
        List<? extends Terms.Bucket> attrIds = ((ParsedLongTerms) ((ParsedFilter) ((ParsedNested) videoAttrs).getAggregations().get("videoAttrs")).getAggregations().get("attrIds")).getBuckets();
        List<EsVideoRelatedInfo.VideoAttr> attrList = new ArrayList<>();
        for (Terms.Bucket attrId : attrIds) {
            EsVideoRelatedInfo.VideoAttr attr = new EsVideoRelatedInfo.VideoAttr();
            attr.setAttrId((Long) attrId.getKey());
            List<String> attrValueList = new ArrayList<>();
            List<? extends Terms.Bucket> attrValues = ((ParsedStringTerms) attrId.getAggregations().get("attrValues")).getBuckets();
            List<? extends Terms.Bucket> attrNames = ((ParsedStringTerms) attrId.getAggregations().get("attrNames")).getBuckets();
            for (Terms.Bucket attrValue : attrValues) {
                attrValueList.add(attrValue.getKeyAsString());
            }
            attr.setAttrValues(attrValueList);
            if(!CollectionUtils.isEmpty(attrNames)){
                String attrName = attrNames.get(0).getKeyAsString();
                attr.setAttrName(attrName);
            }
            attrList.add(attr);
        }
        videoRelatedInfo.setVideoAttrs(attrList);
        return videoRelatedInfo;
    }
}
