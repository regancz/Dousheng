package com.charles.dousheng.service.impl;

import cn.hutool.core.util.IdUtil;
import com.charles.dousheng.dto.*;
import com.charles.dousheng.mapper.VideoMapper;
import com.charles.dousheng.model.Video;
import com.charles.dousheng.service.MinioService;
import com.charles.dousheng.service.VideoService;
import org.apache.commons.compress.utils.IOUtils;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.FrameGrabber;
import org.bytedeco.javacv.Java2DFrameConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

/**
 * @author charles
 * @date 4/30/2023 5:41 PM
 */
@Service
public class VideoServiceImpl implements VideoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(VideoServiceImpl.class);
    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private MinioService minioService;

    @Override
    public FeedInfo feed(FeedParam feedParam) {
        return null;
    }

    @Override
    public int publishVideo(PublishVideoParam publishVideoParam) {
        try {
            File file = publishVideoParam.getData();
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(
                    publishVideoParam.getToken() + "-" + publishVideoParam.getTitle() + "-video.mp4", file.getName(),
                    "text/plain", IOUtils.toByteArray(input));
            MinioUploadDto minioUploadVideoDto = minioService.upload(multipartFile);
            BufferedImage bufferedImage = ExecuteFrame(file);
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            assert bufferedImage != null;
            ImageIO.write(bufferedImage, "jpg", out);
            MultipartFile mockMultipartFile = new MockMultipartFile(
                    publishVideoParam.getToken() + "-" + publishVideoParam.getTitle() + "-cover.jpg", out.toByteArray());
            MinioUploadDto minioUploadCoverDto = minioService.upload(mockMultipartFile);
            Video video = new Video(IdUtil.fastSimpleUUID(), publishVideoParam.getTitle(), , new Date(),
                    minioUploadVideoDto.getUrl(), minioUploadCoverDto.getUrl(), 0, 0);
            return videoMapper.insert(video);
        } catch (Exception e) {
            LOGGER.info("{}, {} publishVideo ERROR", publishVideoParam.getToken(), publishVideoParam.getTitle());
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public VideoResult publishedVideoList(UserParam userParam) {
        return null;
    }

    private BufferedImage ExecuteFrame(File videoFile) {
        try {
            FFmpegFrameGrabber grabber = new FFmpegFrameGrabber(videoFile);
            grabber.start();
            grabber.setFrameNumber(1);
            Java2DFrameConverter converter = new Java2DFrameConverter();
            BufferedImage image = converter.convert(grabber.grab());
            converter.close();
            grabber.stop();
            return image;
        } catch (Exception e) {
            LOGGER.info("{}, ExecuteFrame ERROR", videoFile.getName());
            e.printStackTrace();
            return null;
        }
    }
}
