package com.example.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/7/13
 */
@Slf4j
@LiteflowComponent(id = "d", name = "前置模块")
public class DCmp extends NodeComponent {
  @Override
  public void process() throws Exception {
    log.info("前置模块执行完成");
    for (int i = 0; i < 5; i++) {
      this.sendPrivateDeliveryData("a", 2);
    }
  }
}
