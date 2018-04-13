package com.za.nj_db.mapper;


import com.za.nj_db.domain.CsOrderItem;
import com.za.nj_db.domain.YmlInfo;

import java.sql.SQLException;
import java.util.List;

public interface CsOrderItemMapper {

    List<CsOrderItem> selectOrderItemInfo(YmlInfo info) throws SQLException;

    int deleteByPrimaryKey(String guid) throws SQLException;
}