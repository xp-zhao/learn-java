
package com.xp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author luchenxi
 *
 *         2017年8月2日
 */
@ Data
@ NoArgsConstructor
@ AllArgsConstructor
public class ContentItem
{
	private String contentId;  // 内容ID
	private String contentType; // 内容类型
	private String contentName; // 内容名名称
	private String singerId;   // 内容归属人id
	private String singerName; // 内容归属人名称
	private String songId;      //歌曲id
}
