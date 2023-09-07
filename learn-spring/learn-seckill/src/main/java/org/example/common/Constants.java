package org.example.common;
/**
 * 常量
 *
 * @author zhaoxiaoping
 * @date 2023-9-7
 */
public class Constants {
  public enum ResponseCode {
    SUCCESS("0000", "秒杀成功"),
    UN_ERROR("0001", "未知失败"),
    END("0002", "活动结束"),
    REPEAT("0003", "重复操作"),
    DATA_ERR("0004", "数据错误");

    private String code;
    private String info;

    ResponseCode(String code, String info) {
      this.code = code;
      this.info = info;
    }

    public String getCode() {
      return code;
    }

    public String getInfo() {
      return info;
    }
  }
}
