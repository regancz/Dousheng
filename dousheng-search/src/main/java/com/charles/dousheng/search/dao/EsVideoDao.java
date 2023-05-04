package com.charles.dousheng.search.dao;

import com.charles.dousheng.search.domain.EsVideo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 搜索视频管理自定义Dao
 *
 * @author charles
 * @date 5/4/2023 9:14 PM
 */
public interface EsVideoDao {
    /**
     * 获取指定ID的搜索视频
     */
    List<EsVideo> getAllEsVideoList(@Param("id") Long id);
}
