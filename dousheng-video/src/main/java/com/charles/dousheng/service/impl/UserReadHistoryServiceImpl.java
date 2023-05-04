package com.charles.dousheng.service.impl;

import com.charles.dousheng.domain.UserReadHistory;
import com.charles.dousheng.id.IdProcessor;
import com.charles.dousheng.service.UserReadHistoryService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author charles
 * @date 5/4/2023 9:58 AM
 */
@Service
public class UserReadHistoryServiceImpl implements UserReadHistoryService {
    @Override
    public int create(UserReadHistory userReadHistory) {
        userReadHistory.setId(IdProcessor.getIdStr());
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        return 0;
    }

    @Override
    public List<UserReadHistory> list(Long userId) {
        return null;
    }
}
