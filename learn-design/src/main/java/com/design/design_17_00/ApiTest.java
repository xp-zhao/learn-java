package com.design.design_17_00;

import com.alibaba.fastjson.JSON;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
@Slf4j
public class ApiTest {
  @Test
  public void test() {
    Admin admin = new Admin();
    ConfigOriginator configOriginator = new ConfigOriginator();
    configOriginator.setConfigFile(new ConfigFile("1000001", "配置内容A=哈哈", new Date(), "小傅哥"));
    // 保存配置
    admin.append(configOriginator.saveMemento());
    configOriginator.setConfigFile(new ConfigFile("1000002", "配置内容A=嘻嘻", new Date(), "小傅哥"));
    // 保存配置
    admin.append(configOriginator.saveMemento());
    configOriginator.setConfigFile(new ConfigFile("1000003", "配置内容A=么么", new Date(), "小傅哥"));
    // 保存配置
    admin.append(configOriginator.saveMemento());
    configOriginator.setConfigFile(new ConfigFile("1000004", "配置内容A=嘿嘿", new Date(), "小傅哥"));
    // 保存配置
    admin.append(configOriginator.saveMemento());
    // 历史配置(回滚)
    configOriginator.getMemento(admin.undo());
    log.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));
    // 历史配置(回滚)
    configOriginator.getMemento(admin.undo());
    log.info("历史配置(回滚)undo：{}", JSON.toJSONString(configOriginator.getConfigFile()));
    // 历史配置(前进)
    configOriginator.getMemento(admin.redo());
    log.info("历史配置(前进)redo：{}", JSON.toJSONString(configOriginator.getConfigFile()));
    // 历史配置(获取)
    configOriginator.getMemento(admin.get("1000002"));
    log.info("历史配置(获取)get：{}", JSON.toJSONString(configOriginator.getConfigFile()));
  }
}
