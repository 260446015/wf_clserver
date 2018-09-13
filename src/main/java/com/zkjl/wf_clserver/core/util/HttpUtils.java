package com.zkjl.wf_clserver.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * HTTP请求工具类
 * 
 * @author yindw
 * @date 2017年11月2日
 */
public class HttpUtils {
	private static Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	
	/**
	 * 图片识别POST接口
	 * @param url
	 * @param params
	 * @return
	 */
	public static JSONObject sendPost(String url, List<NameValuePair> params){
		JSONObject result = null;
		HttpClient client = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params, "utf-8"));
			httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
			httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
			HttpResponse response = client.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				String body = EntityUtils.toString(entity, "utf-8");
				result=(JSONObject)JSONObject.parse(body);
			}
			EntityUtils.consume(entity);
		} catch (Exception e) {
			logger.error("请求识别图片接口出错",e);
		} 
		return result;
	}

	/**
	 * @param spec
	 * @param params
	 * @return
	 */
	public static JSONObject sendGet(String spec, List<NameValuePair> params){
        String url = spec + "?" + URLEncodedUtils.format(params,"UTF-8");  
		HttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		InputStream in = null;
		try {
			HttpResponse response = client.execute(get);
			if(response.getStatusLine().getStatusCode() == 200){  
				in = response.getEntity().getContent();
				BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
				String str = "";
				StringBuffer sb = new StringBuffer();
				while ((str = reader.readLine()) != null) {
					sb.append(str);
				}
				return (JSONObject)JSONObject.parse(sb.toString());
			}else{ 
            	get.abort();  
            	return null;
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
			return null;  
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					logger.error(e.getMessage());
				}
			}
		}
	}
	
	public static String sendHttpGet(String spec, Map<String, Object> params) throws IOException {
		spec = spec + "?" + assembling(params);
		HttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(spec);
		InputStream in = null;
		try {
			HttpResponse response = client.execute(get);
			in = response.getEntity().getContent();
			BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
			String str = "";
			StringBuffer sb = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				sb.append(str);
			}
			return sb.toString();
		} catch (IOException e) {
			logger.error(e.getMessage());
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return null;
	}

	public static String assembling(Map<String, Object> params) {
		StringBuilder sb = new StringBuilder();
		Set<Entry<String, Object>> entrySet = params.entrySet();
		for (Iterator<Entry<String, Object>> iterator = entrySet.iterator(); iterator.hasNext();) {
			Entry<String, Object> entry = iterator.next();
			String name = entry.getKey();
			Object value = entry.getValue();
			sb.append(name).append("=").append(value.toString()).append("&");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

}
