package com.xp.image;

import java.awt.Point;
import net.coobird.thumbnailator.geometry.Position;

/**
 * 图片上文字的位置
 * 
 * @author jiangyong
 *
 */
public class TextPositionDTO implements Position {

  private Point point;

  /**
   * 图片上文字的位置
   * 
   * @param x
   * @param y
   */
  public TextPositionDTO(int x, int y) {
    super();
    this.point = new Point(x, y);
  }


  @Override
  public Point calculate(int enclosingWidth, int enclosingHeight, int width, int height,
      int insetLeft, int insetRight, int insetTop, int insetBottom) {
    return point;
  }

}
