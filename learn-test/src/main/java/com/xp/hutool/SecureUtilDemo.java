package com.xp.hutool;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;

/**
 * SecureUtilDemo.java 加密工具使用
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/15
 **/
public class SecureUtilDemo {

  public static void main(String[] args) {
    md5();
  }

  public static void md5(){
    String md5Hex1 = DigestUtil.md5Hex("test中文11");
    System.out.println(md5Hex1);
  }

  public static void aes(){
    String content = "test中文";
    System.out.println(content);
    //随机生成密钥
    byte[] key = SecureUtil.generateKey(SymmetricAlgorithm.AES.getValue()).getEncoded();
    System.out.println(key.toString());

    //构建
    SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, key);

    //加密
    byte[] encrypt = aes.encrypt(content);
    //解密
    byte[] decrypt = aes.decrypt(encrypt);

    //加密为16进制表示
    String encryptHex = aes.encryptHex(content);
    System.out.println(encryptHex);
    //解密为字符串
    String decryptStr = aes.decryptStr(encryptHex, CharsetUtil.CHARSET_UTF_8);
    System.out.println(decryptStr);
  }
}