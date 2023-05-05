package com.charles.dousheng.video.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author charles
 * @date 5/5/2023 11:51 AM
 */
@Setter
@Getter
public class UserReadHistoryDto {
    private List<VideoResult> videoResultList;
    private Long userId;
}
