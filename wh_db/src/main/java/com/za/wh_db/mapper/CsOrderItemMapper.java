package com.za.wh_db.mapper;


import com.za.wh_db.domain.CsOrderItem;

import java.sql.SQLException;

public interface CsOrderItemMapper {

    int deleteByPrimaryKey(String guid) throws SQLException;

    int insert(CsOrderItem csOrderItem) throws SQLException;
}