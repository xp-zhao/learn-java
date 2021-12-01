package com.design.design_19_01;

import com.design.design_19_00.ActivityService;
import com.design.design_19_00.Result;
import com.design.design_19_00.Status;

/**
 * 活动状态变换控制层
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class ActivityExecStatusController {
  /**
   * 活动状态变更<br>
   * 1. 编辑中 -> 提审、关闭<br>
   * 2. 审核通过 -> 拒绝、关闭、活动中<br>
   * 3. 审核拒绝 -> 撤审、关闭<br>
   * 4. 活动中 -> 关闭<br>
   * 5. 活动关闭 -> 开启<br>
   * 6. 活动开启 -> 关闭<br>
   *
   * @param activityId 活动ID
   * @param beforeStatus 变更前状态
   * @param afterStatus 变更后状态
   * @return 返回结果
   */
  public Result execStatus(String activityId, Enum<Status> beforeStatus, Enum<Status> afterStatus) {

    // 1. 编辑中 -> 提审、关闭
    if (Status.EDITING.equals(beforeStatus)) {
      if (Status.CHECK.equals(afterStatus) || Status.CLOSE.equals(afterStatus)) {
        ActivityService.execStatus(activityId, beforeStatus, afterStatus);
        return new Result("0000", "变更状态成功");
      } else {
        return new Result("0001", "变更状态拒绝");
      }
    }

    // 2. 审核通过 -> 拒绝、关闭、活动中
    if (Status.PASS.equals(beforeStatus)) {
      if (Status.REFUSE.equals(afterStatus)
          || Status.DOING.equals(afterStatus)
          || Status.CLOSE.equals(afterStatus)) {
        ActivityService.execStatus(activityId, beforeStatus, afterStatus);
        return new Result("0000", "变更状态成功");
      } else {
        return new Result("0001", "变更状态拒绝");
      }
    }

    // 3. 审核拒绝 -> 撤审、关闭
    if (Status.REFUSE.equals(beforeStatus)) {
      if (Status.EDITING.equals(afterStatus) || Status.CLOSE.equals(afterStatus)) {
        ActivityService.execStatus(activityId, beforeStatus, afterStatus);
        return new Result("0000", "变更状态成功");
      } else {
        return new Result("0001", "变更状态拒绝");
      }
    }

    // 4. 活动中 -> 关闭
    if (Status.DOING.equals(beforeStatus)) {
      if (Status.CLOSE.equals(afterStatus)) {
        ActivityService.execStatus(activityId, beforeStatus, afterStatus);
        return new Result("0000", "变更状态成功");
      } else {
        return new Result("0001", "变更状态拒绝");
      }
    }

    // 5. 活动关闭 -> 开启
    if (Status.CLOSE.equals(beforeStatus)) {
      if (Status.OPEN.equals(afterStatus)) {
        ActivityService.execStatus(activityId, beforeStatus, afterStatus);
        return new Result("0000", "变更状态成功");
      } else {
        return new Result("0001", "变更状态拒绝");
      }
    }

    // 6. 活动开启 -> 关闭
    if (Status.OPEN.equals(beforeStatus)) {
      if (Status.CLOSE.equals(afterStatus)) {
        ActivityService.execStatus(activityId, beforeStatus, afterStatus);
        return new Result("0000", "变更状态成功");
      } else {
        return new Result("0001", "变更状态拒绝");
      }
    }
    return new Result("0001", "非可处理的活动状态变更");
  }
}
