package com.smartCloth.service;

import com.alibaba.fastjson.JSONObject;

public interface HistoryDataService {

    JSONObject insertData(JSONObject param);
    JSONObject getHistoryData(JSONObject param);
}
