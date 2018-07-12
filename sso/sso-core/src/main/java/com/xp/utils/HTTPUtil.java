package com.xp.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by xp-zhao on 2018/5/14.
 */
public class HTTPUtil
{
	/**
	 * 发送 post 请求
	 * @param request
	 * @param url
	 * @param params
	 * @return
	 */
	public static String post(HttpServletRequest request,String url, Map<String, String> params)
	{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		// 参数处理
		if (params != null && !params.isEmpty()) {
			List<NameValuePair> list = new ArrayList<>();

			Iterator<Map.Entry<String, String>> it = params.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, String> entry = it.next();
				list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
			httpPost.setEntity(new UrlEncodedFormEntity(list, Consts.UTF_8));
		}
		// 执行请求
		try {
			CloseableHttpResponse response = httpclient.execute(httpPost);
			response.getStatusLine().getStatusCode();
			return EntityUtils.toString(response.getEntity());
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 发送 get请求
	 */
	public static String get(HttpServletRequest request,String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget
			HttpGet httpget = new HttpGet(url);
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				return EntityUtils.toString(entity);
			} finally {
				response.close();
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 关闭连接,释放资源
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "";
	}

	/**
	 * post 请求，发送 body 参数
	 * @param url
	 * @param body
	 * @return
	 */
	public static String postBody(String url,String body)
	{
		// 实例化httpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 实例化post方法
		HttpPost httpPost = new HttpPost(url);
		// 结果
		CloseableHttpResponse response = null;
		String content = null;
		httpPost.setHeader("Content-Type" , "application/json");
		try {
			// 将参数给post方法
			if (body != null) {
				StringEntity stringEntity = new StringEntity(body , "UTF-8");
				httpPost.setEntity(stringEntity);
			}
			// 执行post方法
			response = httpclient.execute(httpPost);
			if (response.getStatusLine().getStatusCode() == 200) {
				try {
					content = EntityUtils.toString(response.getEntity(), "UTF-8");
				} finally {
					response.close();
				}
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return content;
	}
}
