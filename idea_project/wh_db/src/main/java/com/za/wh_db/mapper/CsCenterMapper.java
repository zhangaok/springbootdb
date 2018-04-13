package com.za.wh_db.mapper;


import com.za.wh_db.domain.CsCenter;

import java.sql.SQLException;

public interface CsCenterMapper {
    int deleteByPrimaryKey(String guid) throws SQLException;

    int insert(CsCenter csCenter) throws SQLException;
}