package com.charles.dousheng.search.repository;

import com.charles.dousheng.search.domain.EsVideo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author charles
 * @date 5/4/2023 9:30 PM
 */
public interface EsVideoRepository extends ElasticsearchRepository<EsVideo, Long> {
    /**
     * 搜索查询
     *
     * @param name              视频名称
     * @param subTitle          视频标题
     * @param page              分页信息
     */
    Page<EsVideo> findByNameOrTitle(String name, String subTitle, Pageable page);
}
