package com.xp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by xp-zhao on 2018/1/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RpcService implements Serializable
{
	private String contact;
	private String serviceName;
	private String serviceImplName;
}
