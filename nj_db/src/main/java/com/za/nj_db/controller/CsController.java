package com.za.nj_db.controller;

import com.alibaba.fastjson.JSONObject;
import com.za.nj_db.domain.*;
import com.za.nj_db.service.CsDaoService;
import com.za.nj_db.service.CsHttpClientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
public class CsController {

    @Value("${ymlInfo.code}")
    private String code;

    @Value("${ymlInfo.location}")
    private String location;

    @Value("${ymlInfo.level}")
    private String level;

    @Autowired
    private CsDaoService csService;

    @Autowired
    private CsHttpClientService csHttpClientService;

    private YmlInfo getYml() {
        YmlInfo info = new YmlInfo();
        info.setCode(code);
        info.setLevel(level);
        return info;
    }

    @Async
    @Scheduled(fixedDelay = 1000 * 10)
    //每10秒执行一次
    public void indexOrder() {
        try {
            List<CsOrder> orders = csService.getOrderInfo(getYml());
            log.info("enter indexOrder and order number is {}", orders.size());
            if (!CollectionUtils.isEmpty(orders)) {
                ResponseEntity<String> rsp = csHttpClientService.httpOrderInfo(orders, location);
                Map<String, Object> maps = (Map<String, Object>) JSONObject.parse(rsp.getBody());
                List<String> list = (List<String>) maps.get("ErrorGuid");
                for (CsOrder order :
                        orders) {
                    if (isDelete(list, order.getGuid())) {
                        csService.deleteOrder(order.getGuid());
                    }
                }
                log.info("delete Order success");
            }
        } catch (SQLException e) {
            log.error("error msg is {}", e.getMessage());
        } catch (Exception e) {
            log.error("error msg is {}", e.getMessage());
        }
    }

    @Async
    @Scheduled(fixedDelay = 1000 * 10)
    //每10秒执行一次
    public void indexOrderItem() {
        try {
            List<CsOrderItem> csOrderItems = csService.getOrderItemInfo(getYml());
            log.info("enter indexOrderItem and csOrderItems number is {}", csOrderItems.size());
            if (!CollectionUtils.isEmpty(csOrderItems)) {
                ResponseEntity<String> rsp = csHttpClientService.httpOrderItemInfo(csOrderItems, location);
                Map<String, Object> maps = (Map<String, Object>) JSONObject.parse(rsp.getBody());
                List<String> list = (List<String>) maps.get("ErrorGuid");
                for (CsOrderItem csOrderItem :
                        csOrderItems) {
                    if (isDelete(list, csOrderItem.getGuid())) {
                        csService.deleteOrderItem(csOrderItem.getGuid());
                    }
                }
                log.info("delete Order success");
            }
        } catch (SQLException e) {
            log.error("error msg is {}", e.getMessage());
        } catch (Exception e) {
            log.error("error msg is {}", e.getMessage());
        }
    }

    @Async
    @Scheduled(fixedDelay = 1000 * 10)
    //每10秒执行一次
    public void indexItemConfig() {
        try {
            List<CsItemConfig> csItemConfigs = csService.getCsItemConfigInfo(getYml());
            log.info("enter indexItemConfig and csItemConfigs number is {}", csItemConfigs.size());
            if (!CollectionUtils.isEmpty(csItemConfigs)) {
                ResponseEntity<String> rsp = csHttpClientService.httpItemConfigInfo(csItemConfigs, location);
                Map<String, Object> maps = (Map<String, Object>) JSONObject.parse(rsp.getBody());
                List<String> list = (List<String>) maps.get("ErrorGuid");
                for (CsItemConfig csItemConfig :
                        csItemConfigs) {
                    if (isDelete(list, csItemConfig.getGuid())) {
                        csService.deleteItemConfig(csItemConfig.getGuid());
                    }
                }
                log.info("delete CsItemConfig success");
            }
        } catch (SQLException e) {
            log.error("error msg is {}", e.getMessage());
        } catch (Exception e) {
            log.error("error msg is {}", e.getMessage());
        }
    }

    @Async
    @Scheduled(fixedDelay = 1000 * 10)
    //每10秒执行一次
    public void indexCsCenter() {
        try {
            List<CsCenter> csCenters = csService.getCsCenterInfo(getYml());
            log.info("enter indexCsCenter and csCenters number is {}", csCenters.size());
            if (!CollectionUtils.isEmpty(csCenters)) {
                ResponseEntity<String> rsp = csHttpClientService.httpCsCenter(csCenters, location);
                Map<String, Object> maps = (Map<String, Object>) JSONObject.parse(rsp.getBody());
                List<String> list = (List<String>) maps.get("ErrorGuid");
                for (CsCenter csCenter :
                        csCenters) {
                    if (isDelete(list, csCenter.getGuid())) {
                        csService.deleteCsCenter(csCenter.getGuid());
                    }
                }
                log.info("delete CsCenter success");
            }
        } catch (SQLException e) {
            log.error("error msg is {}", e.getMessage());
        } catch (Exception e) {
            log.error("error msg is {}", e.getMessage());
        }
    }

    private boolean isDelete(List<String> list, String guid) {
        boolean bl = true;
        for (String errorGuid :
                list) {
            if (errorGuid.equals(guid)) {
                bl = false;
            }
        }
        return bl;
    }
}
