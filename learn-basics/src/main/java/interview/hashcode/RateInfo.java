package interview.hashcode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/** @author zhaoxiaoping @Description: @Date 2021-9-26 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateInfo {
  /** 最大Hash */
  private int maxHash;
  /** 最小Hash */
  private int minHash;
  /** hash计算乘机因子 */
  private int multiplier;
  /** 碰撞数 */
  private int collisionCount;
  /** 碰撞比率 */
  private double collisionRate;
}
