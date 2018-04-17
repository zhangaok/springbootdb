package com.za.nj_db.service;

import com.za.nj_db.domain.*;

import java.sql.SQLException;
import java.util.List;

public interface CsDaoService {
    List<CsOrder> getOrderInfo(YmlInfo info) throws SQLException;

    List<CsOrderItem> getOrderItemInfo(YmlInfo info) throws SQLException;

    List<CsItemConfig> getCsItemConfigInfo(YmlInfo info) throws SQLException;

    List<CsCenter> getCsCenterInfo(YmlInfo info) throws SQLException;

    int deleteOrder(String guid) throws SQLException;

    int deleteOrderItem(String guid) throws SQLException;

    int deleteItemConfig(String guid) throws SQLException;

    int deleteCsCenter(String guid) throws SQLException;
}