package com.charles.dousheng.video.service;

import com.charles.dousheng.video.dto.MinioUploadDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author charles
 * @date 4/30/2023 9:03 PM
 */
public interface MinioService {
    MinioUploadDto upload(MultipartFile file);
}
