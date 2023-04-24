package com.smartCloth.service;

import com.alibaba.fastjson.JSONObject;

public interface IntelligenceService {

    JSONObject newInfo(String openId, String content, String createDate, String imgPath, String voicePath, String type);

    JSONObject infoList();
}
