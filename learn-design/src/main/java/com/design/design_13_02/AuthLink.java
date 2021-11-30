package com.design.design_13_02;

import com.design.design_13_00.AuthInfo;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 审核链路抽象
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public abstract class AuthLink {
  /** 时间格式化 */
  protected SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  /** 级别人员ID */
  protected String levelUserId;
  /** 级别人员姓名 */
  protected String levelUserName;
  /** 责任链 */
  private AuthLink next;

  public AuthLink(String levelUserId, String levelUserName) {
    this.levelUserId = levelUserId;
    this.levelUserName = levelUserName;
  }

  public AuthLink next() {
    return next;
  }

  public AuthLink appendNext(AuthLink next) {
    this.next = next;
    return this;
  }

  /**
   * 审核发放
   *
   * @param uId 用户id
   * @param orderId 订单id
   * @param authDate 认证日期
   * @return {@code AuthInfo}
   */
  public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
