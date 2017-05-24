package com.jackchan.wechatemoji.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiParser {
	public static  SpannableStringBuilder parseEmoji(Context context,String content){
		int size = UIUtils.dip2Px(25,context);
		//里[smiley_00]ff[smiley_78]
		SpannableStringBuilder builder = new SpannableStringBuilder(content);
		//正则表达式
		Pattern pattern = Pattern.compile("\\[smiley_(.*?)\\]");
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()){
			String emo = matcher.group();//[smiley_00]
				emo = emo.substring(1, emo.length()-1);
			//获取表情的id
			int id = context.getResources().getIdentifier(emo, "drawable", context.getPackageName());
			if(id != 0 ){
				Drawable drawable = context.getResources().getDrawable(id);
				// 必须设置图片大小
				drawable.setBounds(0, 0, size, size);
				// 包装一下图片
				ImageSpan span = new ImageSpan(drawable);
				// 把文字替换成图片
				builder.setSpan(span, matcher.start(), matcher.end(),
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		}
		return builder;
	}
}
