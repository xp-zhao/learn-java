package com.design.design_4_02;

import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class ApiTest {
  @Test
  public void testQuestionBank() throws CloneNotSupportedException {
    QuestionBankController questionBankController = new QuestionBankController();
    System.out.println(questionBankController.createPaper("花花", "1000001921032"));
    System.out.println(questionBankController.createPaper("豆豆", "1000001921051"));
    System.out.println(questionBankController.createPaper("大宝", "1000001921987"));
  }
}
