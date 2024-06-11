package qlexpress;

import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * QLExpress 单元测试
 *
 * @author zhaoxiaoping
 * @date 2024-6-11
 */
@Slf4j
public class QLExpressTest {
  @Test
  public void test_1() throws Exception {
    ExpressRunner runner = new ExpressRunner();
    DefaultContext<String, Object> context = new DefaultContext<String, Object>();
    context.put("a", 1);
    context.put("b", 2);
    context.put("c", 3);
    String express = "a + b * c";
    Object r = runner.execute(express, context, null, true, false);
    log.info("执行结果：{}", r);
  }

  @Test
  public void test_2() throws Exception {
    String expressName = "ql/approve";
    ExpressRunner expressRunner = new ExpressRunner();
    expressRunner.loadExpress(expressName);
    DefaultContext<String, Object> context = new DefaultContext<String, Object>();
    context.put("a", 2);
    context.put("b", 3);
    context.put("c", 4);
    Object r = expressRunner.executeByExpressName(expressName, context, null, true, false);
    log.info("执行结果：{}", r);
  }
}
