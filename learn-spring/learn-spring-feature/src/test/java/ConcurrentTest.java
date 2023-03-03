import com.example.feature.Application;
import com.example.feature.concurrent.component.ProducerAndConsumerComponent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @author zhaoxiaoping
 * @date 2023-3-3
 */
@SpringBootTest(classes = Application.class)
public class ConcurrentTest {

  @Autowired private ProducerAndConsumerComponent producerAndConsumerComponent;

  @Test
  public void add() throws InterruptedException {
    for (int i = 0; i < 10; i++) {
      producerAndConsumerComponent.add(String.valueOf(i));
    }
    TimeUnit.SECONDS.sleep(10);
  }
}
