package com.design.design_1_01;

import java.util.Map;
import lombok.Data;

/**
 * 请求参数
 *
 * @author zhaoxiaoping
 * @date 2021-11-26
 */
@Data
public class AwardReq {
  /** 用户唯一ID */
  private String uId;
  /** 奖品类型(可以用枚举定义)；1优惠券、2实物商品、3第三方兑换卡(爱奇艺) */
  private Integer awardType;
  /** 奖品编号；sku、couponNumber、cardId */
  private String awardNumber;
  /** 业务ID，防重复 */
  private String bizId;
  /** 扩展信息 */
  private Map<String, String> extMap;

  public static void main(String[] args) {
    System.out.println("xxx");
  }
}
