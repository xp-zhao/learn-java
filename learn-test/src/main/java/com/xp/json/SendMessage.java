package com.xp.json;

import lombok.Data;

import java.io.Serializable;

/**
 * @author zhujinliang
 * @version 1.0
 */
@Data
public class SendMessage implements Serializable{
    private String dataType;//数据类型用于标识请求
    private String requestParam;//请求参数json字符串
    private String respParam;//返回参数json字符串
}
