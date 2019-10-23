package core.decimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import org.apache.commons.math3.util.Precision;

/**
 * DecimalFormatDemo.java 小数格式化显示
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/21
 **/
public class DecimalFormatDemo {

  public static void main(String[] args) {
    double PI = 3.1415926;
    System.out.printf("Value with 3 digits after decimal point %.3f %n", PI);
    DecimalFormat format = new DecimalFormat("###.###");
    System.out.println(format.format(PI));
    System.out.println(round(PI, 4));
    // apache.commons.math3
    System.out.println(Precision.round(PI, 4));
  }

  public static double round(double value, int places){
    if(places < 0) {
      throw new IllegalArgumentException();
    }
    BigDecimal bd = BigDecimal.valueOf(value);
    bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
  }
}