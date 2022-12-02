package aop;

import lombok.Data;

/**
 * 操作日志 DTO 对象
 *
 * @author zhaoxiaoping
 * @date 2022-12-2
 */
@Data
public class OperateLogDTO {
  private Long orderId;
  private String desc;
  private String result;
}
