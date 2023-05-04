package com.charles.dousheng.video.service;

import com.charles.dousheng.video.dto.FavoriteActionParam;
import com.charles.dousheng.video.dto.UserParam;
import com.charles.dousheng.video.dto.VideoResult;

import java.util.List;

/**
 * @author charles
 * @date 5/1/2023 10:09 PM
 */
public interface FavoriteVideoService {
    List<VideoResult> favoriteList(UserParam userParam);

    int favoriteAction(FavoriteActionParam favoriteActionParam);
}
