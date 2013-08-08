package com.jeecms.common.util;

import java.awt.Font;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FunkyBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.RandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

public class MyImageCaptchaEngine extends ListImageCaptchaEngine {

	// 随机生成的字符组成
	    private static final String RANDOM_WORD_GENERATOR = "0123456789";

	    // 验证码图片上显示的字符个数
	    private static final int TEXT_SIZE = 4;
	   
	    //验证码图片上显示的字符的大小设置
	    private static final int TEXT_WIDTH = 12;
	    private static final int TEXT_HEIGHT = 13;

	    // 验证码图片的大小设置
	    private static final int IMAGE_CAPTCHA_WIDTH = 70;
	    private static final int IMAGE_CAPTCHA_HEIGHT = 28;

//	    protected void buildInitialFactories() {
//	        // 随机生成的字符
//	        WordGenerator wgen = new RandomWordGenerator(RANDOM_WORD_GENERATOR);
//	        RandomRangeColorGenerator cgen = new RandomRangeColorGenerator(
//	                new int[]{ 0, 100 }, new int[]{ 0, 100 }, new int[]{ 0, 100 });
//	        // 文字显示的个数
//	        TextPaster textPaster = new RandomTextPaster(new Integer(TEXT_SIZE),
//	                new Integer(TEXT_SIZE), cgen, Boolean.TRUE);
//	        // 图片的大小
//	        BackgroundGenerator backgroundGenerator = new FunkyBackgroundGenerator(
//	                new Integer(IMAGE_CAPTCHA_WIDTH), new Integer(
//	                        IMAGE_CAPTCHA_HEIGHT));
//	        // 字体格式
//	        Font[] fontsList = new Font[]{ new Font("Arial", 0, 12),
//	                new Font("Tahoma", 0, 12), new Font("Verdana", 0, 12), };
//	        // 文字的大小
//	        FontGenerator fontGenerator = new RandomFontGenerator(new Integer(
//	                TEXT_WIDTH), new Integer(TEXT_HEIGHT), fontsList);
//	
//	        WordToImage wordToImage = new ComposedWordToImage(fontGenerator,
//	                backgroundGenerator, textPaster);
//	        this.addFactory(new GimpyFactory(wgen, wordToImage));
//	    }
	    protected void buildInitialFactories() {
	        WordGenerator wgen = new RandomWordGenerator("123456789abcdefghjkmnprstwxyz");
	        RandomRangeColorGenerator cgen = new RandomRangeColorGenerator(
	             new int[] {0, 100},
	             new int[] {0, 100},
	             new int[] {0, 100});
	        //文字显示4个数
	        TextPaster textPaster = new RandomTextPaster(new Integer(4), new Integer(4), cgen, true);
	        //图片的大小
	        BackgroundGenerator backgroundGenerator = new FunkyBackgroundGenerator(new Integer(200), new Integer(45));

	        Font[] fontsList = new Font[] {
	            new Font("Arial", 0, 10),
	            new Font("Tahoma", 0, 10),
	            new Font("Verdana", 0, 10),
	         };
	    
	        FontGenerator fontGenerator = new RandomFontGenerator(new Integer(20), new Integer(30), fontsList);

	         WordToImage wordToImage = new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster);
	         this.addFactory(new GimpyFactory(wgen, wordToImage));
}
}