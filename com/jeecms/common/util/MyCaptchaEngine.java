package com.jeecms.common.util;

import java.awt.Color;
import java.awt.Font;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.GradientBackgroundGenerator;
import com.octo.captcha.component.image.color.ColorGenerator;
import com.octo.captcha.component.image.color.RandomRangeColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.image.wordtoimage.WordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.component.word.wordgenerator.WordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

public class MyCaptchaEngine extends ListImageCaptchaEngine {  
	  
    public static final String DEFAULT_WORD_CHARS = "0123456789ABCD";  
    public static final Color DEFAULT_BG_COLOR = Color.WHITE;  
  
    private int minWordLength;  
    private int maxWordLength;  
  
    private int imageWidth;  
    private int imageHeight;  
  
    private int minFontSize;  
    private int maxFontSize;  
  
    private String wordChars;  
  
    private Color bgcolor;  
  
    private int[] fontColorRange = { 25, 225 };  
  
    private void initSettings() {  
  
        minWordLength = 4;  
        maxWordLength = 4;  
  
        imageWidth = 100;  
        imageHeight = 40;  
  
        minFontSize = 15;  
        maxFontSize = 25;  
  
        wordChars = DEFAULT_WORD_CHARS;  
  
        bgcolor = DEFAULT_BG_COLOR;  
  
        fontColorRange = new int[] { 25, 25 };  
    }  
  
    protected void buildInitialFactories() {  
        initSettings();  
        WordGenerator wordGenerator = new RandomWordGenerator(wordChars);  
        BackgroundGenerator backgroundGenerator = new GradientBackgroundGenerator(  
                imageWidth, imageHeight, bgcolor, bgcolor);  
        Font[] fontList= new Font[]{new Font("Arial", 0, 10)};  
        FontGenerator fontGenerator = new RandomFontGenerator(minFontSize, maxFontSize,fontList);  
        ColorGenerator colorGenerator = new RandomRangeColorGenerator(  
                fontColorRange, fontColorRange, fontColorRange);  
        TextDecorator[] textDecorators = new TextDecorator[] {};  
        TextPaster textPaster = new DecoratedRandomTextPaster(minWordLength,  
                maxWordLength, colorGenerator, textDecorators);  
        WordToImage wordToImage = new ComposedWordToImage(fontGenerator,  
                backgroundGenerator, textPaster);     
        addFactory(new GimpyFactory(wordGenerator, wordToImage));  
    }  
  
}  