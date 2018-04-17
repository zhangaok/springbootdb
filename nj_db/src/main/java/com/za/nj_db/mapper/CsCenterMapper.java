package com.za.nj_db.mapper;


import com.za.nj_db.domain.CsCenter;
import com.za.nj_db.domain.YmlInfo;

import java.sql.SQLException;
import java.util.List;

public interface CsCenterMapper {
    int deleteByPrimaryKey(String guid) throws SQLException;

    List<CsCenter> selectCsCenter(YmlInfo info) throws SQLException;
}