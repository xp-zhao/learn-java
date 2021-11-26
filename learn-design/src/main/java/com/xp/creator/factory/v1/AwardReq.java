package com.xp.creator.factory.v1;

import java.util.Map;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: 奖品发送请求对象
 * @Date 2021-4-28
 **/
@Data
public class AwardReq {

  private String uId;
  private Integer awardType;
  private String awardNumber;
  private String bizId;
  private Map<String, String> extMap;
}
