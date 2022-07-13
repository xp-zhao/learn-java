package com.example.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2022-7-13
 */
@Slf4j
@LiteflowComponent(id = "c", name = "c 模块")
public class CCmp extends NodeComponent {

  @Override
  public void process() throws InterruptedException {
    TimeUnit.SECONDS.sleep(2);
    log.info("c 执行完成");
  }
}