package com.za.wh_db.service;

import com.za.wh_db.domain.CsCenter;
import com.za.wh_db.domain.CsItemConfig;
import com.za.wh_db.domain.CsOrder;
import com.za.wh_db.domain.CsOrderItem;

import java.sql.SQLException;

public interface CsService {
    String insertOrder(CsOrder csOrder) throws SQLException;

    String insertOrderItem(CsOrderItem csOrderItem) throws SQLException;

    String insertCsItemConfig(CsItemConfig csItemConfig) throws SQLException;

    String insertCsCenter(CsCenter csCenter) throws SQLException;
}