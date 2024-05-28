package spel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import spel.valid.SpelConfig;
import spel.valid.UserValidService;

/**
 * @author zhaoxiaoping
 * @date 2024-5-28
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpelConfig.class, loader = AnnotationConfigContextLoader.class)
public class SpelTest {
  @Autowired private UserValidService userValidService;

  @Test
  public void testQuery() {
    userValidService.query("1");
  }
}
