package com.xp.TSG;

import lombok.Data;

import java.util.List;

/**
 * Created by xp-zhao on 2018/5/24.
 */
@Data
public class TSGPlayList
{
	//	歌单 id
	private String           play_list_id;
	//	歌单内容类型
	private String           play_list_type;
	//	歌单创建者
	private String           identity_id;
	//	歌单名称
	private String           play_list_name;
	//	歌单封面图片
	private String           image_url;
	//	创建时间
	private String           create_time;
	//	更新时间
	private String           update_time;
	//	内容数量
	private int              content_count;
	//	标签列表
	private List<TSGTag>     tags;
	//	内容列表
	private List<TSGContent> contents;
	//	收藏次数
	private int              collec_count;
	//	播放次数
	private int              play_count;
}
