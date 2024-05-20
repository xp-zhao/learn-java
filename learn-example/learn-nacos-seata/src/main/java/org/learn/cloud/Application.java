package org.learn.cloud;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.cloud.nacos.NacosConfigProperties;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author zhaoxiaoping
 * @date 2024-5-17
 */
@SpringBootApplication
public class Application {
  public static void main(String[] args) throws NacosException {
    //    SpringApplication.run(Application.class, args);
    ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
    NacosConfigManager nacosConfigManager = context.getBean(NacosConfigManager.class);
    NacosConfigProperties nacosConfigProperties = nacosConfigManager.getNacosConfigProperties();
    System.out.println(nacosConfigProperties);
  }
}
