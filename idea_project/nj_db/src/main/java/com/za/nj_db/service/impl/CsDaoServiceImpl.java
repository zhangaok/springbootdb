package com.za.nj_db.service.impl;

import com.za.nj_db.domain.*;
import com.za.nj_db.mapper.CsCenterMapper;
import com.za.nj_db.mapper.CsItemConfigMapper;
import com.za.nj_db.mapper.CsOrderItemMapper;
import com.za.nj_db.mapper.CsOrderMapper;
import com.za.nj_db.service.CsDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;


/**
 * @author lide
 * @ClassName TestServiceImpl
 * @Description TODO
 * @date 2018年2月27日 下午4:14:57
 */
@Service
public class CsDaoServiceImpl implements CsDaoService {

    @Autowired
    private CsOrderMapper csOrderMapper;

    @Autowired
    private CsOrderItemMapper csOrderItemMapper;

    @Autowired
    private CsItemConfigMapper csItemConfigMapper;

    @Autowired
    private CsCenterMapper csCenterMapper;

    @Override
    public List<CsOrder> getOrderInfo(YmlInfo info) throws SQLException {
        return csOrderMapper.selectOrderInfo(info);
    }

    @Override
    public List<CsOrderItem> getOrderItemInfo(YmlInfo info) throws SQLException {
        return csOrderItemMapper.selectOrderItemInfo(info);
    }

    @Override
    public List<CsItemConfig> getCsItemConfigInfo(YmlInfo info) throws SQLException {
        return csItemConfigMapper.selectCsItemConfigInfo(info);
    }

    @Override
    public List<CsCenter> getCsCenterInfo(YmlInfo info) throws SQLException {
        return csCenterMapper.selectCsCenter(info);
    }

    @Override
    @Transactional
    public int deleteOrder(String guid) throws SQLException {
        return csOrderMapper.deleteByPrimaryKey(guid);
    }

    @Override
    @Transactional
    public int deleteOrderItem(String guid) throws SQLException {
        return csOrderItemMapper.deleteByPrimaryKey(guid);
    }

    @Override
    @Transactional
    public int deleteItemConfig(String guid) throws SQLException {
        return csItemConfigMapper.deleteByPrimaryKey(guid);
    }

    @Override
    public int deleteCsCenter(String guid) throws SQLException {
        return csCenterMapper.deleteByPrimaryKey(guid);
    }
}
