package org.learn.db.innodb;

/**
 * COMPACT行格式
 *
 * @author zhaoxiaoping
 * @date 2024-9-3
 */
public class Compact {
  /** 变长字段长度列表, 逆序存放 */
  private int[] variableLengths;

  /** 空值列表, 逆序存放 */
  private int[] nullValueArr;

  /** 记录头信息 */
  private int[] headArr;

  /** 记录的真实数据 */
  private int[] recordDataArr;
}
