package com.smartCloth.util;


import com.alibaba.fastjson.JSONObject;
import org.apache.http.entity.ContentType;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.text.SimpleDateFormat;
import java.util.*;

public class UploadUtils {

    private JSONObject upload(byte[] bytes, String fileName){

        JSONObject res = new JSONObject();

//        try{
//            // 数组转输入流
//            InputStream inputStream = new ByteArrayInputStream(bytes);
//            // 输入流转MultipartFile对象
//            MultipartFile file = new MockMultipartFile(ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
//
//            String path1 = "./files/";
//            path1 = path1 + "upload";
//
//            // 创建一个文件夹
//            Date date = new Date();
//            // 文件夹的名称
//            String path2 = new SimpleDateFormat("yyyyMMdd").format(date);
//            String paths = path1 + path2;
//
//            // 如果不存在，创建文件夹
//            File f = new File(paths);
//
//            File dest = new File(paths + "/" + fileName);
//            String relativePath = paths + "/" + fileName;
//            dest=new File(dest.getAbsolutePath());
//
//            long lastModified=dest.lastModified();
//
//            if (!f.exists()) {
//                f.mkdirs();
//                //如果文件夹不存在创建一个
//                file.transferTo(dest);
//            } else {
//                file.transferTo(dest);
//            }
//
//            res.put("path", relativePath);
//            res.put("time", date);
//
//        } catch (IOException e) {
//            e.printStackTrace();
//
//            res.put("errorCode", 500);
//            res.put("errorMsg", "上传失败");
//            return res;
//        }
//
//        res.put("errorCode", 200);
//        res.put("errorMsg", "上传成功");
//        return res;
        return res;
    }
}
