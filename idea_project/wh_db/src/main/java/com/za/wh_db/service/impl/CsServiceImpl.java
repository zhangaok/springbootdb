package com.za.wh_db.service.impl;

import com.za.wh_db.domain.CsCenter;
import com.za.wh_db.domain.CsItemConfig;
import com.za.wh_db.domain.CsOrder;
import com.za.wh_db.domain.CsOrderItem;
import com.za.wh_db.mapper.CsCenterMapper;
import com.za.wh_db.mapper.CsItemConfigMapper;
import com.za.wh_db.mapper.CsOrderItemMapper;
import com.za.wh_db.mapper.CsOrderMapper;
import com.za.wh_db.service.CsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;


/**
 * @author lide
 * @ClassName TestServiceImpl
 * @Description TODO
 * @date 2018年2月27日 下午4:14:57
 */
@Service
public class CsServiceImpl implements CsService {

    @Autowired
    private CsOrderMapper csOrderMapper;

    @Autowired
    private CsOrderItemMapper csOrderItemMapper;

    @Autowired
    private CsItemConfigMapper csItemConfigMapper;

    @Autowired
    private CsCenterMapper csCenterMapper;

    @Override
    @Transactional
    public String insertOrder(CsOrder csOrder) throws SQLException {
        if (csOrderMapper.deleteByPrimaryKey(csOrder.getGuid()) < 0) {
            return csOrder.getGuid();
        }
        if (csOrderMapper.insert(csOrder) < 1) {
            return csOrder.getGuid();
        }
        return "success";
    }

    @Override
    @Transactional
    public String insertOrderItem(CsOrderItem csOrderItem) throws SQLException {
        if (csOrderItemMapper.deleteByPrimaryKey(csOrderItem.getGuid()) < 0) {
            return csOrderItem.getGuid();
        }
        if (csOrderItemMapper.insert(csOrderItem) < 1) {
            return csOrderItem.getGuid();
        }
        return "success";
    }

    @Override
    @Transactional
    public String insertCsItemConfig(CsItemConfig csItemConfig) throws SQLException {
        if (csItemConfigMapper.deleteByPrimaryKey(csItemConfig.getGuid()) < 0) {
            return csItemConfig.getGuid();
        }
        if (csItemConfigMapper.insert(csItemConfig) < 1) {
            return csItemConfig.getGuid();
        }
        return "success";
    }

    @Override
    public String insertCsCenter(CsCenter csCenter) throws SQLException {
        if (csCenterMapper.deleteByPrimaryKey(csCenter.getGuid()) < 0) {
            return csCenter.getGuid();
        }
        if (csCenterMapper.insert(csCenter) < 1) {
            return csCenter.getGuid();
        }
        return "success";
    }
}
