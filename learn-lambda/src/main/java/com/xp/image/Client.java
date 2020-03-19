package com.xp.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import javax.imageio.ImageIO;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date 2020/2/22
 **/
public class Client {

  public static void main(String[] args) {
    String format = "png";
    ImageService imageService = new ImageService();
    BufferedImage data = imageService.addText(130, 170,
        "http://images.noahedu.com/product/N5.png",
        Arrays.asList(new ImageText("定制版", 20, new TextPositionDTO(10, 10), Color.RED)));

    try {
      ImageIO.write(data, format, new File("D://out." + format));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
