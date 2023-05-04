package com.charles.dousheng.video.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author charles
 * @date 4/30/2023 9:07 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MinioUploadDto {
    @ApiModelProperty("文件访问URL")
    private String url;
    @ApiModelProperty("文件名称")
    private String name;
}
