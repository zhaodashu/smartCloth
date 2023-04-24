package com.smartCloth.controller;


import com.alibaba.fastjson.JSONObject;
import com.smartCloth.service.IntelligenceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/intelligence")
public class IntelligenceController {

    @Autowired
    IntelligenceService intelligenceService;

    @PostMapping("/newInfo")
    JSONObject newInfo(@RequestParam(name = "image", required = false) MultipartFile file1,
                       @RequestParam(name = "voice", required = false) MultipartFile file2,
                       @RequestParam(name = "openId", required = true) String openId,
                       @RequestParam(name = "createDate", required = true) String createDate,
                       @RequestParam(name = "type", required = true) String type,
                       @RequestParam(name = "content", required = true) String content){
        System.out.println("openId: "+ openId);
        System.out.println("createDate: "+ createDate);
        System.out.println("content: "+ content);
        System.out.println("type: " + type);

        System.out.println(file1);
        System.out.println(file2);

        JSONObject res = new JSONObject();

        String path1 = "/home/smartCloth/static/";
        String img_path1 =  "image/";
        String voice_path1 = "voice/";
        // 创建一个文件夹
        Date date = new Date();
        // 文件夹的名称
        String path2 = new SimpleDateFormat("yyyyMMdd").format(date);

        String imgPath = "";
        String voicePath = "";

        if (file1!= null && !file1.isEmpty()){
            String img_paths = path1 + img_path1 + path2;
            System.out.println("img_paths: " + img_paths);
            //如果不存在,创建文件夹
            File f = new File(img_paths);
            String img_name = file1.getOriginalFilename(); // 获取原名称

            File dest =  new File(img_paths + "/" + img_name);
            imgPath = img_path1 + path2 + "/" + img_name;
            dest=new File(dest.getAbsolutePath());
            long lastModified=dest.lastModified();

            try {
                if (!f.exists()) {
                    f.mkdirs();
                    //如果文件夹不存在创建一个
                    file1.transferTo(dest);
                } else {
                    file1.transferTo(dest);
                }
            }catch (IOException e) {
                e.printStackTrace();
                res.put("errorCode", 500);
                res.put("errorMsg", "图片上传失败");
                return res;
            }

            res.put("imgPath", imgPath);
        }

        if (file2 != null && !file2.isEmpty()){
            String voice_paths = path1 + voice_path1 + path2;
            //如果不存在,创建文件夹
            File f = new File(voice_paths);
            String voice_name = file2.getOriginalFilename(); // 获取原名称

            File dest =  new File(voice_paths + "/" + voice_name);
            voicePath = voice_path1 + path2 + "/" + voice_name;
            dest=new File(dest.getAbsolutePath());
            long lastModified=dest.lastModified();

            try {
                if (!f.exists()) {
                    f.mkdirs();
                    //如果文件夹不存在创建一个
                    file2.transferTo(dest);
                } else {
                    file2.transferTo(dest);
                }
            }catch (IOException e) {
                e.printStackTrace();
                res.put("errorCode", 500);
                res.put("errorMsg", "音频上传失败");
                return res;
            }

            res.put("voicePath", voicePath);
        }

        JSONObject temp = intelligenceService.newInfo(openId, content, createDate, imgPath, voicePath, type);

        Integer errorCode = temp.getInteger("errorCode");

        System.out.println("1111111111111111111111" + errorCode);

        if(errorCode != 200){
            res.put("errorCode", 500);
            res.put("errorMsg", temp.getString("errorMsg"));
            return res;
        }

        res.put("errorCode", 200);
        res.put("errorMsg", "上传成功");

        return res;
    }


    @PostMapping("/list")
    JSONObject infoList(){
        return intelligenceService.infoList();
    }


}
