package com.jeecms.common.util;

import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class MyImageSingleton {

	private static ImageCaptchaService instance =new DefaultManageableImageCaptchaService();

	static {
	     instance = new DefaultManageableImageCaptchaService(
	        new FastHashMapCaptchaStore(),
//	        new MyImageCaptchaEngine(),
	        new CaptchaImageEngine(),
	        180,
	        100000,
	        75000);
	     }
	public static ImageCaptchaService getMyInstance(){
		   return instance;
		}
}