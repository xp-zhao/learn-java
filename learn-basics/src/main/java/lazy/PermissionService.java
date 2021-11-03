package lazy;

import java.util.Collections;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;

/** @author zhaoxiaoping @Description: 权限信息查询服务 @Date 2021-11-2 */
@Slf4j
public class PermissionService {
  public Set<String> getPermissions(String department, Long supervisor) {
    log.info("通过部门和主管查询权限信息: {}, {}", department, supervisor);
    return Collections.emptySet();
  }
}
