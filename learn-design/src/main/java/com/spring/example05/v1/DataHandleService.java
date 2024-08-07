package com.spring.example05.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 数据处理服务
 *
 * @author zhaoxiaoping
 * @date 2024-8-6
 */
@Slf4j
@Service
public class DataHandleService {

  public void filterData() {
    log.info("过滤数据");
  }

  public void convertData() {
    log.info("数据转换");
  }

  public void writeHistory() {
    log.info("写数据处理记录");
  }
}
