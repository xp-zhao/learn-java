package com.xp.view;

/**
 * 视图模型
 * Created by xp-zhao on 2018/4/13.
 */
public class View
{
	private String url; //跳转路径

	private String dispathAction = DispatchActionConstant.FORWARD;

	public View(String url)
	{
		this.url = url;
	}

	public View(String url,String name,String value)
	{
		this.url = url;
		ViewData view = new ViewData();
		view.put(name,value);
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public String getDispathAction()
	{
		return dispathAction;
	}

	public void setDispathAction(String dispathAction)
	{
		this.dispathAction = dispathAction;
	}
}
