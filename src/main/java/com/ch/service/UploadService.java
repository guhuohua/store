package com.ch.service;

import com.ch.base.ResponseResult;
import com.ch.base.UploadName;
import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

    /**
     * 文件上传
     *
     * @param file
     * @return
     */
    UploadName upload(MultipartFile file);

    ResponseResult uploadFile(MultipartFile file);

    /**
     * 上传excel
     * @param file
     * @return
     */
    ResponseResult uploadExcel(MultipartFile file);


    ResponseResult uploadAddress(String address);
}
