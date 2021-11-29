package com.design.design_4_00;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 选择题
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChoiceQuestion {
  /** 题目 */
  private String name;
  /** 选项；A、B、C、D */
  private Map<String, String> option;
  /** 答案；B */
  private String key;
}
