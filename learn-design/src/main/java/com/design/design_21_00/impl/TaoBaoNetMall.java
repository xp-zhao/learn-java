package com.design.design_21_00.impl;

import com.design.design_21_00.NetMall;
import java.util.Collections;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * 淘宝网
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
@Slf4j
public class TaoBaoNetMall extends NetMall {

  public TaoBaoNetMall(String uId, String uPwd) {
    super(uId, uPwd);
  }

  @Override
  protected Boolean login(String uId, String uPwd) {
    log.info("模拟淘宝用户登录 uId：{} uPwd：{}", uId, uPwd);
    return true;
  }

  @Override
  protected Map<String, String> reptile(String skuUrl) {
    log.info("模拟淘宝商品爬虫解析");
    return Collections.emptyMap();
  }

  @Override
  protected String createBase64(Map<String, String> goodsInfo) {
    log.info("模拟生成淘宝商品base64海报");
    return "";
  }
}
