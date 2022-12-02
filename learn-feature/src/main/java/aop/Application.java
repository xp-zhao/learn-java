package aop;

import aop.service.OrderService;
import aop.service.SaveOrder;
import aop.service.UpdateOrder;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 启动类
 *
 * @author zhaoxiaoping
 * @date 2022-12-2
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

  public static void main(String[] args) {
    new SpringApplication(Application.class).run(args);
  }

  @Resource private OrderService orderService;

  @Override
  public void run(String... args) throws Exception {
    SaveOrder saveOrder = new SaveOrder();
    saveOrder.setId(1L);
    orderService.saveOrder(saveOrder);

    UpdateOrder updateOrder = new UpdateOrder();
    updateOrder.setOrderId(2L);
    orderService.updateOrder(updateOrder);
  }
}
