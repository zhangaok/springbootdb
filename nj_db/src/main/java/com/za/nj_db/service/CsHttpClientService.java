package com.za.nj_db.service;

import com.za.nj_db.domain.CsCenter;
import com.za.nj_db.domain.CsItemConfig;
import com.za.nj_db.domain.CsOrder;
import com.za.nj_db.domain.CsOrderItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CsHttpClientService {
    ResponseEntity<String> httpOrderInfo(List<CsOrder> orders, String url);

    ResponseEntity<String> httpOrderItemInfo(List<CsOrderItem> csOrderItems, String url);

    ResponseEntity<String> httpItemConfigInfo(List<CsItemConfig> csItemConfigs, String url);

    ResponseEntity<String> httpCsCenter(List<CsCenter> csCenters, String url);
}
