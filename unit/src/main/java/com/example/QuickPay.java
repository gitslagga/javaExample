package com.example;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.interfaces.RSAKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSONObject;

/**
 * @author zhy
 * @date 2018年6月28日
 */
public class QuickPay {
	static String	srvPubKey	= "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDQKgFfaTbpEvWhoShtusRVfsNEtwJC/Lvboiscbz/BIJosLaWLJZcwInn6XhKJhO8Wr6Hyr5o2NhuLknCNkyyUTraBMjJC89cJYI7PpjpVhWqb4tVU6kss0auL/5lRE4SEb1Qnt75m+uEM3awt3NXyRfqc9g7QZOMRkgCM4NV0+QIDAQAB";
	static String	selfPriKey	= "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANAqAV9pNukS9aGhKG26xFV+w0S3AkL8u9uiKxxvP8EgmiwtpYsllzAiefpeEomE7xavofKvmjY2G4uScI2TLJROtoEyMkLz1wlgjs+mOlWFapvi1VTqSyzRq4v/mVEThIRvVCe3vmb64QzdrC3c1fJF+pz2DtBk4xGSAIzg1XT5AgMBAAECgYEAxx43G+4H4WEKZuZCRtwta96KqJMqbatVgx0XgeaEpJcsAnBTdsupWBjSdwQ/VR48mYW9Muh4abzOEm8sjLAoJaeWEb/6bQ/JOSCohZ4NJmFndsW+Rjqs2VYvLxwM+B4Xl5lnOOOb5o3VHe3p6flEA/BycLU2HzhrSCvovZFaIiUCQQDnn3JCEu2Fwj0l+49nPV+3s1Ov7rbZvHBikyf3cjqJc74bg8GVP6d4Cv40sReyLfxdUv/SvJOsb8dxI5PKGfmjAkEA5hKEFeIZZTfzP6Li2cFftOuv0hTVDR5qSotimgMgcSHGthZ9U5TaK5UGrjVhlCQUByZfsVS1yla54XsvFzL4swJBAMCqPq57dBvZMGgR0n077gyuHCSx2mNPfeRhJ9OKrup63l2gwTvWkQUnj8Bgtqc93Tf7vFSdC/FZoXqY72wjIyUCQEUwmlJubY64Fco0dR5hfiPNoVF/fFb2p6aFZoDEofQD4VuPRd9l63qh1aF8Yj0H4JIJ40tUG1ufW0VJI29Jn+sCQQDe8gR6DxEXCQYtPtnE+ituv87uNZRnNaCPoJmofb0WE23BA3ufei4RG0S6TH2tV0gOnxgpF0PUyqyKlsdcDnFc"; 

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdt = new SimpleDateFormat("yyyyMMddHHmmss");
		String merOrderId = sdt.format(date);
		Random random = new Random();
		merOrderId = merOrderId + (random.nextInt(89999) + 10000);
	    
		JSONObject obj = new JSONObject();
	    obj.put("merNo", "90020025");
	    obj.put("merOrderId", merOrderId);
	    obj.put("idCard", "130204198107171515");
	    obj.put("realNam", "马保禄");
	    obj.put("trxAmt", "300000");
	    obj.put("trxRate", "0.007");
	    obj.put("trxFee", "2100");
	    obj.put("notifyUrl", "http://admin.yousai2019.com/api/test/qu");
	    obj.put("returnUrl", "http://admin.yousai2019.com/api/test/qu");
	    obj.put("trxCardNo", "6222370063271544");
	    obj.put("trxCardPhone", "15533574110");
	    obj.put("settCardNo", "6228480659145460773");
	    obj.put("settBankCode", "103100000026");
	    obj.put("settCardPhone", "15533574110");
	    obj.put("settBankName", "农业银行");
	    obj.put("valiDate", "0128");
	    obj.put("cvn2", "565");

	    System.out.println("request data : " + obj);
	    
