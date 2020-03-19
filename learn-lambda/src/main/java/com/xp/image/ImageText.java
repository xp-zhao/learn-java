package com.xp.image;

import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;
import net.coobird.thumbnailator.geometry.Position;

public class ImageText implements Serializable {
  // 所在图片中的位置
  private Position position;
  // 文体内容
  private String content;
  // 字体(大小，样式)
  private Font font;
  // 字体颜色
  private Color color;
  // 透明度
  private float opacity;

  public ImageText(String content, Integer size, Position position) {
    this(position, content, Font.PLAIN, size * 1.0F);
  }

  public ImageText(String content, Integer size, Position position, Color color) {
    this(position, content, SimsunFont.getSimsunFont(Font.PLAIN, size), color);
  }

  /**
   * 
   * @param content
   * @param size
   * @param position
   * @param style Font.
   * @param color
   */
  public ImageText(String content, Integer size, Position position, int style, Color color) {
    this(position, content, SimsunFont.getSimsunFont(style, size), color);
  }

  // 以下是标准
  public ImageText(Position position, String content) {
    this(position, content, SimsunFont.getSimsunFont(Font.PLAIN, 10));
  }

  public ImageText(Position position, String content, int style, float size) {
    this(position, content, SimsunFont.getSimsunFont(style, size));
  }

  public ImageText(Position position, String content, Font font) {
    this(position, content, font, Color.BLACK);
  }

  public ImageText(Position position, String content, Font font, Color color) {
    this(position, content, font, color, 0.8f);
  }

  public ImageText(Position position, String content, Font font, Color color, float opacity) {
    super();
    this.position = position;
    this.content = content;
    this.font = font;
    this.color = color;
    this.opacity = opacity;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Font getFont() {
    return font;
  }

  public void setFont(Font font) {
    this.font = font;
  }

  public Color getColor() {
    return color;
  }

  public void setColor(Color color) {
    this.color = color;
  }

  public float getOpacity() {
    return opacity;
  }

  public void setOpacity(float opacity) {
    this.opacity = opacity;
  }



}
