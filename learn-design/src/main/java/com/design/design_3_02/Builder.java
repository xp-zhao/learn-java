package com.design.design_3_02;

import com.design.design_3_00.ceiling.LevelOneCeiling;
import com.design.design_3_00.ceiling.LevelTwoCeiling;
import com.design.design_3_00.coat.DuluxCoat;
import com.design.design_3_00.coat.LiBangCoat;
import com.design.design_3_00.floor.ShengXiangFloor;
import com.design.design_3_00.tile.DongPengTile;
import com.design.design_3_00.tile.MarcoPoloTile;

/**
 * 建造者
 *
 * @author zhaoxiaoping
 * @date 2021-11-29
 */
public class Builder {
  public IMenu levelOne(Double area) {
    return new DecorationPackageMenu(area, "豪华欧式")
        .appendCeiling(new LevelTwoCeiling())
        .appendCoat(new DuluxCoat())
        .appendFloor(new ShengXiangFloor());
  }

  public IMenu levelTwo(Double area) {
    return new DecorationPackageMenu(area, "轻奢田园")
        .appendCeiling(new LevelTwoCeiling())
        .appendCoat(new LiBangCoat())
        .appendTile(new MarcoPoloTile());
  }

  public IMenu levelThree(Double area) {
    return new DecorationPackageMenu(area, "现代简约")
        .appendCeiling(new LevelOneCeiling())
        .appendCoat(new LiBangCoat())
        .appendTile(new DongPengTile());
  }
}
