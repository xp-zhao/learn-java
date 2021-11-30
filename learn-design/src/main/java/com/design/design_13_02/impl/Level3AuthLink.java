package com.design.design_13_02.impl;

import com.design.design_13_00.AuthInfo;
import com.design.design_13_00.AuthService;
import com.design.design_13_02.AuthLink;
import java.text.ParseException;
import java.util.Date;

/**
 * 三级负责人审核
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class Level3AuthLink extends AuthLink {

  private Date beginDate = f.parse("2020-06-01 00:00:00");
  private Date endDate = f.parse("2020-06-25 23:59:59");

  public Level3AuthLink(String levelUserId, String levelUserName) throws ParseException {
    super(levelUserId, levelUserName);
  }

  @Override
  public AuthInfo doAuth(String uId, String orderId, Date authDate) {
    Date date = AuthService.queryAuthInfo(levelUserId, orderId);
    if (null == date) {
      return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", levelUserName);
    }
    AuthLink next = super.next();
    if (null == next) {
      return new AuthInfo(
          "0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
    }
    if (authDate.before(beginDate) || authDate.after(endDate)) {
      return new AuthInfo(
          "0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
    }
    return next.doAuth(uId, orderId, authDate);
  }
}
