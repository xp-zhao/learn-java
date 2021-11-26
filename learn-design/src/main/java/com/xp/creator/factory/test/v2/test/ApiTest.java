package v2.test;

import com.xp.creator.factory.v2.StoreFactory;
import com.xp.creator.factory.v2.store.ICommodity;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @Description: 测试
 * @Date 2021-4-28
 **/
public class ApiTest {

  @Test
  public void testCommodity() throws Exception {
    StoreFactory storeFactory = new StoreFactory();

    // 1. 优惠券
    ICommodity commodityService_1 = storeFactory.getCommodityService(1);
    commodityService_1.sendCommodity("10001", "EGM1023938910232121323432", "791098764902132", null);

    // 2. 实物商品
    ICommodity commodityService_2 = storeFactory.getCommodityService(2);
    Map<String, String> extMap = new HashMap<String, String>();
    extMap.put("consigneeUserName", "谢飞机");
    extMap.put("consigneeUserPhone", "15200292123");
    extMap.put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");

    commodityService_2.sendCommodity("10001", "9820198721311", "1023000020112221113",
        new HashMap<String, String>() {{
          put("consigneeUserName", "谢飞机");
          put("consigneeUserPhone", "15200292123");
          put("consigneeUserAddress", "吉林省.长春市.双阳区.XX街道.檀溪苑小区.#18-2109");
        }});

    // 3. 第三方兑换卡(爱奇艺)
    ICommodity commodityService_3 = storeFactory.getCommodityService(3);
    commodityService_3.sendCommodity("10001", "AQY1xjkUodl8LO975GdfrYUio", null, null);

  }
}
