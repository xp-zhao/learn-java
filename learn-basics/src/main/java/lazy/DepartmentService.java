package lazy;

import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: 部门信息查询服务 @Date 2021-11-2 */
@Slf4j
public class DepartmentService {
  public String getDepartment(String uId) {
    log.info("通过用户id查询部门信息: {}", uId);
    return "success";
  }
}
