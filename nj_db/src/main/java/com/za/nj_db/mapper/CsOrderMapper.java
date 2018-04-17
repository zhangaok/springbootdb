package com.za.nj_db.mapper;

import com.za.nj_db.domain.CsOrder;
import com.za.nj_db.domain.YmlInfo;

import java.sql.SQLException;
import java.util.List;

public interface CsOrderMapper {

    List<CsOrder> selectOrderInfo(YmlInfo info) throws SQLException;

    int deleteByPrimaryKey(String guid) throws SQLException;
}