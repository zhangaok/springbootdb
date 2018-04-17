package com.za.nj_db.mapper;

import com.za.nj_db.domain.CsItemConfig;
import com.za.nj_db.domain.YmlInfo;

import java.sql.SQLException;
import java.util.List;

public interface CsItemConfigMapper {
    List<CsItemConfig> selectCsItemConfigInfo(YmlInfo info) throws SQLException;

    int deleteByPrimaryKey(String guid) throws SQLException;
}