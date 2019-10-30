package com.xp.hutool.captcha;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;

/**
 * LineCaptchaDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
public class LineCaptchaDemo {

  public static void main(String[] args) {
    LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100);
    System.out.println(lineCaptcha.getCode());
    lineCaptcha.write("line.png");
  }
}