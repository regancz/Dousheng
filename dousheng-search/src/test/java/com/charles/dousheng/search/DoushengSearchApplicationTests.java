package com.charles.dousheng.search;

import com.charles.dousheng.search.dao.EsVideoDao;
import com.charles.dousheng.search.domain.EsVideo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;

import java.util.List;
import java.util.Map;

/**
 * @author charles
 * @date 5/4/2023 9:13 PM
 */
public class DoushengSearchApplicationTests {
    @Autowired
    private EsVideoDao esVideoDao;
    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
    @Test
    public void contextLoads() {
    }
    @Test
    public void testGetAllEsProductList(){
        List<EsVideo> esProductList = esVideoDao.getAllEsVideoList(null);
        System.out.print(esProductList);
    }
    @Test
    public void testEsProductMapping(){
        IndexOperations indexOperations = elasticsearchTemplate.indexOps(EsVideo.class);
        indexOperations.putMapping(indexOperations.createMapping(EsVideo.class));
        Map mapping = indexOperations.getMapping();
        System.out.println(mapping);
    }
}
