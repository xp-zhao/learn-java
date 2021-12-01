package com.design.design_19_00;

/**
 * 活动状态
 *
 * @author zhaoxiaoping
 * @date 2021-12-1
 */
public enum Status {
  // 创建编辑
  EDITING,
  // 待审核
  CHECK,
  // 审核通过(任务扫描成活动中)
  PASS,
  // 审核拒绝(可以撤审到编辑状态)
  REFUSE,
  // 活动中
  DOING,
  // 活动关闭
  CLOSE,
  // 活动开启(任务扫描成活动中)
  OPEN
}
