package com.smartCloth.service;

import com.alibaba.fastjson.JSONObject;

public interface UserService {

    JSONObject login(JSONObject param);

    JSONObject getUser(JSONObject param);

    JSONObject insertUser(JSONObject param);

    JSONObject editUser(JSONObject param);

    JSONObject deleteUser(JSONObject param);
}
