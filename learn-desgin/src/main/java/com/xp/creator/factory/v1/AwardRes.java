package com.xp.creator.factory.v1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhaoxiaoping
 * @Description: 奖品发送返回对象
 * @Date 2021-4-28
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AwardRes {

  private String code;
  private String info;
}
