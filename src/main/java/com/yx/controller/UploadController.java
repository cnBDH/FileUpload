package com.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author YinXiong
 */
@Controller
public class UploadController {

    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        if (file.isEmpty()) {
            return "上传的文件不能为空";
        }
        try {
            System.out.println("文件类型ContentType:"+file.getContentType());
            System.out.println("文件组件名称Name:"+file.getName());
            System.out.println("文件大小:"+file.getSize());
            System.out.println("文件原名称OriginalFileName:"+file.getOriginalFilename());
            String path = "F:\\JetBrainsWorkSpace\\upload";

            File f = new File(path);
            //如果文件路径不存在，就创建相关目录
            if (!f.exists()){
                f.mkdir();
            }
            // 文件写入
            File dir = new File(path+"\\" +file.getOriginalFilename());
            file.transferTo(dir);

            return "上传单个文件成功";
        }catch (Exception e) {
            e.printStackTrace();
            return "上传单个文件失败";
        }
    }

}