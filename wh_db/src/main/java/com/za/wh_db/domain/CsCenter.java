package com.za.wh_db.domain;

import lombok.Data;

import java.util.Date;

@Data
public class CsCenter {
    private String guid;

    private String companyCode;

    private String name;

    private String contact;

    private String phone;

    private String address;

    private String logo;

    private String legalPerson;

    private String legalPhone;

    private String legalIdCard;

    private String businessLicense;

    private String status;

    private String picture;

    private String openTime;

    private String closeTime;

    private String grade;

    private String provinceCode;

    private String provinceName;

    private String cityCode;

    private String cityName;

    private String countyCode;

    private String countyName;

    private String townCode;

    private String townName;

    private String villageCode;

    private String villageName;

    private Date createTime;

    private String createUser;

    private String content;

    private String notice;
}