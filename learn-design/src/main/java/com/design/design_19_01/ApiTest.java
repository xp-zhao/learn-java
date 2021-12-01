package com.design.design_19_01;

import com.alibaba.fastjson.JSON;
import com.design.design_19_00.ActivityService;
import com.design.design_19_00.Result;
import com.design.design_19_00.Status;
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

    // 初始化数据
    String activityId = "100001";
    ActivityService.init(activityId, Status.EDITING);

    ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
    Result resultRefuse = activityExecStatusController.execStatus(activityId, Status.EDITING, Status.REFUSE);

    log.info("测试结果(编辑中To审核拒绝)：{}", JSON.toJSONString(resultRefuse));

    Result resultCheck =
        activityExecStatusController.execStatus(activityId, Status.EDITING, Status.CHECK);
    log.info("测试结果(编辑中To提交审核)：{}", JSON.toJSONString(resultCheck));

  }
}
