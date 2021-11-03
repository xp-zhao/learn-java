package lazy;

import java.util.Set;

/** @author zhaoxiaoping @Description: 用户工厂 @Date 2021-11-2 */
public class UserFactory {
  private DepartmentService departmentService = new DepartmentService();
  private SupervisorService supervisorService = new SupervisorService();
  private PermissionService permissionService = new PermissionService();

  public User buildUser(String uid) {
    // 获取部门信息
    Lazy<String> departmentLazy = Lazy.of(() -> departmentService.getDepartment(uid));
    // 通过部门获取主管
    Lazy<Long> supervisorLazy =
        departmentLazy.map(department -> supervisorService.getSupervisor(department));
    // 通过部门和主管获取权限
    Lazy<Set<String>> permissionsLazy =
        departmentLazy.flatMap(
            department ->
                supervisorLazy.map(
                    supervisor -> permissionService.getPermissions(department, supervisor)));
    User user = new User();
    user.setUid(0L);
    user.setDepartment(departmentLazy);
    user.setSupervisor(supervisorLazy);
    user.setPermission(permissionsLazy);
    return user;
  }
}
