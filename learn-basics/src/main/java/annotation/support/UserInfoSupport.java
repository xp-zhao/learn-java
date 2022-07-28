package annotation.support;

import cn.hutool.core.convert.Convert;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 用户信息支撑
 *
 * @author zhaoxiaoping
 * @date 2022-7-28
 */
public class UserInfoSupport {

  /**
   * 设置用户名
   *
   * @param userInfo 用户信息
   */
  public static void setUserInfo(IUserInfo userInfo) {
    String userId = userInfo.getUserId();
    userInfo.setAge(1);
    userInfo.setUserName(Convert.toStr(userId));
  }

  /**
   * 设置用户名
   *
   * @param userInfo 用户信息
   */
  public static void setUserInfo(List<? extends IUserInfo> userInfo) {
    List<String> userIds = userInfo.stream().map(IUserInfo::getUserId).collect(Collectors.toList());
    Map<String, String> userMap =
        userIds.stream()
            .collect(Collectors.toMap(id -> id, id -> Convert.toStr(id), (k1, k2) -> k1));
    for (IUserInfo item : userInfo) {
      item.setAge(1);
      item.setUserName(userMap.get(item.getUserId()));
    }
  }
}
