package com.charles.dousheng.service.impl;

import com.charles.dousheng.dto.RelationActionParam;
import com.charles.dousheng.dto.RelationFollowListParam;
import com.charles.dousheng.dto.RelationFollowerListParam;
import com.charles.dousheng.dto.UserResult;
import com.charles.dousheng.service.RelationUserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author charles
 * @date 5/1/2023 10:10 PM
 */
@Service
public class RelationUserUserServiceImpl implements RelationUserService {
    @Override
    public List<UserResult> relationFollowList(RelationFollowListParam relationFollowListParam) {
        return null;
    }

    @Override
    public List<UserResult> relationFollowerList(RelationFollowerListParam relationFollowerListParam) {
        return null;
    }

    @Override
    public int relationAction(RelationActionParam relationActionParam) {
        return 0;
    }
}
