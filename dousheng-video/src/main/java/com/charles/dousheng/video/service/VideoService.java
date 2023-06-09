package com.charles.dousheng.video.service;

import com.charles.dousheng.video.dto.*;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author charles
 * @date 4/30/2023 5:40 PM
 */
public interface VideoService {
    FeedInfo feed(FeedParam feedParam);

    int publishVideo(PublishVideoParam publishVideoParam) throws FileNotFoundException, Exception;

    List<VideoResult> publishedVideoList(UserParam userParam);
}
