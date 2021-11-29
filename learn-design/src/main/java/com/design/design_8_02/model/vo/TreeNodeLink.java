package com.design.design_8_02.model.vo;

import lombok.Data;

/**
 * 规则树链接信息
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
public class TreeNodeLink {
  /** 节点From */
  private Long nodeIdFrom;

  /** 节点To */
  private Long nodeIdTo;

  /** 限定类型；1:=;2:>;3:<;4:>=;5<=;6:enum[枚举范围] */
  private Integer ruleLimitType;

  /** 限定值 */
  private String ruleLimitValue;
}
