package com.example.feature.concurrent;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2023-3-2
 */
@Slf4j
public class ProcessorImpl implements Processor<String> {
  @Override
  public void process(List<String> list) {
    log.info("接收到数据: {}", list);
  }
}
