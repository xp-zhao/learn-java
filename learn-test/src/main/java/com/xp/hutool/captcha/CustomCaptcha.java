package com.xp.hutool.captcha;

import cn.hutool.captcha.AbstractCaptcha;
import java.awt.Image;

/**
 * CustomCaptcha.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class CustomCaptcha extends AbstractCaptcha {

  public CustomCaptcha(int width, int height, int codeCount, int interfereCount) {
    super(width, height, codeCount, interfereCount);
  }

  @Override
  protected Image createImage(String s) {
    return null;
  }
}