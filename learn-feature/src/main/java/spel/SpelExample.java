package spel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * spel 使用示例
 *
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Slf4j
public class SpelExample {
  public static void main(String[] args) {
    // ExpressionParser 对象，解析 spel 表达式
    ExpressionParser parser = new SpelExpressionParser();
    String expressionStr = "#number > 10 ? 'true' : 'false'";
    Expression expression = parser.parseExpression(expressionStr);

    // 创建EvaluationContext对象，用于设置参数值
    StandardEvaluationContext context = new StandardEvaluationContext();
    context.setVariable("number", 11);

    // 求解表达式，获取结果
    String result = expression.getValue(context, String.class);
    log.info("表达式结果：{}", result);
  }
}
