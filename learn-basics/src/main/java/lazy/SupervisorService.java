package lazy;

import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: 主管信息查询服务 @Date 2021-11-2 */
@Slf4j
public class SupervisorService {
  public Long getSupervisor(String department) {
    log.info("通过部门id查询主管信息: {}", department);
    return 0L;
  }
}