		f1(obj);
	}

	public static String f1(JSONObject obj) {
		String aesKey = AesUtil.createNewKey(AesUtil.AesLevel.LEVEL_128);
		
		byte[] bytes = Base64.getDecoder().decode(aesKey);
		String encKey = RsaUtil.encrpyt(srvPubKey, bytes);
		String encData = AesUtil.createInstance(bytes).encrypt(obj.toString().getBytes());
		String sign = RsaUtil.sign(selfPriKey, obj.toString().getBytes());
		String msgString = encKey + "|" + encData + "|" + sign;
		
		Map<String, String> requestMap = new HashMap<String, String>();
		requestMap.put("msg", msgString);
		requestMap.put("_input_charset", "UTF-8");
		String contentString = HttpClient.createLinkString(requestMap, true);

		try {
			String tempStr = HttpClient.post("http://211.154.166.246/factoring/v1/F014", contentString);
			System.out.println("result : " + tempStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}
}

class AesUtil {
	private static final String	AES_PADDING		= "AES";
	private Cipher				encrpytCipher	= null;
	private Cipher				decryptCipher	= null;

	public enum AesLevel {
		LEVEL_128(128), LEVEL_192(192), LEVEL_256(256);

		private final int level;

		AesLevel(int value) {
			this.level = value;
		}

		public int getLevel() {
			return level;
		}
	}

	private AesUtil() {
	}

	/**
	 * 随机生成一个AES密钥
	 */
	public static String createNewKey(AesLevel level) {
		try {
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(level.getLevel(), new SecureRandom());
			SecretKey secretKey = kgen.generateKey();
			byte[] enCodeFormat = secretKey.getEncoded();
			return Base64.getEncoder().encodeToString(enCodeFormat);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 创建AES算法实例，实例创建后密钥不可修改
	 *
	 * @param keyBytes 密钥串
	 * @return AES算法实例
	 */
	public static AesUtil createInstance(byte[] keyBytes) {

		try {
			SecretKeySpec skspec = new SecretKeySpec(keyBytes, "AES");
			AesUtil inst = new AesUtil();
			inst.encrpytCipher = Cipher.getInstance(AES_PADDING);
			inst.encrpytCipher.init(Cipher.ENCRYPT_MODE, skspec);

			inst.decryptCipher = Cipher.getInstance(AES_PADDING);
			inst.decryptCipher.init(Cipher.DECRYPT_MODE, skspec);
			return inst;
		} catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 加密
	 */
	public String encrypt(byte[] src) {
		try {
			return Base64.getEncoder().encodeToString(encrpytCipher.doFinal(src));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 解密
	 */
	public byte[] decrypt(String src) {
		try {
			return decryptCipher.doFinal(Base64.getDecoder().decode(src));
		} catch (IllegalBlockSizeException | BadPaddingException e) {
			e.printStackTrace();
			return null;
		}
	}
}

class RsaUtil {
	private static final String	TRANS_FORMATION		= "RSA/ECB/PKCS1Padding";
	private static final String	SIGNATURE_ALGORITHM	= "MD5withRSA";
	public static final String	KEY_ALGORITHM		= "RSA";
	public static final int		PUBLIC_KEY			= 1;
	public static final int		PRIVATE_KEY			= 2;

	/**
	 * 使用公钥加密数据
	 *
	 * @param publicKey 公钥串
	 * @param data 原始数据
	 * @return 密文
	 */
	private static byte[] encrypt(String publicKey, byte[] data) {
		RSAPublicKey key = (RSAPublicKey) createKey(publicKey, PUBLIC_KEY);
		try {
			Cipher cipher = Cipher.getInstance(TRANS_FORMATION);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] result = cipher.doFinal(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 使用公钥加密数据
	 *
	 * @param publicKey 公钥串
	 * @param data 原始数据
	 * @return base64 密文
	 */
	public static String encrpyt(String publicKey, byte[] data) {
		byte[] temp = encrypt(publicKey, data);
		return Base64.getEncoder().encodeToString(temp);
	}

	/**
	 * 私钥解密
	 *
	 * @param privateKey 私钥串
	 * @param data 密文
	 * @return 原文
	 */
	public static byte[] decrpyt(final String privateKey, final byte[] data) {
		RSAPrivateKey key = (RSAPrivateKey) createKey(privateKey, PRIVATE_KEY);
		try {
			Cipher cipher = Cipher.getInstance(TRANS_FORMATION);
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] result = cipher.doFinal(data);
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 私钥做数字签名
	 *
	 * @param privateKey 私钥串
	 * @param data base64密文
	 * @return
	 */
	public static String sign(String privateKey, byte[] data) {
		RSAPrivateKey key = (RSAPrivateKey) createKey(privateKey, PRIVATE_KEY);
		try {
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initSign(key);
			signature.update(data);
			return Base64.getEncoder().encodeToString(signature.sign());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 公钥做验签
	 *
	 * @param publicKey 公钥串
	 * @param data
	 * @param sign
	 * @return
	 */
	public static boolean verify(String publicKey, byte[] data, String sign) {
		RSAPublicKey key = (RSAPublicKey) createKey(publicKey, PUBLIC_KEY);
		try {
			Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
			signature.initVerify(key);
			signature.update(data);
			// 验证签名是否正常
			return signature.verify(Base64.getDecoder().decode(sign));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 通过密钥串创建key
	 *
	 * @param key 密钥串
	 * @return 密钥实例
	 */
	public static RSAKey createKey(String key, int keyType) {
		try {
			EncodedKeySpec keySpec = null;
			KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
			if (PUBLIC_KEY == keyType) {
				keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(key));
				return (RSAKey) keyFactory.generatePublic(keySpec);
			} else if (PRIVATE_KEY == keyType) {
				keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(key));
				return (RSAKey) keyFactory.generatePrivate(keySpec);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

class HttpClient {

	private HttpClient() {
	}

	public static RequestConfig			requestConfig	= RequestConfig.custom().setConnectionRequestTimeout(50000).setConnectTimeout(50000).setSocketTimeout(50000).build();
	public static CloseableHttpClient	httpClient		= HttpClientBuilder.create().setMaxConnTotal(200).setMaxConnPerRoute(200).setDefaultRequestConfig(requestConfig).build();

	public static String post(String reqUrl, String reqData) throws Exception {
		HttpPost httpPost = new HttpPost(reqUrl);
		try {
			StringEntity strEntity = new StringEntity(reqData, ContentType.create("application/x-www-form-urlencoded", Consts.UTF_8));
			httpPost.setEntity(strEntity);
			HttpResponse response = httpClient.execute(httpPost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK) {
				HttpEntity resEntity = response.getEntity();
				String ret = EntityUtils.toString(resEntity, Consts.UTF_8);
				EntityUtils.consume(resEntity);
				return ret;
			}
			return "";
		} catch (IOException e) {
			return null;
		} finally {
			httpPost.releaseConnection();
		}
	}
	
    public static String createLinkString(Map<String, String> params, boolean encode) {
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        String prestr = "";
        String charset = params.get("_input_charset");
        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);
            if (encode) {
                try {
                    value = URLEncoder.encode(URLEncoder.encode(value, charset),charset);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
            if (i == keys.size() - 1) {
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
            }
        
        return prestr;
    }
}
