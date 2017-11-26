package cn.ssm.utils;


import cn.ssm.utils.ytxutils.CCPRestSDK;

import java.util.HashMap;


public class PhoneSendUtil {

	private String AccountSid ;
	private String AccountToken ;
	private String AppId ;

	public  void  sendSMS(String number,String code) {
		HashMap<String, Object> result = null;

		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount(AccountSid, AccountToken);// 初始化主帐号和主帐号TOKEN
		restAPI.setAppId(AppId);// 初始化应用ID
		result = restAPI.sendTemplateSMS(number,"1" ,new String[]{code,"2"});

		System.out.println("SDKTestSendTemplateSMS result=" + result);
		
		/*if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				System.out.println(key +" = "+object);
			}
		}else{
			//异常返回输出错误码和错误信息
			System.out.println("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
		}*/
	}


	public void setAccountSid(String accountSid) {
		AccountSid = accountSid;
	}

	public void setAccountToken(String accountToken) {
		AccountToken = accountToken;
	}

	public void setAppId(String appId) {
		AppId = appId;
	}
}
