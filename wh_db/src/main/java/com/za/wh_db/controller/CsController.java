package com.za.wh_db.controller;

import com.alibaba.fastjson.JSON;
import com.za.wh_db.domain.CsCenter;
import com.za.wh_db.domain.CsItemConfig;
import com.za.wh_db.domain.CsOrder;
import com.za.wh_db.domain.CsOrderItem;
import com.za.wh_db.service.CsService;
import com.za.wh_db.tools.MD5Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class CsController {

    @Autowired
    private CsService csService;

    @RequestMapping
    public Map<String, Object> indexCs(@RequestHeader(value = "date") String date, @RequestBody Map<String, Object> params) {
        Map<String, Object> reMap = new HashMap<>();
        if (!date.equals(MD5Tools.encode())) {
            log.error("Header error");
            reMap.put("errorMsg","Header error");
            return reMap;
        }
        if (null != params.get("CsOrder")) {
            log.info("start insert Csorder =====");
            List<Map<String, String>> csOrders = (List<Map<String, String>>) params.get("CsOrder");
            log.info("get Csorder sucess and size is {}", csOrders.size());
            List<String> ErrorGuid = new ArrayList<>();
            for (Map<String, String> map :
                    csOrders) {
                CsOrder csOrder = JSON.parseObject(JSON.toJSONString(map), CsOrder.class);
                try {
                    String reString = csService.insertOrder(csOrder);
                    if (!"success".equals(reString)) {
                        ErrorGuid.add(reString);
                    }
                } catch (SQLException e) {
                    ErrorGuid.add(csOrder.getGuid());
                    log.error("error msg is {}", e.getMessage());
                } catch (Exception e) {
                    log.error("error msg is {}", e.getMessage());
                }
            }
            reMap.put("ErrorGuid", ErrorGuid);
            log.info("insert Csorder Success and error msg is {}", ErrorGuid);
        }
        if (null != params.get("CsOrderItem")) {
            log.info("start insert CsOrderItem  =====");
            List<Map<String, String>> csOrderItems = (List<Map<String, String>>) params.get("CsOrderItem");
            log.info("get CsOrderItem sucess and size is {}", csOrderItems.size());
            List<String> ErrorGuid = new ArrayList<>();
            for (Map<String, String> map :
                    csOrderItems) {
                CsOrderItem csOrderItem = JSON.parseObject(JSON.toJSONString(map), CsOrderItem.class);
                try {
                    String reString = csService.insertOrderItem(csOrderItem);
                    if (!"success".equals(reString)) {
                        ErrorGuid.add(reString);
                    }
                } catch (SQLException e) {
                    ErrorGuid.add(csOrderItem.getGuid());
                    log.error("error msg is {}", e.getMessage());
                } catch (Exception e) {
                    log.error("error msg is {}", e.getMessage());
                }
            }
            reMap.put("ErrorGuid", ErrorGuid);
            log.info("insert CsOrderItem Success and error msg is {}", ErrorGuid);
        }
        if (null != params.get("CsItemConfig")) {
            log.info("start insert CsItemConfig  =====");
            List<Map<String, String>> csItemConfigs = (List<Map<String, String>>) params.get("CsItemConfig");
            System.out.println("get CsItemConfig sucess and size is" + csItemConfigs.size());
            log.info("get CsItemConfig sucess and size is {}", csItemConfigs.size());
            List<String> ErrorGuid = new ArrayList<>();
            for (Map<String, String> map :
                    csItemConfigs) {
                CsItemConfig csItemConfig = JSON.parseObject(JSON.toJSONString(map), CsItemConfig.class);
                try {
                    String reString = csService.insertCsItemConfig(csItemConfig);
                    if (!"success".equals(reString)) {
                        ErrorGuid.add(reString);
                    }
                } catch (SQLException e) {
                    ErrorGuid.add(csItemConfig.getGuid());
                    log.error("error msg is {}", e.getMessage());
                } catch (Exception e) {
                    log.error("error msg is {}", e.getMessage());
                }
            }
            reMap.put("ErrorGuid", ErrorGuid);
            log.info("insert CsItemConfig Success and error msg is {}", ErrorGuid);
        }
        if (null != params.get("CsCenter")) {
            log.info("start insert CsCenter  =====");
            List<Map<String, String>> csCenters = (List<Map<String, String>>) params.get("CsCenter");
            System.out.println("get CsCenter sucess and size is" + csCenters.size());
            log.info("get csCenters sucess and size is {}", csCenters.size());
            List<String> ErrorGuid = new ArrayList<>();
            for (Map<String, String> map :
                    csCenters) {
                CsCenter csCenter = JSON.parseObject(JSON.toJSONString(map), CsCenter.class);
                try {
                    String reString = csService.insertCsCenter(csCenter);
                    if (!"success".equals(reString)) {
                        ErrorGuid.add(reString);
                    }
                } catch (SQLException e) {
                    ErrorGuid.add(csCenter.getGuid());
                    log.error("error msg is {}", e.getMessage());
                } catch (Exception e) {
                    log.error("error msg is {}", e.getMessage());
                }
            }
            reMap.put("ErrorGuid", ErrorGuid);
            log.info("insert CsCenter Success and error msg is {}", ErrorGuid);
        }
        return reMap;
    }
}
