package com.smartCloth.service;

import com.alibaba.fastjson.JSONObject;
import com.smartCloth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface HistoryDataService {

    JSONObject insertData(JSONObject param);
    JSONObject getHistoryData(JSONObject param);
    JSONObject getAllHistoryDataForManager();
}
