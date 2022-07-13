package com.example.liteflow;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class LearnLiteflowApplicationTests {

  @Resource private FlowExecutor flowExecutor;

  @Test
  void contextLoads() {
    LiteflowResponse resp = flowExecutor.execute2Resp("chain");
    if (resp.isSuccess()) {
      log.info("流程执行成功");
    }else{
      log.info("流程执行失败");
    }
  }
}
