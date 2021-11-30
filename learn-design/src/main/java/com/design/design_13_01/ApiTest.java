package com.design.design_13_01;

import com.alibaba.fastjson.JSON;
import com.design.design_13_00.AuthService;
import java.text.ParseException;
import java.util.Date;
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
  public void test_AuthController() throws ParseException {
    AuthController authController = new AuthController();

    // 模拟三级负责人审批
    log.info(
        "测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
    log.info("测试结果：{}", "模拟三级负责人审批，王工");
    AuthService.auth("1000013", "1000998004813441");

    // 模拟二级负责人审批
    log.info(
        "测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
    log.info("测试结果：{}", "模拟二级负责人审批，张经理");
    AuthService.auth("1000012", "1000998004813441");

    // 模拟一级负责人审批
    log.info(
        "测试结果：{}", JSON.toJSONString(authController.doAuth("小傅哥", "1000998004813441", new Date())));
    log.info("测试结果：{}", "模拟一级负责人审批，段总");
    AuthService.auth("1000011", "1000998004813441");

    log.info("测试结果：{}", "审批完成");
  }
}
