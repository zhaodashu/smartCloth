package com.smartCloth.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.smartCloth.conf.WechatConfig;
import com.smartCloth.model.UserModel;
import com.smartCloth.repository.UserRepository;
import com.smartCloth.service.UserService;
import com.smartCloth.util.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public JSONObject login(JSONObject param) {

        String code = param.getString("code");

        JSONObject res = new JSONObject();

        JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(code);
        String openid = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        if(openid != null){
            Optional<UserModel> u = userRepository.findUserModelByOpenId(openid);
            UserModel user = null;
            if(!u.isPresent()){
                user = new UserModel();
            }else{
                user = u.get();
            }
            user.setSessionKey(sessionKey);
            user.setOpenId(openid);

            try {
                userRepository.save(user);
            } catch (Exception e){
                res.put("errorCode", 500);
                res.put("errorMsg", "登录失败");
                return res;
            }
            res.put("errorCode", 200);
            res.put("errorMsg", "登陆成功");
            res.put("openId", openid);
            return res;
        }

        res.put("errorCode", 500);
        res.put("errorMsg", "登录失败");
        return res;
    }

    @Override
    public JSONObject getUser(JSONObject param) {
        String openId = param.getString("openId");

        JSONObject res = new JSONObject();

        Optional<UserModel> u = userRepository.findUserModelByOpenId(openId);
        if(!u.isPresent()){
            res.put("errorCode", 500);
            res.put("errorMsg", "获取用户信息失败");
            return res;
        }
        UserModel user = u.get();
        res.put("nickname", user.getNickname());
        res.put("image", user.getImage());
        res.put("gender", user.getGender());
        res.put("age", user.getUserAge());
        res.put("height", user.getUserHeight());
        res.put("weight", user.getUserWeight());
        res.put("errorCode", 200);
        res.put("errorMsg", "获取用户信息成功");
        return res;
    }

    @Override
    public JSONObject insertUser(JSONObject param) {
        String openId = param.getString("openId");
        String image = param.getString("image");
        String nickname = param.getString("nickname");
        Integer gender = param.getInteger("gender");
        Integer age = param.getInteger("age");
        Double height = param.getDouble("height");
        Double weight = param.getDouble("weight");
        //获取数据
        //新建一个用户
        Optional<UserModel> userModelByUsername = userRepository.findUserModelByOpenId(openId);
        JSONObject res = new JSONObject();
        if(!userModelByUsername.isPresent()){
            res.put("errorCode",500);
            res.put("errorMsg","用户openid不存在");
            return res;
        }
        //重新设置信息的参数
        UserModel user = userModelByUsername.get();
        user.setImage(image);
        user.setNickname(nickname);
        user.setGender(gender);
        user.setUserAge(age);
        user.setUserHeight(height);
        user.setUserWeight(weight);

        //用save存在数据库中
        try {
            userRepository.save(user);
        } catch (Exception var14) {
            res.put("errorCode", 500);
            res.put("errorMsg", "插入失败");
            return res;
        }

        res.put("errorCode", 200);
        res.put("errorMsg", "新建用户信息成功");
        return res;
    }

    @Override
    public JSONObject editUser(JSONObject param) {
        String openId = param.getString("openId");
        String image = param.getString("image");
        String nickname = param.getString("nickname");
        Integer gender = param.getInteger("gender");
        Integer age = param.getInteger("age");
        Double height = param.getDouble("height");
        Double weight = param.getDouble("weight");
        //获取数据
        //新建一个用户
        Optional<UserModel> userModelByUsername = userRepository.findUserModelByOpenId(openId);
        JSONObject res = new JSONObject();
        if(!userModelByUsername.isPresent()){
            res.put("errorCode",500);
            res.put("errorMsg","用户openid不存在");
            return res;
        }
        //重新设置信息的参数
        UserModel user = userModelByUsername.get();
        user.setImage(image);
        user.setNickname(nickname);
        user.setGender(gender);
        user.setUserAge(age);
        user.setUserHeight(height);
        user.setUserWeight(weight);

        //用save存在数据库中
        try {
            userRepository.save(user);
        } catch (Exception var14) {
            res.put("errorCode", 500);
            res.put("errorMsg", "编辑失败");
            return res;
        }

        res.put("errorCode", 200);
        res.put("errorMsg", "编辑用户信息成功");
        return res;
    }

    @Override
    public JSONObject deleteUser(JSONObject param) {
        String openId = param.getString("openId");
        JSONObject res = new JSONObject();

        Optional<UserModel> userModelByUsername = userRepository.findUserModelByOpenId(openId);

        if(!userModelByUsername.isPresent()){
            res.put("errorCode",500);
            res.put("errorMsg","用户openid不存在");
            return res;
        }
        //重新设置信息的参数
        UserModel user = userModelByUsername.get();
        try {
            userRepository.deleteById(user.getId());
        } catch (Exception var5) {
            res.put("errorCode", 500);
            res.put("errorMsg", "删除失败");
            return res;
        }
        res.put("errorCode", 200);
        res.put("errorMsg", "删除成功");
        return res;

    }
}
