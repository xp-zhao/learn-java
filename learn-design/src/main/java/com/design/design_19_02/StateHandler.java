package com.design.design_19_02;

import com.design.design_19_00.Result;
import com.design.design_19_00.Status;
import com.design.design_19_02.impl.CheckState;
import com.design.design_19_02.impl.CloseState;
import com.design.design_19_02.impl.DoingState;
import com.design.design_19_02.impl.EditingState;
import com.design.design_19_02.impl.OpenState;
import com.design.design_19_02.impl.PassState;
import com.design.design_19_02.impl.RefuseState;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 状态处理器
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public class StateHandler {
  private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<Enum<Status>, State>();

  public StateHandler() {
    // 待审核
    stateMap.put(Status.CHECK, new CheckState());
    // 已关闭
    stateMap.put(Status.CLOSE, new CloseState());
    // 活动中
    stateMap.put(Status.DOING, new DoingState());
    // 编辑中
    stateMap.put(Status.EDITING, new EditingState());
    // 已开启
    stateMap.put(Status.OPEN, new OpenState());
    // 审核通过
    stateMap.put(Status.PASS, new PassState());
    // 审核拒绝
    stateMap.put(Status.REFUSE, new RefuseState());
  }

  public Result arraignment(String activityId, Enum<Status> currentStatus) {
    return stateMap.get(currentStatus).arraignment(activityId, currentStatus);
  }

  public Result checkPass(String activityId, Enum<Status> currentStatus) {
    return stateMap.get(currentStatus).checkPass(activityId, currentStatus);
  }

  public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
    return stateMap.get(currentStatus).checkRefuse(activityId, currentStatus);
  }

  public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
    return stateMap.get(currentStatus).checkRevoke(activityId, currentStatus);
  }

  public Result close(String activityId, Enum<Status> currentStatus) {
    return stateMap.get(currentStatus).close(activityId, currentStatus);
  }

  public Result open(String activityId, Enum<Status> currentStatus) {
    return stateMap.get(currentStatus).open(activityId, currentStatus);
  }

  public Result doing(String activityId, Enum<Status> currentStatus) {
    return stateMap.get(currentStatus).doing(activityId, currentStatus);
  }
}
