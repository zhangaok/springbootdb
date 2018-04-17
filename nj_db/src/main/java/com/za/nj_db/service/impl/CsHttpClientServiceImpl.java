package com.za.nj_db.service.impl;

import com.za.nj_db.domain.CsCenter;
import com.za.nj_db.domain.CsItemConfig;
import com.za.nj_db.domain.CsOrder;
import com.za.nj_db.domain.CsOrderItem;
import com.za.nj_db.service.CsHttpClientService;
import com.za.nj_db.tools.MD5Tools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class CsHttpClientServiceImpl implements CsHttpClientService {
    @Override
    public ResponseEntity<String> httpOrderInfo(List<CsOrder> orders, String url) {
        log.info("start link http");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("date", MD5Tools.encode());
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        Map<String, List<CsOrder>> map = new HashMap<>();
        map.put("CsOrder", orders);
        HttpEntity<Map<String, List<CsOrder>>> entity = new HttpEntity<>(map, headers);
        /* body是Http消息体例如json串 */
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        } catch (RestClientException e) {
            log.error("error msg is {}", e.getMessage());
        }
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("link http success");
        } else {
            log.info("link http error and msg is {}", responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> httpOrderItemInfo(List<CsOrderItem> csOrderItems, String url) {
        log.info("start link http");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.set("date", MD5Tools.encode());
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        Map<String, List<CsOrderItem>> map = new HashMap<>();
        map.put("CsOrderItem", csOrderItems);
        HttpEntity<Map<String, List<CsOrderItem>>> entity = new HttpEntity<>(map, headers);
        /* body是Http消息体例如json串 */
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        } catch (RestClientException e) {
            log.error("error msg is {}", e.getMessage());
        }
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("link http success");
        } else {
            log.info("link http error and msg is {}", responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> httpItemConfigInfo(List<CsItemConfig> csItemConfigs, String url) {
        log.info("start link http");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("date", MD5Tools.encode());
        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        Map<String, List<CsItemConfig>> map = new HashMap<>();
        map.put("CsItemConfig", csItemConfigs);
        HttpEntity<Map<String, List<CsItemConfig>>> entity = new HttpEntity<>(map, headers);
        /* body是Http消息体例如json串 */
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        } catch (RestClientException e) {
            log.error("error msg is {}", e.getMessage());
        }
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("link http success");
        } else {
            log.info("link http error and msg is {}", responseEntity.getStatusCode());
        }
        return responseEntity;
    }

    @Override
    public ResponseEntity<String> httpCsCenter(List<CsCenter> csCenters, String url) {
        log.info("start link http");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("date", MD5Tools.encode());
        /* 这个对象有add()方法，可往请求头存入信息 */
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        /* 解决中文乱码的关键 , 还有更深层次的问题 关系到 StringHttpMessageConverter，先占位，以后补全*/
        Map<String, List<CsCenter>> map = new HashMap<>();
        map.put("CsCenter", csCenters);
        HttpEntity<Map<String, List<CsCenter>>> entity = new HttpEntity<>(map, headers);
        /* body是Http消息体例如json串 */
        ResponseEntity<String> responseEntity = null;
        try {
            responseEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        } catch (RestClientException e) {
            log.error("error msg is {}", e.getMessage());
        }
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            log.info("link http success");
        } else {
            log.info("link http error and msg is {}", responseEntity.getStatusCode());
        }
        return responseEntity;
    }

}
