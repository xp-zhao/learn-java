package com.design.design_13_02.impl;

import com.design.design_13_00.AuthInfo;
import com.design.design_13_00.AuthService;
import com.design.design_13_02.AuthLink;
import java.util.Date;

/**
 * 一级负责人审核
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class Level1AuthLink extends AuthLink {

  public Level1AuthLink(String levelUserId, String levelUserName) {
    super(levelUserId, levelUserName);
  }

  @Override
  public AuthInfo doAuth(String uId, String orderId, Date authDate) {
    Date date = AuthService.queryAuthInfo(levelUserId, orderId);
    if (null == date) {
      return new AuthInfo("0001", "单号：", orderId, " 状态：待一级审批负责人 ", levelUserName);
    }
    AuthLink next = super.next();
    if (null == next) {
      return new AuthInfo(
          "0000", "单号：", orderId, " 状态：一级审批完成负责人", " 时间：", f.format(date), " 审批人：", levelUserName);
    }
    return next.doAuth(uId, orderId, authDate);
  }
}
