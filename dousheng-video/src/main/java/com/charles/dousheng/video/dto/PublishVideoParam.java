package com.charles.dousheng.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * @author charles
 * @date 4/30/2023 5:52 PM
 */
@Getter
@Setter
public class PublishVideoParam {
    @ApiModelProperty("用户鉴权token")
    private String token;
    @ApiModelProperty("视频数据")
    private File data;
    @ApiModelProperty("视频标题")
    private String title;
}
