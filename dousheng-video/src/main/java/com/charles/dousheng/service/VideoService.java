package com.charles.dousheng.service;

import com.charles.dousheng.dto.*;

import java.io.FileNotFoundException;

/**
 * @author charles
 * @date 4/30/2023 5:40 PM
 */
public interface VideoService {
    FeedInfo feed(FeedParam feedParam);

    int publishVideo(PublishVideoParam publishVideoParam) throws FileNotFoundException, Exception;

    VideoResult publishedVideoList(UserParam userParam);
}
