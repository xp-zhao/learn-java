package com.design.design_20_02;

import com.design.design_20_02.impl.MJCouponDiscount;
import com.design.design_20_02.impl.NYGCouponDiscount;
import com.design.design_20_02.impl.ZJCouponDiscount;
import com.design.design_20_02.impl.ZKCouponDiscount;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
@Slf4j
public class ApiTest {
  @Test
  public void testZj() {
    // 直减；100-10，商品100元
    Context<Double> context = new Context<Double>(new ZJCouponDiscount());
    BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
    log.info("测试结果：直减优惠后金额 {}", discountAmount);
  }

  @Test
  public void testMj() {
    // 满100减10，商品100元
    Context<Map<String, String>> context = new Context<Map<String, String>>(new MJCouponDiscount());
    Map<String, String> mapReq = new HashMap<String, String>();
    mapReq.put("x", "100");
    mapReq.put("n", "10");
    BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
    log.info("测试结果：满减优惠后金额 {}", discountAmount);
  }

  @Test
  public void testZk() {
    // 折扣9折，商品100元
    Context<Double> context = new Context<Double>(new ZKCouponDiscount());
    BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
    log.info("测试结果：折扣9折后金额 {}", discountAmount);
  }

  @Test
  public void testNyg() {
    // n元购；100-10，商品100元
    Context<Double> context = new Context<Double>(new NYGCouponDiscount());
    BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
    log.info("测试结果：n元购优惠后金额 {}", discountAmount);
  }
}
