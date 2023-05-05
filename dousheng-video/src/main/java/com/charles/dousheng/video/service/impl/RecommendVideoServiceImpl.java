package com.charles.dousheng.video.service.impl;

import com.charles.dousheng.mbg.mapper.VideoMapper;
import com.charles.dousheng.mbg.model.Video;
import com.charles.dousheng.mbg.model.VideoExample;
import com.charles.dousheng.video.service.RecommendVideoService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author charles
 * @date 5/5/2023 3:26 PM
 */
public class RecommendVideoServiceImpl implements RecommendVideoService {
    @Autowired
    private VideoMapper videoMapper;
    /**
     * 计算两个向量之间的余弦相似度
     */
    public static double cosineSimilarity(double[] vector1, double[] vector2) {
        double dotProduct = 0.0;
        double norm1 = 0.0;
        double norm2 = 0.0;
        for (int i = 0; i < vector1.length; i++) {
            dotProduct += vector1[i] * vector2[i];
            norm1 += Math.pow(vector1[i], 2);
            norm2 += Math.pow(vector2[i], 2);
        }
        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }

    /**
     * 根据余弦相似度进行推荐
     * @param userId
     */
    @Override
    public void updateRecommendVideo(Long userId) {
        // 选择近两小时的视频中进行推荐
        VideoExample videoExample = new VideoExample();
        videoExample.createCriteria().andCreateTimeLessThanOrEqualTo();
        List<Video> videos = videoMapper.selectByExample(videoExample);
        // 计算每个视频的特征向量
        double[][] features = new double[videos.size()][2];
        for (int i = 0; i < videos.size(); i++) {
            Video video = videos.get(i);
            features[i][0] = video.getCommentCount();
            features[i][1] = video.getFavoriteCount();
        }
        // 计算视频之间的相似度矩阵
        double[][] similarityMatrix = new double[videos.size()][videos.size()];
        for (int i = 0; i < videos.size(); i++) {
            for (int j = 0; j < videos.size(); j++) {
                similarityMatrix[i][j] = cosineSimilarity(features[i], features[j]);
            }
        }
        // 对于每个视频，找到与其最相似的前30个视频
        List<Integer> similarVideos = new ArrayList<>();
        for (int i = 0; i < videos.size(); i++) {
            for (int j = 0; j < videos.size(); j++) {
                if (i != j) {
                    similarVideos.add(j);
                }
            }
            int finalI = i;
            similarVideos.sort((o1, o2) -> Double.compare(similarityMatrix[finalI][o2], similarityMatrix[finalI][o1]));
        }
    }
}
