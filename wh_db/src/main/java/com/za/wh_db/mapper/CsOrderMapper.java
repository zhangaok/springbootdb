package com.za.wh_db.mapper;

import com.za.wh_db.domain.CsOrder;

import java.sql.SQLException;

public interface CsOrderMapper {

    int deleteByPrimaryKey(String guid) throws SQLException;

    int insert(CsOrder csOrder) throws SQLException;
}