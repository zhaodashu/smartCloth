package com.smartCloth.service.impl;
import com.alibaba.fastjson.JSONObject;
import com.smartCloth.model.HistoryDataModel;
import com.smartCloth.model.IntelligenceModel;
import com.smartCloth.model.UserModel;
import com.smartCloth.model.WarningListModel;
import com.smartCloth.repository.HistoryDataRepository;
import com.smartCloth.repository.WarningListRepository;
import com.smartCloth.service.WarningListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class WarningListImpl implements WarningListService {

    @Autowired
    private WarningListRepository warningListRepository;


    @Override
    //向数据库中插入预警人员信息
    public JSONObject insertData(JSONObject param) {
        String openId = param.getString("openId");
        String nickname = param.getString("nickname");
        String nowStr = param.getString("nowStr");
        String createDate = param.getString("createDate");
        Double latitude = param.getDouble("latitude");
        Double longitude = param.getDouble("longitude");

        String[] arr = nowStr.split(",");
        Integer oxygen = Integer.parseInt(arr[0]);
        Integer dp = Integer.parseInt(arr[1]);
        Integer sp = Integer.parseInt(arr[2]);
        Integer heartRate = Integer.parseInt(arr[3]);
        Integer ecg = Integer.parseInt(arr[4]);

        JSONObject res = new JSONObject();

//        UserRepository userRepository;
//        Optional<UserModel> u = userRepository.findUserModelByOpenId(openId);
//        if(!u.isPresent()){
//            res.put("errorCode", 500);
//            res.put("errorMsg", "没有找到这个用户");
//            return res;
//        }

        WarningListModel warning = new WarningListModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            warning.setDate(dateFormat.parse(createDate));
        } catch (Exception e) {
            res.put("errorCode", 501);
            res.put("errorMsg", "日期格式错误");
            return res;
        }
        warning.setNickname(nickname);
        warning.setLatitude(latitude);
        warning.setLongitude(longitude);
        warning.setOxygen(oxygen*0.1);
        warning.setDp(dp);
        warning.setSp(sp);
        warning.setHeartRate(heartRate);
        warning.setEcg(ecg);

        try {
            warningListRepository.save(warning);
        }catch (Exception e){
            res.put("errorCode", 500);
            res.put("errorMsg", "插入失败");
            return res;
        }
        res.put("errorCode", 200);
        res.put("errorMsg", "插入成功");
        return res;
    }

    @Override
    public JSONObject getAllWarning() {
        //return null;
    }
}
