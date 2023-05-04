package com.charles.dousheng.service;

import com.charles.dousheng.domain.UserReadHistory;

import java.util.List;

/**
 * @author charles
 * @date 5/4/2023 9:56 AM
 */
public interface UserReadHistoryService {
    /**
     * 生成浏览记录
     */
    int create(UserReadHistory userReadHistory);

    /**
     * 批量删除浏览记录
     */
    int delete(List<String> ids);

    /**
     * 获取用户浏览历史记录
     */
    List<UserReadHistory> list(Long userId);
}
