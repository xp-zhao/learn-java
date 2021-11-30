package com.design.design_11_01;

import java.util.Date;
import lombok.Data;

/**
 * 活动实体
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Data
public class Activity {
  /** 活动ID */
  private Long id;

  /** 活动名称 */
  private String name;

  /** 活动描述 */
  private String desc;

  /** 开始时间 */
  private Date startTime;

  /** 结束时间 */
  private Date stopTime;

  /** 活动库存 */
  private Stock stock;
}
