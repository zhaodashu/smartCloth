package com.smartCloth.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class WechatUtil {
    public static JSONObject getSessionKeyOrOpenId(String code) {
        String requestUrl = "https://api.weixin.qq.com/sns/jscode2session";
        Map<String, String> requestUrlParam = new HashMap<>();
        //小程序appId
        requestUrlParam.put("appid", "wx1c05b05dfe1a371a");
        //小程序secret
        requestUrlParam.put("secret", "e9b2e41d2793afaabb3ce3ae86c13a51");
        //小程序端返回的code
        requestUrlParam.put("js_code", code);
        //默认参数
        requestUrlParam.put("grant_type", "authorization_code");
        //发送post请求读取调用微信接口获取openid用户唯一标识
        JSONObject jsonObject = JSON.parseObject(HttpClientUtil.doPost(requestUrl, requestUrlParam));
        return jsonObject;
    }
}
