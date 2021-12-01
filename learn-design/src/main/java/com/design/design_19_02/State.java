package com.design.design_19_02;

import com.design.design_19_00.Result;
import com.design.design_19_00.Status;

/**
 * 状态转换抽象接口
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public abstract class State {
  /**
   * 活动提审
   *
   * @param activityId 活动ID
   * @param currentStatus 当前状态
   * @return 执行结果
   */
  public abstract Result arraignment(String activityId, Enum<Status> currentStatus);

  /**
   * 审核通过
   *
   * @param activityId 活动ID
   * @param currentStatus 当前状态
   * @return 执行结果
   */
  public abstract Result checkPass(String activityId, Enum<Status> currentStatus);

  /**
   * 审核拒绝
   *
   * @param activityId 活动ID
   * @param currentStatus 当前状态
   * @return 执行结果
   */
  public abstract Result checkRefuse(String activityId, Enum<Status> currentStatus);

  /**
   * 撤审撤销
   *
   * @param activityId 活动ID
   * @param currentStatus 当前状态
   * @return 执行结果
   */
  public abstract Result checkRevoke(String activityId, Enum<Status> currentStatus);

  /**
   * 活动关闭
   *
   * @param activityId 活动ID
   * @param currentStatus 当前状态
   * @return 执行结果
   */
  public abstract Result close(String activityId, Enum<Status> currentStatus);

  /**
   * 活动开启
   *
   * @param activityId 活动ID
   * @param currentStatus 当前状态
   * @return 执行结果
   */
  public abstract Result open(String activityId, Enum<Status> currentStatus);

  /**
   * 活动执行
   *
   * @param activityId 活动ID
   * @param currentStatus 当前状态
   * @return 执行结果
   */
  public abstract Result doing(String activityId, Enum<Status> currentStatus);
}
