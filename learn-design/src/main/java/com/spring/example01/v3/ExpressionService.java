package com.spring.example01.v3;

import com.spring.example01.RequestParam;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import javax.annotation.Resource;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

/**
 * @author zhaoxiaoping
 * @date 2024-3-6
 */
@Service
public class ExpressionService {
  @Resource private ExpressionUtil expressionUtil;

  public RequestParam buildParam(String code, String accountId) throws IllegalAccessException {
    StandardEvaluationContext content = expressionUtil.createContent(accountId);
    RequestParam param = new RequestParam();
    // 模拟配置表的数据，list 中的数据可以由数据库中查询出来，这样后续有新类型增加就可以直接在数据库中增加配置
    List<Pair<String, String>> list = new ArrayList<>();
    list.add(
        new Pair<>(
            "businessCode",
            "#upperCase(\"Alipay_\"+#substringBefore(\"1231@23123\", \"@\")+\"_BUSINESS\")"));
    list.add(new Pair<>("businessType", "1"));
    for (Pair<String, String> p : list) {
      Field field = ReflectionUtils.findField(RequestParam.class, p.getKey());
      Expression expression = expressionUtil.getExpressionWithCache("xxx", p.getValue());
      // 通过表达式获取解析后的结果值
      Object value = expression.getValue(content);
      field.setAccessible(true);
      field.set(param, value);
    }
    return param;
  }
}
