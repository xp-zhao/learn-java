package com.spring.example01.v3;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Slf4j
@Service
public class ExpressionUtil {
  private final ExpressionParser expressionParser = new SpelExpressionParser();

  /** 创建上下文对象，设置自定义变量、自定义函数 */
  public StandardEvaluationContext createContent(String accountId) {
    StandardEvaluationContext context = new StandardEvaluationContext();
    context.setVariable("accountId", accountId);
    // 注册自定义函数
    this.registryFunction(context);
    return context;
  }

  /** 注册自定义函数 */
  private void registryFunction(StandardEvaluationContext context) {
    try {
      context.addPropertyAccessor(new MapAccessor());
      context.registerFunction(
          "substringBefore",
          StringUtils.class.getDeclaredMethod("substringBefore", String.class, String.class));
      context.registerFunction(
          "upperCase", StringUtils.class.getDeclaredMethod("upperCase", String.class));
    } catch (Exception e) {
      log.error("SpEL 自定义函数注册失败:", e);
    }
  }

  /** 获取表达式对象，可开启缓存（当前未实现） */
  //  @Cacheable(key="'getExpressionWithCache:'+#cacheKey", unless = "#result == null")
  public Expression getExpressionWithCache(String cacheKey, String expressionString) {
    try {
      return expressionParser.parseExpression(expressionString);
    } catch (Exception e) {
      log.error("SpEL表达式解析异常,表达式:[{}]", expressionString, e);
      throw new RuntimeException("SpEL表达式解析异常");
    }
  }
}
