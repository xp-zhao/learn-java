package com.design.design_21_00;

import java.util.Map;

/**
 * 基础服务
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public abstract class NetMall {
  /** 用户ID */
  String uId;
  /** 用户密码 */
  String uPwd;

  public NetMall(String uId, String uPwd) {
    this.uId = uId;
    this.uPwd = uPwd;
  }

  /**
   * 生成商品推广海报
   *
   * @param skuUrl 商品地址(京东、淘宝、当当)
   * @return 海报图片base64位信息
   */
  public String generateGoodsPoster(String skuUrl) {
    // 1. 验证登录
    if (!login(uId, uPwd)) {
      return null;
    }
    // 2. 爬虫商品
    Map<String, String> reptile = reptile(skuUrl);
    // 3. 组装海报
    return createBase64(reptile);
  }

  /**
   * 登录
   *
   * @param uId 用户id
   * @param uPwd 密码
   * @return {@code Boolean}
   */
  protected abstract Boolean login(String uId, String uPwd);

  /**
   * 爬虫提取商品信息(登录后的优惠价格)
   *
   * @param skuUrl sku url
   * @return {@code Map<String, String>}
   */
  protected abstract Map<String, String> reptile(String skuUrl);

  /**
   * 生成商品海报信息
   *
   * @param goodsInfo 货物信息
   * @return {@code String}
   */
  protected abstract String createBase64(Map<String, String> goodsInfo);
}
