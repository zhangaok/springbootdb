package com.za.wh_db.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CsOrderItem {
    private String guid;

    private String orderGuid;

    private String organCode;

    private String contact;

    private String contactPhone;

    private String itemGuid;

    private String itemType;

    private BigDecimal price;

    private Integer number;

    private BigDecimal amount;

    private String province;

    private String city;

    private String county;

    private String provinceName;

    private String cityName;

    private String countyName;

    private String address;

    private BigDecimal serviceFee;

    private String serviceDate;

    private String serviceTime;

    private String allotType;

    private String servicePerson;

    private String remark;

    private String sendTime;

    private String startTime;

    private String completeTime;

    private Date createTime;

    private String createUser;
}