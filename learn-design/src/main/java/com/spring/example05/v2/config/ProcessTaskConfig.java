package com.spring.example05.v2.config;

import com.google.common.collect.Lists;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 流程任务配置
 *
 * @author zhaoxiaoping
 * @date 2024-8-7
 */
public class ProcessTaskConfig {
  public static Map<String, List<String>> taskChainConfig =
      new HashMap<String, List<String>>() {
        {
          put("dataHandleProcess", Lists.newArrayList("dataGenerate", "dataReview", "dataAccept"));
        }
      };
}
