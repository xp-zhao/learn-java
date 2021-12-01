package com.design.design_21_00.impl;

import com.design.design_21_00.NetMall;
import java.util.Collections;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 京东网
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
@Slf4j
public class JDNetMall extends NetMall {

  public JDNetMall(String uId, String uPwd) {
    super(uId, uPwd);
  }

  @Override
  protected Boolean login(String uId, String uPwd) {
    log.info("模拟京东用户登录 uId：{} uPwd：{}", uId, uPwd);
    return true;
  }

  @Override
  protected Map<String, String> reptile(String skuUrl) {
    log.info("模拟京东商品爬虫解析");
    return Collections.emptyMap();
  }

  @Override
  protected String createBase64(Map<String, String> goodsInfo) {
    log.info("模拟生成京东商品base64海报");
    return "";
  }
}
