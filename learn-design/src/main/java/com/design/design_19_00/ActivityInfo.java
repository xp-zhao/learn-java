package com.design.design_19_00;

import java.util.Date;
import lombok.Data;

/**
 * 活动信息
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
@Data
public class ActivityInfo {
  /** 活动ID */
  private String activityId;

  /** 活动名称 */
  private String activityName;

  /** 活动状态 */
  private Enum<Status> status;

  /** 开始时间 */
  private Date beginTime;

  /** 结束时间 */
  private Date endTime;
}
