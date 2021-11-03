package lazy;

import java.util.Set;
import lombok.Data;

/** @author zhaoxiaoping @Description: 用户实体 @Date 2021-11-2 */
@Data
public class User {
  /** 用户 id */
  private Long uid;
  /**
   * 用户的部门，为了保持示例简单，这里就用普通的字符串<br>
   * 需要远程调用 通讯录系统 获得
   */
  private Lazy<String> department;
  /**
   * 用户的主管，为了保持示例简单，这里就用一个 id 表示<br>
   * 需要远程调用 通讯录系统 获得
   */
  private Lazy<Long> supervisor;
  /** 用户所持有的权限 需要远程调用 权限系统 获得 */
  private Lazy<Set<String>> permission;
  
  public String getDepartment() {
    return department.get();
  }

  public Long getSupervisor() {
    return supervisor.get();
  }

  public Set<String> getPermission() {
    return permission.get();
  }
}
