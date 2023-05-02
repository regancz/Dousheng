package com.charles.dousheng.service;

import com.charles.dousheng.dto.FavoriteActionParam;
import com.charles.dousheng.dto.UserParam;
import com.charles.dousheng.dto.VideoResult;

import java.util.List;

/**
 * @author charles
 * @date 5/1/2023 10:09 PM
 */
public interface FavoriteVideoService {
    List<VideoResult> favoriteList(UserParam userParam);

    int favoriteAction(FavoriteActionParam favoriteActionParam);
}
