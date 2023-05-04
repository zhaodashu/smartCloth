package com.smartCloth.service;

import com.alibaba.fastjson.JSONObject;
import com.smartCloth.model.UserModel;

import java.util.List;

public interface UserService {

    JSONObject login(JSONObject param);

    JSONObject getUser(JSONObject param);

    JSONObject insertUser(JSONObject param);

    JSONObject editUser(JSONObject param);

    JSONObject deleteUser(JSONObject param);
}
