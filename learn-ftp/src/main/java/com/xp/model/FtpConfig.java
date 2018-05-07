package com.xp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by xp-zhao on 2018/5/4.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FtpConfig
{
	String address;
	String port;
	String username;
	String password;
	String filepath;
}
