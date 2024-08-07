package com.spring.example05.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 抽象流程模版
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Slf4j
@RequiredArgsConstructor
public abstract class ProcessTemplate {
  private final DataHandleService dataHandleService;

  /** 前置处理 */
  protected abstract void beforeHandle();

  /** 公共处理流程 */
  protected void commonHandle() {
    // 数据过滤
    dataHandleService.filterData();
    // 数据转换
    dataHandleService.convertData();
    // 日志记录
    dataHandleService.writeHistory();
  }

  /** 流程的特殊处理逻辑 */
  protected abstract void specialHandle();

  public void afterHandle() {
    log.info("流程后置处理");
  }
}
