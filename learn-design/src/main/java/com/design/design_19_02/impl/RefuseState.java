package com.design.design_19_02.impl;

import com.design.design_19_00.ActivityService;
import com.design.design_19_00.Result;
import com.design.design_19_00.Status;
import com.design.design_19_02.State;

/**
 * 审核拒绝状态处理
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class RefuseState extends State {

  @Override
  public Result arraignment(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "已审核状态不可重复提审");
  }

  @Override
  public Result checkPass(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "已审核状态不可重复审核");
  }

  @Override
  public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.REFUSE);
    return new Result("0000", "活动审核拒绝不可重复审核");
  }

  @Override
  public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.EDITING);
    return new Result("0000", "撤销审核完成");
  }

  @Override
  public Result close(String activityId, Enum<Status> currentStatus) {
    ActivityService.execStatus(activityId, currentStatus, Status.CLOSE);
    return new Result("0000", "活动审核关闭完成");
  }

  @Override
  public Result open(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "非关闭活动不可开启");
  }

  @Override
  public Result doing(String activityId, Enum<Status> currentStatus) {
    return new Result("0001", "审核拒绝不可执行活动为进行中");
  }
}
