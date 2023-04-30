package com.charles.dousheng.service.impl;

import com.charles.dousheng.dto.*;
import com.charles.dousheng.service.VideoService;
import org.springframework.stereotype.Service;

/**
 * @author charles
 * @date 4/30/2023 5:41 PM
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Override
    public FeedInfo feed(FeedParam feedParam) {
        return null;
    }

    @Override
    public int publishVideo(PublishVideoParam publishVideoParam) {
        return count;
    }

    @Override
    public VideoResult publishedVideoList(UserParam userParam) {
        return null;
    }
}
