package com.smartCloth.model;

import lombok.Data;
import javax.persistence.*;
/**
 * 管理员信息
 * @author dmx
 */

@Entity
@Data
@Table(name = "manager")
public class ManagerModel{

    //账号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="password")
    private String password;

    @Column(name="type")
    private String type;



}