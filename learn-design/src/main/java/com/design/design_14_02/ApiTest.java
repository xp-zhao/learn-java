package com.design.design_14_02;

import com.design.design_14_02.cook.impl.GuangDongCook;
import com.design.design_14_02.cook.impl.JiangSuCook;
import com.design.design_14_02.cook.impl.ShanDongCook;
import com.design.design_14_02.cook.impl.SiChuanCook;
import com.design.design_14_02.cuisine.ICuisine;
import com.design.design_14_02.cuisine.impl.GuangDoneCuisine;
import com.design.design_14_02.cuisine.impl.JiangSuCuisine;
import com.design.design_14_02.cuisine.impl.ShanDongCuisine;
import com.design.design_14_02.cuisine.impl.SiChuanCuisine;
import org.junit.Test;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2021-11-30
 */
public class ApiTest {
  @Test
  public void test() {

    // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
    ICuisine guangDoneCuisine = new GuangDoneCuisine(new GuangDongCook());
    JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
    ShanDongCuisine shanDongCuisine = new ShanDongCuisine(new ShanDongCook());
    SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());

    // 点单
    XiaoEr xiaoEr = new XiaoEr();
    xiaoEr.order(guangDoneCuisine);
    xiaoEr.order(jiangSuCuisine);
    xiaoEr.order(shanDongCuisine);
    xiaoEr.order(siChuanCuisine);

    // 下单
    xiaoEr.placeOrder();
  }
}
