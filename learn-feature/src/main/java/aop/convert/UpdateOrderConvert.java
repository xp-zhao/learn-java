package aop.convert;

import aop.OperateLogDTO;
import aop.service.UpdateOrder;

/**
 * @author zhaoxiaoping
 * @date 2022-12-2
 */
public class UpdateOrderConvert implements Convert<UpdateOrder> {

  @Override
  public OperateLogDTO convert(UpdateOrder updateOrder) {
    OperateLogDTO dto = new OperateLogDTO();
    dto.setOrderId(updateOrder.getOrderId());
    return dto;
  }
}
