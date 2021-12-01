package com.design.design_18_02;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class ApiTest {
  @Test
  public void test() {
    LotteryService lotteryService = new LotteryServiceImpl();
    LotteryResult result = lotteryService.draw("2765789109876");
    log.info("测试结果：{}", JSON.toJSONString(result));
  }
}
