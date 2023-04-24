package com.smartCloth.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value = "classpath:wechat.properties")
@ConfigurationProperties(prefix="smartcloth")
public class WechatConfig {

    private String appSecret;
    private String appID;
    private String url;
    private String grantType;

}
