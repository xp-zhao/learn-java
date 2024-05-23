package org.example.hotswap;

import java.util.*;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @date 2024-5-22
 */
@Slf4j
public class JavaAgent {
  public static void query(Integer id) throws InterruptedException {
    Thread.sleep(2000);
    log.info("[JavaAgent] query method called, param: {}", id);
  }

  public static void main(String[] args) throws InterruptedException {
    query(1);
    query(2);
  }
}
