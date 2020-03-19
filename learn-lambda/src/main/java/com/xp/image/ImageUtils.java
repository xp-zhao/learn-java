package com.xp.image;

import java.awt.Graphics;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import javax.swing.ImageIcon;

/**
 * 角色 Thumbnails 变红色问题
 * <p>
 * o
 */
public class ImageUtils {

  // 把原图转换成二进制
  public static byte[] toByteArray(InputStream input) {
    if (input == null) {
      return null;
    }
    ByteArrayOutputStream output = null;
    byte[] result = null;
    try {
      output = new ByteArrayOutputStream();
      byte[] buffer = new byte[1024 * 100];
      int n = 0;
      while (-1 != (n = input.read(buffer))) {
        output.write(buffer, 0, n);
      }
      result = output.toByteArray();
      if (output != null) {
        output.close();
      }
    } catch (Exception e) {
    }
    return result;
  }

  // 把二进制转换成图片
  public static BufferedImage toBufferedImage(byte[] imagedata) {
    Image image = Toolkit.getDefaultToolkit().createImage(imagedata);
    if (image instanceof BufferedImage) {
      return (BufferedImage) image;
    }
    image = new ImageIcon(image).getImage();
    BufferedImage bimage = null;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    try {
      int transparency = Transparency.OPAQUE;
      GraphicsDevice gs = ge.getDefaultScreenDevice();
      GraphicsConfiguration gc = gs.getDefaultConfiguration();
      bimage = gc.createCompatibleImage(image.getWidth(null), image.getHeight(null), transparency);
    } catch (HeadlessException e) {
    }
    if (bimage == null) {
      int type = BufferedImage.TYPE_INT_RGB;
      bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
    }
    Graphics g = bimage.createGraphics();
    g.drawImage(image, 0, 0, null);
    g.dispose();
    return bimage;
  }

}
