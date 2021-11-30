package com.design.design_11_02;

import com.design.design_11_01.Activity;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 活动工厂(提供固定数据的查询)
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class ActivityFactory {
  static Map<Long, Activity> activityMap = new HashMap<>();

  public static Activity getActivity(Long id) {
    Activity activity = activityMap.get(id);
    if (null == activity) {
      // 模拟从实际业务应用从接口中获取活动信息
      activity = new Activity();
      activity.setId(10001L);
      activity.setName("图书嗨乐");
      activity.setDesc("图书优惠券分享激励分享活动第二期");
      activity.setStartTime(new Date());
      activity.setStopTime(new Date());
      activityMap.put(id, activity);
    }
    return activity;
  }
}
