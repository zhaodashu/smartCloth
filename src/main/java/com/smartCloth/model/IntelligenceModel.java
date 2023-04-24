package com.smartCloth.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@Table(name = "intelligence")
public class IntelligenceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "openid")
    private String openId;

    @Column(name = "nickname")
    private String nickname;

    // 类型，1 2 3 4
    @Column(name = "type")
    private Integer type;

    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;

    // 内容
    @Column(name = "info")
    private String info;

    // 图片保存路径
    @Column(name = "image")
    private String image;

    // 音频保存路径
    @Column(name = "voice")
    private String voice;




}
