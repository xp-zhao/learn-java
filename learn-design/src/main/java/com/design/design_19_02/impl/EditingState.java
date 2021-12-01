package com.design.design_19_02.impl;

import com.design.design_19_00.ActivityService;
import com.design.design_19_00.Result;
import com.design.design_19_00.Status;
import com.design.design_19_02.State;

/**
 * 编辑中状态处理
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class EditingState extends State {

  @Override
  public Result arraignment(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.CHECK);
    return new Result("0000", "活动提审成功");
  }

  @Override
  public Result checkPass(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "编辑中不可审核通过");
  }

  @Override
  public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "编辑中不可审核拒绝");
  }

  @Override
  public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "编辑中不可撤销审核");
  }

  @Override
  public Result close(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.CLOSE);
    return new Result("0000", "活动关闭成功");
  }

  @Override
  public Result open(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "非关闭活动不可开启");
  }

  @Override
  public Result doing(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "编辑中活动不可执行活动中变更");
  }
}
