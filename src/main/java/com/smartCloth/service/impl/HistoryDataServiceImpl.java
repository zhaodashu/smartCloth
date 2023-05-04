package com.smartCloth.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.smartCloth.model.HistoryDataModel;
import com.smartCloth.model.IntelligenceModel;
import com.smartCloth.model.UserModel;
import com.smartCloth.repository.HistoryDataRepository;
import com.smartCloth.repository.UserRepository;
import com.smartCloth.service.HistoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class HistoryDataServiceImpl implements HistoryDataService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryDataRepository historyDataRepository;


    @Override
    public JSONObject insertData(JSONObject param) {
        String openId = param.getString("openId");
        String nowStr = param.getString("nowStr");
        String createDate = param.getString("createDate");

        String[] arr = nowStr.split(",");
        Integer oxygen = Integer.parseInt(arr[0]);
        Integer dp = Integer.parseInt(arr[1]);
        Integer sp = Integer.parseInt(arr[2]);
        Integer heartRate = Integer.parseInt(arr[3]);
        Integer ecg = Integer.parseInt(arr[4]);

        JSONObject res = new JSONObject();

        Optional<UserModel> u = userRepository.findUserModelByOpenId(openId);
        if(!u.isPresent()){
            res.put("errorCode", 500);
            res.put("errorMsg", "没有找到这个用户");
            return res;
        }

        HistoryDataModel historyData = new HistoryDataModel();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            historyData.setDate(dateFormat.parse(createDate));
        } catch (Exception e) {
            res.put("errorCode", 501);
            res.put("errorMsg", "日期格式错误");
            return res;
        }
        historyData.setOpenId(openId);
        historyData.setOxygen(oxygen*0.1);
        historyData.setDp(dp);
        historyData.setSp(sp);
        historyData.setHeartRate(heartRate);
        historyData.setEcg(ecg);

        try {
            historyDataRepository.save(historyData);
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
    public JSONObject getHistoryData(JSONObject param) {
        String openId = param.getString("openId");
        JSONObject res = new JSONObject();

        Optional<UserModel> u = userRepository.findUserModelByOpenId(openId);
        if(!u.isPresent()){
            res.put("errorCode", 500);
            res.put("errorMsg", "没有找到这个用户");
            return res;
        }

        String date = param.getString("date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date day = null;
        try {
            day = dateFormat.parse(date);
        }catch (Exception e){
            res.put("errorCode", 500);
            res.put("errorMsg", "日期格式错误");
            return res;
        }

        System.out.println(day);

//        Object averageInfo = historyDataRepository.getAverageInfo(openId, day);

        Object averageOxygen = historyDataRepository.getAverageOxygen(openId, day);
        Object dp = historyDataRepository.getAverageDp(openId, day);
        Object sp = historyDataRepository.getAverageSp(openId, day);
        Object heartrate = historyDataRepository.getAverageHeartRate(openId, day);

        // SELECT hd.openid, hd.date, avg(hd.oxygen), avg(hd.dp), avg(hd.sp), avg(hd.heartrate)
        res.put("userId", openId);
        res.put("date", date);
        if(averageOxygen != null){
            res.put("oxygen", averageOxygen);
        }
        if(dp != null){
            res.put("dp", dp);
        }
        if(sp != null){
            res.put("sp", sp);
        }
        if(heartrate != null){
            res.put("heartrate", heartrate);
        }
        res.put("errorCode", 200);
        res.put("errorMsg", "获取当天平均值信息成功");
        return res;
    }
//发送给管理员的全部的人员生理数据
    @Override
    public JSONObject getAllHistoryDataForManager() {


        List<HistoryDataModel> list = historyDataRepository.getAllHistoryDataForManager();

        JSONObject res = new JSONObject();

        res.put("list", list);
        res.put("errorCode", 200);
        res.put("errorMsg", "获取列表成功");

        return res;
    }
}
