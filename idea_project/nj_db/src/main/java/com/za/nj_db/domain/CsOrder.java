package com.za.nj_db.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class CsOrder {
    private String guid;

    private String organCode;

    private String orderNo;

    private String orderOwner;

    private String ownerPhone;

    private BigDecimal totalAmount;

    private BigDecimal extraAmount;

    private BigDecimal serviceFee;

    private BigDecimal payAmount;

    private BigDecimal discountAmount;

    private String isVip;

    private String cardNo;

    private String isPay;

    private String isComplete;

    private String isVisit;

    private String isCancel;

    private String status;

    private String isRefund;

    private String isEvaluate;

    private String userGuid;

    private String source;

    private Date createTime;

    private String createUser;

    private String visitTime;

    private String visitRecord;

    private String visitResult;

    private String visitor;

}