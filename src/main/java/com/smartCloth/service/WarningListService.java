package com.smartCloth.service;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

public interface WarningListService {
    JSONObject insertData(@RequestBody JSONObject param);
    JSONObject getAllWarning();
}
