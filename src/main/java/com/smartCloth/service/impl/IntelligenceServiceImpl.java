package com.smartCloth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smartCloth.model.IntelligenceModel;
import com.smartCloth.model.UserModel;
import com.smartCloth.repository.IntelligenceRepository;
import com.smartCloth.repository.UserRepository;
import com.smartCloth.service.IntelligenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class IntelligenceServiceImpl implements IntelligenceService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private IntelligenceRepository intelligenceRepository;

    @Override
    public JSONObject newInfo(String openId, String content, String createDate, String imgPath, String voicePath, String type) {

        JSONObject res = new JSONObject();

        Optional<UserModel> userModel = userRepository.findUserModelByOpenId(openId);

        if (!userModel.isPresent()){
            res.put("errorCode", 500);
            res.put("errorMsg", "openId错误");
            return res;
        }

        UserModel user = userModel.get();

        String nickname = user.getNickname();

        System.out.println("=================nickname: " + nickname);

        IntelligenceModel intelligenceModel = new IntelligenceModel();

        intelligenceModel.setInfo(content);
        intelligenceModel.setOpenId(openId);
        intelligenceModel.setNickname(nickname);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date time = null;
        try {
            time = dateFormat.parse(createDate);
        }catch (Exception e){
            res.put("errorCode", 500);
            res.put("errorMsg", "日期格式错误");
            return res;
        }

        intelligenceModel.setTime(time);

        intelligenceModel.setImage(imgPath);
        intelligenceModel.setVoice(voicePath);
        intelligenceModel.setType(Integer.parseInt(type));
        
        try {
            intelligenceRepository.save(intelligenceModel);
        }catch (Exception var14){
            res.put("errorCode", 500);
            res.put("errorMsg", "添加失败");
            return res;
        }

        res.put("errorCode", 200);
        res.put("errorMsg", "添加成功");
        return res;
    }

    @Override
    public JSONObject infoList() {

        long count = intelligenceRepository.count();

        List<IntelligenceModel> list = intelligenceRepository.findAll();

        JSONObject res = new JSONObject();

        res.put("count", count);
        res.put("list", list);
        res.put("errorCode", 200);
        res.put("errorMsg", "获取列表成功");

        return res;
    }
}
