package com.xp.image;

import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.io.resource.Resource;
import java.awt.Font;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;

/**
 * 宋体
 */
public final class SimsunFont {

  private static Font simsunFont;

  static {
    simsunFont = initSimsunFont();
    Objects.requireNonNull(simsunFont);
  }


  /**
   * 创建宋体
   *
   * @param size 字体大小
   * @return
   */
  public static Font getSimsunFont(float size) {
    return getSimsunFont(Font.PLAIN, size);
  }

  /**
   * 创建宋体
   *
   * @param style 字体样式
   * @param size  字体大小
   * @return
   */
  public static Font getSimsunFont(int style, float size) {
    Font font = null;

    try {
      font = simsunFont.deriveFont(style);
      font = font.deriveFont(size);
    } catch (Exception e) {

    }
    return font;
  }

  private static Font initSimsunFont() {
    try {
      Resource url = new ClassPathResource("/fonts/simsun.ttc");
//      Assert.isTrue(url.exists(), "/fonts/simsun.ttc 不存在!");
      Font font = Font.createFont(Font.TRUETYPE_FONT, url.getStream());

      return font;
    } catch (Exception e) {
    }
    return null;
  }


}
