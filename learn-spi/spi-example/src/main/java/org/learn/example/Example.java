package org.learn.example;

import org.learn.spi.ISpiService;

import java.util.ServiceLoader;

/**
 * TODO
 *
 * @author xp-zhao
 * @date 2022/4/16
 */
public class Example {
  public static void main(String[] args) {
    ServiceLoader<ISpiService> load = ServiceLoader.load(ISpiService.class);
    for (ISpiService service : load) {
      service.connectInternet();
    }
  }
}
