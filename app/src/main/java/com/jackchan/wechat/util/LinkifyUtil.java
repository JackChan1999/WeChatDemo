package com.jackchan.wechat.util;

import android.text.util.Linkify;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * ============================================================
 * Copyright：JackChan和他的朋友们有限公司版权所有 (c) 2017
 * Author：   JackChan
 * Email：    815712739@qq.com
 * GitHub：   https://github.com/JackChan1999
 * GitBook：  https://www.gitbook.com/@alleniverson
 * CSDN博客： http://blog.csdn.net/axi295309066
 * 个人博客： https://jackchan1999.github.io/
 * 微博：     AndroidDeveloper
 * <p>
 * Project_Name：WeChatDemo
 * Package_Name：com.jackchan.wechat
 * Version：1.0
 * time：2017/5/16 12:39
 * des ：微信朋友圈，QQ空间，微博等列表展示的功能实现
 *       自定义超链接
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/16 12:39
 * updateDes：${TODO}
 * ============================================================
 */

public class LinkifyUtil {

    /**
     * 添加自定义超链接
     */
    public static void addCustomLink(TextView textView) {
        // @用户:
        Pattern pattern = Pattern.compile("\\@([A-Za-z0-9\u4E00-\u9FA5]+)\\.?");
        // http://www.qq.com/path?uid=1&username=xx
        String scheme = "weibo://user?uid=";

        // 匹配过滤器
        Linkify.MatchFilter matchFilter = new Linkify.MatchFilter() {
            @Override
            public boolean acceptMatch(CharSequence s, int start, int end) {
                String text = s.subSequence(start, end).toString();
                // System.out.println("----text: " + text);
                if (text.endsWith(".")) { // 邮箱，不需要匹配
                    return false;
                } else {
                    return true;    // 返回true会显示为超链接
                }
            }
        };
        Linkify.TransformFilter transformFilter = null;
        Linkify.addLinks(textView, pattern, scheme, matchFilter, transformFilter);
    }

    public static void addCustomLink2(TextView textView) {
        // @用户:
        Pattern pattern = Pattern.compile("\\#([A-Za-z0-9\u4E00-\u9FA5]+)\\#");
        // http://www.qq.com/path?uid=1&username=xx
        String scheme = "weibo://topic?uid=";
        // 匹配过滤器
        Linkify.MatchFilter matchFilter = new Linkify.MatchFilter() {
            @Override
            public boolean acceptMatch(CharSequence s, int start, int end) {
                String text = s.subSequence(start, end).toString();
                System.out.println("----text: " + text);
                return true;
            }
        };
        Linkify.TransformFilter transformFilter = new Linkify.TransformFilter() {
            @Override
            public String transformUrl(Matcher match, String url) {
                return match.group(1);
            }
        };
        Linkify.addLinks(textView, pattern, scheme, matchFilter, transformFilter);
    }
}
