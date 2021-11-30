package com.design.design_11_01;

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
  private ActivityController activityController = new ActivityController();

  @Test
  public void testQueryActivityInfo() {
    Long req = 10001L;
    Activity activity = activityController.queryActivityInfo(req);
    log.info("测试结果：{} {}", req, JSON.toJSONString(activity));
  }
}
