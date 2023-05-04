package com.charles.dousheng.video.service;

import com.charles.dousheng.video.dto.RelationActionParam;
import com.charles.dousheng.video.dto.RelationFollowListParam;
import com.charles.dousheng.video.dto.RelationFollowerListParam;
import com.charles.dousheng.video.dto.UserResult;

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
