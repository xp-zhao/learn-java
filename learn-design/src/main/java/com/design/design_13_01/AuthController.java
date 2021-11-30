package com.design.design_13_01;

import com.design.design_13_00.AuthInfo;
import com.design.design_13_00.AuthService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 控制层
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class AuthController {
  private SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 时间格式化

  public AuthInfo doAuth(String uId, String orderId, Date authDate) throws ParseException {

    // 三级审批
    Date date = AuthService.queryAuthInfo("1000013", orderId);
    if (null == date) {
      return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", "王工");
    }

    // 二级审批
    if (authDate.after(f.parse("2020-06-01 00:00:00"))
        && authDate.before(f.parse("2020-06-25 23:59:59"))) {
      date = AuthService.queryAuthInfo("1000012", orderId);
      if (null == date) {
        return new AuthInfo("0001", "单号：", orderId, " 状态：待二级审批负责人 ", "张经理");
      }
    }
    // 一级审批
    if (authDate.after(f.parse("2020-06-11 00:00:00"))
        && authDate.before(f.parse("2020-06-20 23:59:59"))) {
      date = AuthService.queryAuthInfo("1000011", orderId);
      if (null == date) {
        return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", "段总");
      }
    }
    return new AuthInfo("0001", "单号：", orderId, " 状态：审批完成");
  }
}
