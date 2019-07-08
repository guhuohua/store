package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.base.UploadName;
import com.ch.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping(value = "upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping(value = "upload")
    public UploadName upload(MultipartFile file) {
        return uploadService.upload(file);
    }

    @PostMapping(value = "uploadFile")
    @CrossOrigin
    public ResponseResult uploadFile(HttpServletResponse response, MultipartFile file) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseResult result = new ResponseResult();
        try {
            long startTime=System.currentTimeMillis();
            result =  uploadService.uploadFile(file);
            long endTime=System.currentTimeMillis();
            System.out.println("程序运行时间： "+(endTime - startTime)+"ms");
            result.setCode(410);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("图片上传失败");
        }
        return result;
    }
}
