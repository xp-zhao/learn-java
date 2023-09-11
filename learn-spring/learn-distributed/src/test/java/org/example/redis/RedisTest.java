package org.example.redis;

import cn.hutool.core.collection.CollUtil;
import jakarta.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @author zhaoxiaoping
 * @date 2023-9-11
 */
@Slf4j
@SpringBootTest
public class RedisTest {
  @Resource private RedisTemplate redisTemplate;
  @Resource private StringRedisTemplate stringRedisTemplate;

  @Test
  public void testGet() {
    Boolean result = stringRedisTemplate.opsForValue().getBit("xp", 1);
    System.out.println(result);
  }

  @Test
  public void testBit() {
    LocalDateTime now = LocalDateTime.now();
    String keySuffix = now.format(DateTimeFormatter.ofPattern(":yyyyMM"));
    String key = "USER_SIGN:XP" + keySuffix;
    // 当前是本月的第几天
    int dayOfMonth = now.getDayOfMonth();
    stringRedisTemplate.opsForValue().setBit(key, 0, true);
    // 获取本月截止到今天为止的所有签到记录
    List<Long> result =
        stringRedisTemplate
            .opsForValue()
            .bitField(
                key,
                BitFieldSubCommands.create()
                    .get(BitFieldSubCommands.BitFieldType.unsigned(dayOfMonth))
                    .valueAt(0));
    if (CollUtil.isEmpty(result)) {
      return;
    }
    Long count = result.get(0);
    // 总的签到数
    log.info("总签到数：{}", getSignCount(count));
    // 连续签到数
    log.info("连续签到数：{}", getContinueSignCount(count));
  }

  private int getContinueSignCount(Long count) {
    int result = 0;
    while (true) {
      // 通过 与 运算来判断二进制位上的数字是否为 0
      if ((count & 1) == 0) {
        break;
      } else {
        result++;
      }
      count >>>= 1;
    }
    return result;
  }

  private int getSignCount(Long count) {
    int result = 0;
    int loopCount = 0;
    while (true) {
      if ((count & 1) == 1) {
        result++;
      }
      if (loopCount > 31) {
        break;
      }
      count >>>= 1;
      loopCount++;
    }
    return result;
  }
}
