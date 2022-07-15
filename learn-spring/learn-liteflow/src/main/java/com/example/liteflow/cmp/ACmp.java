package com.example.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @date 2022-7-13
 */
@Slf4j
@LiteflowComponent(id = "a", name = "a 模块")
public class ACmp extends NodeComponent {

  @Override
  public void process() throws Exception {
    Integer data = this.getPrivateDeliveryData();
    for (int i = 0; i < data; i++) {
      TimeUnit.SECONDS.sleep(2);
    }
    log.info("a 执行完成");
  }
}
