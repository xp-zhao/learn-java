package com.design.design_22_00;

import com.design.design_22_00.visitor.impl.Parent;
import com.design.design_22_00.visitor.impl.Principal;
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
  public void test() {
    DataView dataView = new DataView();

    log.info("\r\n家长视角访问：");
    // 家长
    dataView.show(new Parent());

    log.info("\r\n校长视角访问：");
    // 校长
    dataView.show(new Principal());
  }
}
