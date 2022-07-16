package com.example.liteflow.cmp;

import com.yomahub.liteflow.annotation.LiteflowComponent;
import com.yomahub.liteflow.core.NodeComponent;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

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
    int total = 17;
    int aCount = 5;
    int[] arr = new int[aCount];
    int remainderCount = total % aCount;
    int divideCount = total / aCount;
    Arrays.fill(arr, divideCount);
    for (int i = 0; i < remainderCount; i++) {
      arr[i] += 1;
    }
    for (int i : arr) {
      this.sendPrivateDeliveryData("a", i);
    }
  }
}
