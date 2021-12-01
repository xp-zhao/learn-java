package com.design.design_19_02;

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
  public void testEditing2Arraignment() {
    String activityId = "100001";
    ActivityService.init(activityId, Status.EDITING);
    StateHandler stateHandler = new StateHandler();
    Result result = stateHandler.arraignment(activityId, Status.EDITING);
    log.info("测试结果(编辑中To提审活动)：{}", JSON.toJSONString(result));
    log.info(
        "活动信息：{} 状态：{}",
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
  }

  @Test
  public void testEditing2Open() {
    String activityId = "100001";
    ActivityService.init(activityId, Status.EDITING);
    StateHandler stateHandler = new StateHandler();
    Result result = stateHandler.open(activityId, Status.EDITING);
    log.info("测试结果(编辑中To开启活动)：{}", JSON.toJSONString(result));
    log.info(
        "活动信息：{} 状态：{}",
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
  }

  @Test
  public void testRefuse2Doing() {
    String activityId = "100001";
    ActivityService.init(activityId, Status.REFUSE);
    StateHandler stateHandler = new StateHandler();
    Result result = stateHandler.doing(activityId, Status.REFUSE);
    log.info("测试结果(拒绝To活动中)：{}", JSON.toJSONString(result));
    log.info(
        "活动信息：{} 状态：{}",
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
  }

  @Test
  public void testRefuse2Revoke() {
    String activityId = "100001";
    ActivityService.init(activityId, Status.REFUSE);
    StateHandler stateHandler = new StateHandler();
    Result result = stateHandler.checkRevoke(activityId, Status.REFUSE);
    log.info("测试结果(拒绝To撤审)：{}", JSON.toJSONString(result));
    log.info(
        "活动信息：{} 状态：{}",
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId)),
        JSON.toJSONString(ActivityService.queryActivityInfo(activityId).getStatus()));
  }
}
