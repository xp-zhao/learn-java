package org.example;

import jakarta.annotation.Resource;
import java.util.List;
import org.example.entity.Award;
import org.example.service.AwardService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
@SpringBootTest
public class SeckillTest {
  @Resource private AwardService awardService;

  @Test
  public void testAward() {
    List<Award> list = awardService.list();
    System.out.println(list);
  }
}
