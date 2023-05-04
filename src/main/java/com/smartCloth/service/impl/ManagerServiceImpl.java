package com.smartCloth.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.smartCloth.model.ManagerModel;
import com.smartCloth.model.UserModel;
import com.smartCloth.repository.ManagerRepository;
import com.smartCloth.repository.UserRepository;
import com.smartCloth.service.ManagerService;
import com.smartCloth.util.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;
@Service
public class ManagerServiceImpl implements ManagerService{

    @Autowired
    private ManagerRepository managerRepository;

    @Override
    public JSONObject managerLogin(JSONObject param) {
        JSONObject res = new JSONObject();
        String name = param.getString("name");
        String password = param.getString("password");


        ManagerModel managerModel = managerRepository.findManagerModelByName(name);
        if(name == null){
            res.put("errorCode", 500);
            res.put("errorMsg", "登录失败，用户不存在");
            return res;
        }
        if(password.equals(managerModel.getPassword())){
            res.put("errorCode", 200);
            res.put("errorMsg", "登陆成功");
            res.put("name", name);
            return res;
        }else{
            res.put("errorCode", 500);
            res.put("errorMsg", "登录失败，密码错误");
            res.put("name", name);
            return res;
        }
    }
}
