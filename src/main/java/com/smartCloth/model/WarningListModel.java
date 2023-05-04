package com.smartCloth.model;
import javax.persistence.*;
import lombok.Data;

import java.text.DecimalFormat;
import java.util.Date;

@Entity
@Data
@Table(name = "warning_list")
public class WarningListModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "nickname", nullable = false)
  private String nickname;

  @Column(name = "date", nullable = false)
  @Temporal(TemporalType.DATE)
  private Date date;

  @Column(name = "longitude", nullable = false)
  private Double longitude;

  @Column(name = "latitude", nullable = false)
  private Double latitude;

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

}
