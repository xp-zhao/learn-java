package utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

/**
 * Created by xp-zhao on 2018/5/9.
 */
public class HTTPUtil
{
	// 测试
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<>();
		params.put("clientUrl", "httputil");
		get();
	}

	/**
	 * 向目标url发送post请求
	 *
	 * @author sheefee
	 * @date 2017年9月12日 下午5:10:36
	 * @param url
	 * @param params
	 * @return boolean
	 */
	public static boolean post(String url, Map<String, String> params) {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * 发送 get请求
	 */
	public static void get() {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// 创建httpget.
			HttpGet httpget = new HttpGet("http://www.baidu.com/");
			System.out.println("executing request " + httpget.getURI());
			// 执行get请求.
			CloseableHttpResponse response = httpclient.execute(httpget);
			try {
				// 获取响应实体
				HttpEntity entity = response.getEntity();
				System.out.println("--------------------------------------");
				// 打印响应状态
				System.out.println(response.getStatusLine());
				if (entity != null) {
					// 打印响应内容长度
					System.out.println("Response content length: " + entity.getContentLength());
					// 打印响应内容
					System.out.println("Response content: " + EntityUtils.toString(entity));
				}
				System.out.println("------------------------------------");
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
	}
}
