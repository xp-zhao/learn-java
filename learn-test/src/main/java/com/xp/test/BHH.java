package com.xp.test;

import com.xp.model.ContentItem;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by xp-zhao on 2018/2/26.
 */
public class BHH
{
	private static int MAX_NUM = 8;
	private int chessBoard[][] = new int[MAX_NUM][MAX_NUM];

	public static void main(String[] args)
	{
//		int j = 0;
//		for(int i = 0; i < 100; i++)
//		{
//			j = j++;
//		}
//		System.out.println(j);

		List<ContentItem> contentItems = new ArrayList<>();
		contentItems.add(new ContentItem("1001","","","","","1"));
		contentItems.add(new ContentItem("1002","","","","","2"));
		contentItems.add(new ContentItem("1003","","","","","3"));
		contentItems.add(new ContentItem("1004","","","","","4"));


		List<String> param = new ArrayList<>();
		param.add("1001");
		param.add("3");
//		removeContentItemsDisableSong(param,contentItems);
		removeContentItems(param,contentItems);
		System.out.println(contentItems);

//		contentItems.add(new ContentItem("1005","","","","","3"));
//		contentItems.add(new ContentItem("1006","","","","","4"));
//		contentItems.add(new ContentItem("1007","","","","","3"));
//		contentItems.add(new ContentItem("1008","","","","","4"));
//		System.out.println(getSongId(contentItems));
//		System.out.println(getRedoSongid(contentItems));

	}

	public static List<String> getSongId(List<ContentItem> contentItems)
	{
		List<String> resourceIds = new ArrayList<>();
		Set<String> set = new TreeSet<>();
		for(int i = 0; i < contentItems.size(); i++)
		{
			if(!set.add(contentItems.get(i).getSongId()))
			{
				resourceIds.add(contentItems.get(i).getContentId());
			}
		}
		return resourceIds;
	}

	public static List<String> getRedoSongid(List<ContentItem> contentItems) {
		List<String> resourceids = null ;
		if (contentItems != null) {
			resourceids = new ArrayList<>();
			//1.用冒泡算法解析传入的参数中songid是否有重复的；
			for (int i = 0; i < contentItems.size() - 1; i++) {
				for (int j = i + 1; j < contentItems.size(); j++) {
					if (contentItems.get(i).getSongId().equals(contentItems.get(j).getSongId())) {
						//添加一个songid重复的resourceid
						resourceids.add(contentItems.get(j).getContentId());
						//避免重复增加resourceid，这里需要移除不可用的contentItems
						contentItems.remove(contentItems.get(j));
						j--;
					}
				}
			}
		}
		return resourceids;
	}

	/**
	 * 根据资源id或者songid移除contentItems不可用歌曲
	 * @param params 传入resourceid或者songid
	 * @param contentItems
	 */
	public  static void removeContentItemsDisableSong(List<String> params,List<ContentItem> contentItems){
		for (int i = 0 ; i < contentItems.size() ;i++) {
			for (int j = 0 ; j < params.size() ;j++){
				if(contentItems.get(i).getContentId().equals(params.get(j)) || contentItems.get(i).getSongId().equals(params.get(j))){
					//移除列表中歌曲资源不可用或者songid不唯一的数据
					contentItems.remove(contentItems.get(i));
					i--;
					break;
				}
			}
		}
	}

	public static void removeContentItems(List<String> params,List<ContentItem> contentItems)
	{
		List<ContentItem> items = new ArrayList<>();
		for(int i = 0; i < contentItems.size(); i++)
		{
			if(StringUtils.isNotBlank(contentItems.get(i).getContentId()) && params.contains(contentItems.get(i).getContentId()))
			{
				items.add(contentItems.get(i));
			}
			if(StringUtils.isNotBlank(contentItems.get(i).getSongId()) && params.contains(contentItems.get(i).getSongId()))
			{
				items.add(contentItems.get(i));
			}
		}
		contentItems.removeAll(items);
	}
}
