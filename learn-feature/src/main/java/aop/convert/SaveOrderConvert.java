package aop.convert;

import aop.OperateLogDTO;
import aop.service.SaveOrder;

/**
 * @author zhaoxiaoping
 * @date 2022-12-2
 */
public class SaveOrderConvert implements Convert<SaveOrder> {

  @Override
  public OperateLogDTO convert(SaveOrder saveOrder) {
    OperateLogDTO dto = new OperateLogDTO();
    dto.setOrderId(saveOrder.getId());
    return dto;
  }
}
