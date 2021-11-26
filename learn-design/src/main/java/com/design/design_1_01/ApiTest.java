package com.design.design_1_01;

import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Slf4j
public class ApiTest {
  @Test
  public void testAwardToUser() {
    PrizeController prizeController = new PrizeController();
    log.info("\r\n模拟发放优惠券测试\r\n");
    // 模拟发放优惠券测试
    AwardReq req01 = new AwardReq();
    req01.setUId("10001");
    req01.setAwardType(1);
    req01.setAwardNumber("EGM1023938910232121323432");
    req01.setBizId("791098764902132");
    AwardRes awardRes01 = prizeController.awardToUser(req01);
    log.info("请求参数：{}", JSON.toJSON(req01));
    log.info("测试结果：{}", JSON.toJSON(awardRes01));

    log.info("\r\n模拟方法实物商品\r\n");
    // 模拟方法实物商品
    AwardReq req02 = new AwardReq();
    req02.setUId("10001");
    req02.setAwardType(2);
    req02.setAwardNumber("9820198721311");
    req02.setBizId("1023000020112221113");
    req02.setExtMap(
        new HashMap<String, String>(3) {
          {
            put("consigneeUserName", "谢飞机");
            put("consigneeUserPhone", "15200292123");
            put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
          }
        });

    AwardRes awardRes02 = prizeController.awardToUser(req02);
    log.info("请求参数：{}", JSON.toJSON(req02));
    log.info("测试结果：{}", JSON.toJSON(awardRes02));

    log.info("\r\n第三方兑换卡(爱奇艺)\r\n");
    AwardReq req03 = new AwardReq();
    req03.setUId("10001");
    req03.setAwardType(3);
    req03.setAwardNumber("AQY1xjkUodl8LO975GdfrYUio");

    AwardRes awardRes03 = prizeController.awardToUser(req03);
    log.info("请求参数：{}", JSON.toJSON(req03));
    log.info("测试结果：{}", JSON.toJSON(awardRes03));
  }
}
