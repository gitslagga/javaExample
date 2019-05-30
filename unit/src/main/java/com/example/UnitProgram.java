package com.example;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Random;

import javax.enterprise.inject.New;

public class UnitProgram {
	public static Logger log = LoggerFactory.getLogger(UnitProgram.class);
	public static Base64.Encoder encoder = Base64.getEncoder();
	public static Base64.Decoder decoder = Base64.getDecoder();

	public static void main(String[] args) throws Exception {
//		requestByPostMethod();
		
//		int integer = 1234591111;
//		byte status = (byte) integer;
//		System.out.println(status);
		
//		Random random = new Random();
//		for (int i = 0; i < 100; i++) {
//			System.out.println("first : "  + random.nextInt(1_00));
//			System.out.println("second : " + random.nextInt(100));
//		}
		
//		String phoneString = "17671456824";
//		System.out.println(phoneString.substring(0, 3) + "****" + phoneString.substring(7));
	}

	public static void requestByPostMethod() {
		CloseableHttpClient httpClient = getHttpClient();
		String urlString = "http://smssh1.253.com/msg/send/json";
		String accountString = "N066224_N7760235";
		String passwordString = "bZ6oDzw4m9bbcf";
		String msgString = "Hello World!";
		String phoneString = "182729032930";

		try {
			HttpPost post = new HttpPost(urlString); // 这里用上本机的某个工程做测试
			// 创建参数列表
			List<NameValuePair> list = new ArrayList<NameValuePair>();
			list.add(new BasicNameValuePair("account", accountString));
			list.add(new BasicNameValuePair("password", passwordString));
			list.add(new BasicNameValuePair("msg", msgString));
			list.add(new BasicNameValuePair("phone", phoneString));
			list.add(new BasicNameValuePair("report", String.valueOf(true)));
			// url格式编码
			UrlEncodedFormEntity uefEntity = new UrlEncodedFormEntity(list, "UTF-8");
			post.setEntity(uefEntity);
			System.out.println("POST 请求...." + post.getURI());
			// 执行请求
			CloseableHttpResponse httpResponse = httpClient.execute(post);
			try {
				HttpEntity entity = httpResponse.getEntity();
				if (null != entity) {
					System.out.println("-------------------------------------------------------");
					System.out.println(EntityUtils.toString(uefEntity));
					System.out.println("-------------------------------------------------------");
				}
			} finally {
				httpResponse.close();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				closeHttpClient(httpClient);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	private static CloseableHttpClient getHttpClient() {
		return HttpClients.createDefault();
	}

	private static void closeHttpClient(CloseableHttpClient httpClient) throws IOException {
		if (null != httpClient) {
			httpClient.close();
		}
	}
}
