package com.example.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
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
    int a = 1 / 0;
    log.info("b 执行完成");
  }

  @Override
  public void onError() throws Exception {
    log.error("b 执行失败");
  }
}
