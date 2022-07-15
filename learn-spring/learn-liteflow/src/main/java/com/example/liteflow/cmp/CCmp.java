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
@LiteflowComponent(id = "c", name = "c 模块")
public class CCmp extends NodeComponent {

  @Override
  public void process() throws InterruptedException {
    TimeUnit.SECONDS.sleep(2);
  }

  @Override
  public void onSuccess() throws Exception {
    log.info("c 模块执行成功");
  }
}
