package com.smartCloth.model;


import lombok.Data;
import javax.persistence.*;
import java.sql.Blob;

/**
 * 用户信息
 * @author zmm
 */

@Entity
@Data
@Table(name = "user")
public class UserModel {

    // 账号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    // 微信平台用户身份id
    @Column(name = "openid", length = 32, nullable = false)
    private String openId;

    // 微信平台用户身份id
    @Column(name = "sessionkey", length = 256, nullable = true)
    private String sessionKey;

    // 头像
    @Column(name = "image", nullable = true)
    private String image;

    // 年龄
    @Column(name = "uage")
    private Integer userAge;

    // 身高
    @Column(name = "uheight")
    private Double userHeight;

    // 体重
    @Column(name = "uweight")
    private Double userWeight;

    // 性别， 男生1 女生0
    @Column(name = "gender")
    private Integer gender;

    // 昵称
    @Column(name = "nickname")
    private String nickname;



}
