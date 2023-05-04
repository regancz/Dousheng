package com.charles.dousheng.repository;

import java.util.List;

/**
 * @author charles
 * @date 5/4/2023 9:55 AM
 */
public interface UserReadHistoryRepository {
    /**
     * 根据用户id按时间倒序获取浏览记录
     * @param userId 用户id
     */
    List<UserReadHistoryRepository> findByUserIdOrderByCreateTimeDesc(Long userId);
}
