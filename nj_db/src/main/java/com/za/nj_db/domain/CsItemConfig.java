package com.za.nj_db.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CsItemConfig {
    private String guid;

    private String organCode;

    private String typeGuid;

    private String itemName;

    private String itemPic;

    private Integer advanceHours;

    private BigDecimal itemPrice;

    private BigDecimal vipPrice;

    private String itemUnit;

    private Integer minBuyNum;

    private String itemType;

    private BigDecimal serviceFee;

    private String status;

    private Date createTime;

    private String createUser;

    private String content;


}