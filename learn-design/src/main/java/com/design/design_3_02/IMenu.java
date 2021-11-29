package com.design.design_3_02;

import com.design.design_3_00.Matter;

/**
 * 菜单
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public interface IMenu {
  /** 吊顶 */
  IMenu appendCeiling(Matter matter);

  /** 涂料 */
  IMenu appendCoat(Matter matter);

  /** 地板 */
  IMenu appendFloor(Matter matter);

  /** 地砖 */
  IMenu appendTile(Matter matter);

  /** 明细 */
  String getDetail();
}
