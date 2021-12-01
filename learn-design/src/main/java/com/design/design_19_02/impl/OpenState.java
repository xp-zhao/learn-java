package com.design.design_19_02.impl;

import com.design.design_19_00.ActivityService;
import com.design.design_19_00.Result;
import com.design.design_19_00.Status;
import com.design.design_19_02.State;

/**
 * 开启中状态处理
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class OpenState extends State {

  @Override
  public Result arraignment(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动开启不可提审");
  }

  @Override
  public Result checkPass(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动开启不可审核通过");
  }

  @Override
  public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动开启不可审核拒绝");
  }

  @Override
  public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动开启不可撤销审核");
  }

  @Override
  public Result close(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.CLOSE);
    return new Result("0000", "活动关闭完成");
  }

  @Override
  public Result open(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动不可重复开启");
  }

  @Override
  public Result doing(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.DOING);
    return new Result("0000", "活动变更活动中完成");
  }
}
