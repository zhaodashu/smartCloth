package com.smartCloth.controller;
import com.alibaba.fastjson.JSONObject;
import com.smartCloth.service.ManagerService;
import com.smartCloth.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/manager")

public class ManagerController {
    @Resource
    ManagerService managerService;


    @PostMapping("/login")
    JSONObject managerLogin(@RequestBody JSONObject param){
        return managerService.managerLogin(param);
    }

}
