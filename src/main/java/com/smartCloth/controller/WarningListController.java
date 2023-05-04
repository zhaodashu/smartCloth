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
@RequestMapping("/warning")
public class WarningListController {
    @Autowired
    WainingListService warningListService;

    @PostMapping("/newWarning")
    JSONObject insertData(@RequestBody JSONObject param){
        return warningListService.insertData(param);
    }
    @PostMapping("/allWarning")
    JSONObject getAllWarning(){
        return warningListService.getAllWarning();
    }


}
