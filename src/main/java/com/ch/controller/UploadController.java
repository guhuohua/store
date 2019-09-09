package com.ch.controller;

import com.ch.base.ResponseResult;
import com.ch.base.UploadName;
import com.ch.config.UploadImgProperties;
import com.ch.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "upload")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @Autowired
    UploadImgProperties uploadImgProperties;

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
            result =  uploadService.uploadFile(file);
            result.setCode(410);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("图片上传失败");
        }
        return result;
    }

    @PostMapping(value = "uploadExcel")
    @CrossOrigin
    public ResponseResult uploadExcel(HttpServletResponse response, MultipartFile file) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseResult result = new ResponseResult();
        try {
            result =  uploadService.uploadExcel(file);
            result.setCode(410);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("excel导入失败");
        }
        return result;
    }

    @PostMapping(value = "uploadLookShop")
    @CrossOrigin
    public ResponseResult uploadLookShop(HttpServletResponse response, MultipartFile file) {
        response.setHeader("Access-Control-Allow-Origin", "*");
        ResponseResult result = new ResponseResult();
        try {
            result =  uploadService.uploadLookShop(file);
            result.setCode(410);
        } catch (Exception e) {
            e.printStackTrace();
            result.setCode(500);
            result.setError(e.getMessage());
            result.setError_description("excel导入失败");
        }
        return result;
    }

    @PostMapping(value = "uploadImage")
    @CrossOrigin
    public ResponseResult uploadImage(HttpServletRequest request, HttpServletResponse response, List<MultipartFile> file) {
        ResponseResult result = new ResponseResult();
        String path = uploadImgProperties.getImg();
        for (MultipartFile multipartFile:file) {
            String originalName = multipartFile.getOriginalFilename();
            String imgRealPath = path + originalName;
            File imageFile=new File(imgRealPath);
            try {
                multipartFile.transferTo(imageFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
