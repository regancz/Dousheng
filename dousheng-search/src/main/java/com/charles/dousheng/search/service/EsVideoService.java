package com.charles.dousheng.search.service;

import com.charles.dousheng.search.domain.EsVideo;
import com.charles.dousheng.search.domain.EsVideoRelatedInfo;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author charles
 * @date 5/4/2023 6:59 PM
 */
public interface EsVideoService {
    /**
     * 从数据库中导入所有商品到ES
     */
    int importAll();

    /**
     * 根据id删除商品
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     */
    EsVideo create(Long id);

    /**
     * 批量删除商品
     */
    void delete(List<Long> ids);

    /**
     * 根据关键字搜索名称或者副标题
     */
    Page<EsVideo> search(String keyword, Integer pageNum, Integer pageSize);

    /**
     * 根据关键字搜索名称或者副标题复合查询
     */
    Page<EsVideo> search(String keyword, Long brandId, Long productCategoryId, Integer pageNum, Integer pageSize,Integer sort);

    /**
     * 根据商品id推荐相关商品
     */
    Page<EsVideo> recommend(Long id, Integer pageNum, Integer pageSize);

    /**
     * 获取搜索词相关品牌、分类、属性
     */
    EsVideoRelatedInfo searchRelatedInfo(String keyword);
}
