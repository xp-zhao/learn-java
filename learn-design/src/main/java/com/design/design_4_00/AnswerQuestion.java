package com.design.design_4_00;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 解答题
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnswerQuestion {

  /** 问题 */
  private String name;
  /** 答案 */
  private String key;
}
