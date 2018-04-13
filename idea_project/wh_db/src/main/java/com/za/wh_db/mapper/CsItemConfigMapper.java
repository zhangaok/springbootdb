package com.za.wh_db.mapper;

import com.za.wh_db.domain.CsItemConfig;

import java.sql.SQLException;

public interface CsItemConfigMapper {

    int deleteByPrimaryKey(String guid) throws SQLException;

    int insert(CsItemConfig csItemConfig) throws SQLException;
}