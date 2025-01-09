import com.example.feature.Application;
import com.example.feature.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author xp-zhao
 * @description 用户注册测试
 * @date 2022/9/23 22:04
 */
@Slf4j
@SpringBootTest(classes = Application.class)
public class UserRegisterTest {

  @Autowired private UserService userService;

  @Test
  public void testRegister() {
    userService.register("xp");
  }

  @Test
  public void testOrder() {
    userService.order("xp");
  }

  @Test
  public void testEventPublish() {
    userService.eventPublish("xp");
  }
}
