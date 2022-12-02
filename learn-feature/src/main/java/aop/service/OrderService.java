package aop.service;

import aop.RecordOperate;
import aop.convert.SaveOrderConvert;
import aop.convert.UpdateOrderConvert;
import org.springframework.stereotype.Service;

/**
 * 订单服务
 *
 * @author zhaoxiaoping
 * @date 2022-12-2
 */
@Service
public class OrderService {
  @RecordOperate(desc = "保存订单", convert = SaveOrderConvert.class)
  public boolean saveOrder(SaveOrder saveOrder) {
    System.out.println("save order, orderId: " + saveOrder.getId());
    return true;
  }

  @RecordOperate(desc = "更新订单", convert = UpdateOrderConvert.class)
  public boolean updateOrder(UpdateOrder updateOrder) {
    System.out.println("update order, orderId: " + updateOrder.getOrderId());
    return true;
  }
}
