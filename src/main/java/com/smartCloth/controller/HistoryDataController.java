package com.smartCloth.controller;

import com.alibaba.fastjson.JSONObject;
import com.smartCloth.service.HistoryDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/historyData")
public class HistoryDataController {

    @Autowired
    HistoryDataService historyDataService;

    @PostMapping("/insert")
    JSONObject insertData(@RequestBody JSONObject param){
        return historyDataService.insertData(param);
    }

    @PostMapping("/info")
    JSONObject getHistoryData(@RequestBody JSONObject param){
        return historyDataService.getHistoryData(param);
    }


    @PostMapping("/allForManager")//返回给管理员所有人员最新状态
    JSONObject getAllHistoryDataForManager(){
        return historyDataService.getAllHistoryDataForManager();
    }

}
