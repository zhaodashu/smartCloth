package com.smartCloth.model;


import javax.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * 用户信息
 * @author zmm
 */

@Entity
@Data
@Table(name = "history_data")
public class HistoryDataModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date;

    @Column(name = "oxygen")
    private Double oxygen;

    @Column(name = "dp")
    private Integer dp;

    @Column(name = "sp")
    private Integer sp;

    @Column(name = "heartrate")
    private Integer heartRate;

    @Column(name = "ecg")
    private Integer ecg;

    @Column(name = "openid")
    private String openId;
}
