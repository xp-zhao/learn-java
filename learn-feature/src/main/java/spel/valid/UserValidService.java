package spel.valid;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaoxiaoping
 * @date 2024-5-28
 */
@Slf4j
@Service
public class UserValidService {
  @ValidPermission(userId = "#userId")
  public void query(String userId) {
    log.info("query success, userId: {}", userId);
  }
}
