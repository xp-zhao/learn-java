package com.design.design_19_02.impl;

import com.design.design_19_00.ActivityService;
import com.design.design_19_00.Result;
import com.design.design_19_00.Status;
import com.design.design_19_02.State;

/**
 * 活动关闭处理
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class CloseState extends State {

  @Override
  public Result arraignment(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动关闭不可提审");
  }

  @Override
  public Result checkPass(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动关闭不可审核通过");
  }

  @Override
  public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动关闭不可审核拒绝");
  }

  @Override
  public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动关闭不可撤销审核");
  }

  @Override
  public Result close(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动关闭不可重复关闭");
  }

  @Override
  public Result open(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.OPEN);
    return new Result("0000", "活动开启完成");
  }

  @Override
  public Result doing(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "活动关闭不可变更活动中");
  }
}
