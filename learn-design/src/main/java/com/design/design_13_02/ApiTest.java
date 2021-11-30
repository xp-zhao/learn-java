package com.design.design_13_02;

import com.alibaba.fastjson.JSON;
import com.design.design_13_00.AuthService;
import com.design.design_13_02.impl.Level1AuthLink;
import com.design.design_13_02.impl.Level2AuthLink;
import com.design.design_13_02.impl.Level3AuthLink;
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
  public void test_AuthLink() throws ParseException {
    AuthLink authLink =
        new Level3AuthLink("1000013", "王工")
            .appendNext(
                new Level2AuthLink("1000012", "张经理")
                    .appendNext(new Level1AuthLink("1000011", "段总")));
    log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
    // 模拟三级负责人审批
    AuthService.auth("1000013", "1000998004813441");
    log.info("测试结果：{}", "模拟三级负责人审批，王工");
    log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
    // 模拟二级负责人审批
    AuthService.auth("1000012", "1000998004813441");
    log.info("测试结果：{}", "模拟二级负责人审批，张经理");
    log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
    // 模拟一级负责人审批
    AuthService.auth("1000011", "1000998004813441");
    log.info("测试结果：{}", "模拟一级负责人审批，段总");
    log.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));
  }
}
