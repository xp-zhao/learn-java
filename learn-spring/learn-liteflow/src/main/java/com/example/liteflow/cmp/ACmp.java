package com.example.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @date 2022-7-13
 */
@Slf4j
@LiteflowComponent(id = "a", name = "a 模块")
public class ACmp extends NodeComponent {

  @Override
  public void process() {
    log.info("a 执行完成");
  }
}
