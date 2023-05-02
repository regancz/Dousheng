package com.charles.dousheng.service;

import com.charles.dousheng.dto.RelationActionParam;
import com.charles.dousheng.dto.RelationFollowListParam;
import com.charles.dousheng.dto.RelationFollowerListParam;
import com.charles.dousheng.dto.UserResult;

import java.util.List;

/**
 * @author charles
 * @date 5/1/2023 10:10 PM
 */
public interface RelationUserService {
    List<UserResult> relationFollowList(RelationFollowListParam relationFollowListParam);

    List<UserResult> relationFollowerList(RelationFollowerListParam relationFollowerListParam);

    int relationAction(RelationActionParam relationActionParam);
}
