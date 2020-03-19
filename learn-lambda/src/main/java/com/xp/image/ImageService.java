package com.xp.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import net.coobird.thumbnailator.Thumbnails;
import sun.font.FontDesignMetrics;

/**
 *
 */
public class ImageService {

  // 宽：146px 高：205px
  public static int width = 146;
  public static int height = 205;


  /**
   * 不缩放图片
   *
   * @param url
   * @param imageText
   * @return
   */
  public BufferedImage addText(String url, List<ImageText> texts) {
    Objects.requireNonNull(texts);
    return addText(null, null, url, texts);
  }

  /**
   * 不缩放图片
   *
   * @param url
   * @param imageText
   * @return
   */
  public BufferedImage addText(String url, ImageText imageText) {
    Objects.requireNonNull(imageText);
    return addText(null, null, url, Arrays.asList(imageText));
  }

  /**
   * 按指定宽高，等比例缩放
   *
   * @param width
   * @param height
   * @param url
   * @param imageText
   * @return
   */
  public BufferedImage addText(Integer width, Integer height, String url, ImageText imageText) {
    Objects.requireNonNull(imageText);
    return addText(width, height, url, Arrays.asList(imageText));
  }

  /**
   * 按指定宽高，等比例缩放
   *
   * @param width
   * @param height
   * @param url
   * @param texts
   * @return
   */
  public BufferedImage addText(Integer width, Integer height, String url, List<ImageText> texts) {
    BufferedImage bufferedImage = null;

    try {
      BufferedImage tempBufferedImage =
          ImageUtils.toBufferedImage(ImageUtils.toByteArray(new URL(url).openStream()));
      Thumbnails.Builder<BufferedImage> builder = Thumbnails.of(tempBufferedImage);
      // 若图片横比200小，高比300小，不变 若图片横比200小，高比300大，高缩小到300，图片比例不变
      // 若图片横比200大，高比300小，横缩小到200，图片比例不变 若图片横比200大，高比300大，图片按比例缩小，横为200或高为300
      if (width != null && height != null) {
        builder.size(width, height);
        // true 默认是按照比例缩放的
        // keepAspectRatio 必须在 size()之后
        builder.keepAspectRatio(true);
      } else {
        // 不缩放
        builder.scale(1);
      }
      //
      builder.outputQuality(0.8f);

      texts.stream().forEach(t -> {
        // .watermark(Positions.BOTTOM_RIGHT, fromText(40, "你好Java!"), 0.5f)
        // watermark(位置，水印图，透明度)
        if (t.getContent() != null && t.getContent().length() != 0) {
          builder.watermark(t.getPosition(), fromText(t), t.getOpacity());
        } else {
        }

      });

      bufferedImage = builder.asBufferedImage();
    } catch (MalformedURLException e) {
      throw new RuntimeException("图片无法访问");
    } catch (Exception e2) {
      throw new RuntimeException(e2);
    }

    return bufferedImage;
  }

  public BufferedImage fromText(ImageText imageText) {
    Objects.requireNonNull(imageText);

    String parseContent = imageText.getContent() == null ? "" : imageText.getContent();
    // Font font = new Font("宋体", Font.BOLD, fontSize);
    Font font = imageText.getFont();
    FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
    int width = 0;
    if (parseContent.length() == 0) {
      width = 0;
    } else {
      width = getWordWidth(font, parseContent);// 计算图片的宽
    }
    int height = metrics.getHeight();// 计算高
    BufferedImage bufferedImage =
        new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    // 设置背影为白色
    // graphics.setColor(Color.WHITE);
    // graphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    graphics.setFont(font);
    graphics.setColor(imageText.getColor());
    graphics.drawString(parseContent, 0, metrics.getAscent());// 图片上写文字
    graphics.dispose();

    return bufferedImage;
  }

  public BufferedImage fromText(int fontSize, String content) {
    String parseContent = content == null ? "" : content;
    // Font font = new Font("宋体", Font.BOLD, fontSize);
    Font font = SimsunFont.getSimsunFont(Font.BOLD, fontSize);
    FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
    int width = 0;
    if (parseContent.length() == 0) {
      width = 0;
    } else {
      width = getWordWidth(font, parseContent);// 计算图片的宽
    }
    int height = metrics.getHeight();// 计算高
    BufferedImage bufferedImage =
        new BufferedImage(width + 1, height + 1, BufferedImage.TYPE_INT_ARGB);
    Graphics2D graphics = bufferedImage.createGraphics();
    graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
    graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER));
    // 设置背影为白色
    // graphics.setColor(Color.WHITE);
    // graphics.fillRect(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight());
    graphics.setFont(font);
    graphics.setColor(Color.BLACK);
    graphics.drawString(parseContent, 0, metrics.getAscent());// 图片上写文字
    graphics.dispose();

    return bufferedImage;
  }

  public int getWordWidth(Font font, String content) {
    FontDesignMetrics metrics = FontDesignMetrics.getMetrics(font);
    int width = 0;
    for (int i = 0; i < content.length(); i++) {
      width += metrics.charWidth(content.charAt(i));
    }
    return width;
  }

}
