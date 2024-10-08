package com.example.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import com.yomahub.liteflow.slot.Slot;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2022-7-13
 */
@Slf4j
@LiteflowComponent(id = "b", name = "b 模块")
public class BCmp extends NodeComponent {

  @Override
  public void process() throws Exception {
    log.info("b 执行完成");
  }

  @Override
  public void onError() throws Exception {
    Slot slot = this.getSlot();
    log.error("b 执行失败");
  }
}
