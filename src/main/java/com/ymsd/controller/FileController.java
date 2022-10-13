package com.ymsd.controller;

import com.ymsd.util.ResponseCode;
import com.ymsd.util.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

@RestController
@Api(tags = "文件上传接口")
@RequestMapping("file")
public class FileController {

    @RequestMapping("/upload")
    public ResponseData importFile(MultipartFile file, HttpServletRequest request) {
        try {
            String dirPath = "C:/Users/Administrator/Desktop/resource/apache-tomcat-8.5.43/webapps/ymapp/img";
            //文件名通过UUID生成
            String uuid = UUID.randomUUID().toString().replaceAll("-","");
            String filePath = uuid+".png";
            boolean b = new File(dirPath).mkdirs();
            String a = dirPath + "/"+filePath;
            file.transferTo(new File(a).getAbsoluteFile());
            return new ResponseData(ResponseCode.SUCCESS,filePath);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseData(ResponseCode.FAIL);
        }
    }
}
