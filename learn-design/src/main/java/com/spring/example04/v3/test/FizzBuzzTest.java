package com.spring.example04.v3.test;

import com.spring.example04.v3.api.Facts;
import com.spring.example04.v3.api.Rule;
import com.spring.example04.v3.api.RuleEngine;
import com.spring.example04.v3.core.AllRules;
import com.spring.example04.v3.core.AnyRules;
import com.spring.example04.v3.core.DefaultRuleEngine;
import com.spring.example04.v3.core.RuleBuilder;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @date 2024-6-14
 */
@Slf4j
public class FizzBuzzTest {

  @Test
  public void testInput() {
    Rule fizzBuzzRule = buildFizzBuzzRule();
    RuleEngine ruleEngine = new DefaultRuleEngine();
    for (int i = 0; i <= 15; i++) {
      Facts facts = new Facts();
      facts.put("num", i);
      ruleEngine.fire(fizzBuzzRule, facts);
    }
  }

  private Rule buildFizzBuzzRule() {
    Rule fizzRule =
        new RuleBuilder()
            .name("fizzRule")
            .description("fizz rule when input times 3, output is Fizz")
            .priority(10)
            .when(facts -> (int) facts.get("num") % 3 == 0)
            .then(facts -> log.info("fizz"))
            .build();
    Rule buzzRule =
        new RuleBuilder()
            .name("buzzRule")
            .description("buzz rule when input times 5, output is buzz")
            .priority(20)
            .when(facts -> (int) facts.get("num") % 5 == 0)
            .then(facts -> log.info("buzz"))
            .build();
    Rule fizzBuzzRule = AllRules.allOf(fizzRule, buzzRule).name("fizzBuzzRule").priority(1);
    Rule defaultRule =
        new RuleBuilder()
            .name("defaultRule")
            .description("default rule, output number")
            .priority(30)
            .when(facts -> true)
            .then(facts -> log.info(facts.get("num").toString()))
            .build();
    return AnyRules.anyOf(fizzBuzzRule, fizzRule, buzzRule, defaultRule).name("anyRule");
  }
}
