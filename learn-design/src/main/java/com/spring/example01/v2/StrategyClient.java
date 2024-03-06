package com.spring.example01.v2;

import com.spring.example01.RequestParam;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * 使用策略模式优化
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Component
public class StrategyClient {
  /** 自动注入策略实现集合 */
  @Resource private List<IStrategy> strategyList;

  public RequestParam buildParam(String code, String accountId) {
    IStrategy strategy =
        strategyList.stream().filter(item -> item.match(code)).findFirst().orElse(null);
    return strategy.buildParam(accountId);
  }
}
