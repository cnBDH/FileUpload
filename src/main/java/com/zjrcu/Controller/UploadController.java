package com.zjrcu.Controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public String success(){
        return "upload";
    }

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
            String path = "F:\\JetBrainsWorkSpace\\IDEA WorkSpace\\location";

            File f = new File(path);
            if (!f.exists()){//如果文件路径不存在，就创建相关目录
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

    @RequestMapping("/")
    public String error(){
        return "error";
    }

}