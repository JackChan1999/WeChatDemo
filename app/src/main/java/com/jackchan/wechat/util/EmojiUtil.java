package com.jackchan.wechat.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.jackchan.wechat.R;
import com.jackchan.wechat.base.Global;

import java.util.HashMap;
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
 * des ：表情工具类封装
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/16 12:39
 * updateDes：${TODO}
 * ============================================================
 */

public class EmojiUtil {

    /** 显示文本和表情 */
    public static void setText(TextView textView, String text) {
        Context context = textView.getContext();
        Resources resources = context.getResources();
        SpannableString ss = new SpannableString(text);

        // 正则表达式： [高兴]
        Pattern p = Pattern.compile("\\[([A-Za-z\u4E00-\u9FA5]+)\\]");
        Matcher matcher = p.matcher(ss);
        while (matcher.find()) {
            // 匹配到一个表情字符串
            String emoji = matcher.group();
            // 过滤非表情符，比如： [xxx]
            if (EMOJI_DATAS.containsKey(emoji)) {   // 是表情才处理
                // System.out.println("----------" + emoji);
                // 指定了一张图片
                Bitmap bitmap = BitmapFactory.decodeResource(resources, EMOJI_DATAS.get(emoji));
                bitmap = Global.createBitmap(bitmap, Global.dp2px(20));     // 图片的宽高为20dp
                ImageSpan span = new ImageSpan(context, bitmap, ImageSpan.ALIGN_BOTTOM);
                int start = matcher.start();
                int end = matcher.end();
                ss.setSpan(span, start, end, 0);
            }
        }
        textView.setText(ss);
    }

    private static final HashMap<String, Integer> EMOJI_DATAS = new HashMap<String, Integer>();

    static {
        EMOJI_DATAS.put("[微笑]", R.drawable.smiley_0);
        EMOJI_DATAS.put("[伤心]", R.drawable.smiley_1);
        EMOJI_DATAS.put("[美女]", R.drawable.smiley_2);
        EMOJI_DATAS.put("[发呆]", R.drawable.smiley_3);
        EMOJI_DATAS.put("[墨镜]", R.drawable.smiley_4);
        EMOJI_DATAS.put("[大哭]", R.drawable.smiley_5);
        EMOJI_DATAS.put("[害羞]", R.drawable.smiley_6);
        EMOJI_DATAS.put("[闭嘴]", R.drawable.smiley_7);
        EMOJI_DATAS.put("[睡觉]", R.drawable.smiley_8);
        EMOJI_DATAS.put("[伤心]", R.drawable.smiley_9);

        EMOJI_DATAS.put("[冷汗]", R.drawable.smiley_10);
        EMOJI_DATAS.put("[发怒]", R.drawable.smiley_11);
        EMOJI_DATAS.put("[调皮]", R.drawable.smiley_12);
        EMOJI_DATAS.put("[呲牙]", R.drawable.smiley_13);
        EMOJI_DATAS.put("[惊讶]", R.drawable.smiley_14);
        EMOJI_DATAS.put("[难过]", R.drawable.smiley_15);
        EMOJI_DATAS.put("[酷]", R.drawable.smiley_16);
        EMOJI_DATAS.put("[汗]", R.drawable.smiley_17);
        EMOJI_DATAS.put("[抓狂]", R.drawable.smiley_18);
        EMOJI_DATAS.put("[吐]", R.drawable.smiley_19);

        EMOJI_DATAS.put("[偷笑]", R.drawable.smiley_20);
        EMOJI_DATAS.put("[快乐]", R.drawable.smiley_21);
        EMOJI_DATAS.put("[奇]", R.drawable.smiley_22);
        EMOJI_DATAS.put("[傲]", R.drawable.smiley_23);
        EMOJI_DATAS.put("[饿]", R.drawable.smiley_24);
        EMOJI_DATAS.put("[累]", R.drawable.smiley_25);
        EMOJI_DATAS.put("[惊恐]", R.drawable.smiley_26);
        EMOJI_DATAS.put("[汗]", R.drawable.smiley_27);
        EMOJI_DATAS.put("[高兴]", R.drawable.smiley_28);
        EMOJI_DATAS.put("[大兵]", R.drawable.smiley_29);

        EMOJI_DATAS.put("[奋斗]", R.drawable.smiley_30);
        EMOJI_DATAS.put("[骂]", R.drawable.smiley_31);
        EMOJI_DATAS.put("[疑问]", R.drawable.smiley_32);
        EMOJI_DATAS.put("[嘘]", R.drawable.smiley_33);
        EMOJI_DATAS.put("[晕]", R.drawable.smiley_34);
        EMOJI_DATAS.put("[痛苦]", R.drawable.smiley_35);
        EMOJI_DATAS.put("[衰]", R.drawable.smiley_36);
        EMOJI_DATAS.put("[鬼]", R.drawable.smiley_37);
        EMOJI_DATAS.put("[敲打]", R.drawable.smiley_38);
        EMOJI_DATAS.put("[再见]", R.drawable.smiley_39);

        EMOJI_DATAS.put("[冷汗]", R.drawable.smiley_40);
        EMOJI_DATAS.put("[挖鼻]", R.drawable.smiley_41);
        EMOJI_DATAS.put("[鼓掌]", R.drawable.smiley_42);
        EMOJI_DATAS.put("[出丑]", R.drawable.smiley_43);
        EMOJI_DATAS.put("[坏笑]", R.drawable.smiley_44);
        EMOJI_DATAS.put("[左嘘]", R.drawable.smiley_45);
        EMOJI_DATAS.put("[右嘘]", R.drawable.smiley_46);
        EMOJI_DATAS.put("[打哈欠]", R.drawable.smiley_47);
        EMOJI_DATAS.put("[鄙视]", R.drawable.smiley_48);
        EMOJI_DATAS.put("[委屈]", R.drawable.smiley_49);

        EMOJI_DATAS.put("[快哭了]", R.drawable.smiley_50);
        EMOJI_DATAS.put("[邪恶]", R.drawable.smiley_51);
        EMOJI_DATAS.put("[亲亲]", R.drawable.smiley_52);
        EMOJI_DATAS.put("[吓吓]", R.drawable.smiley_53);
        EMOJI_DATAS.put("[可怜]", R.drawable.smiley_54);
        EMOJI_DATAS.put("[菜刀]", R.drawable.smiley_55);
        EMOJI_DATAS.put("[西瓜]", R.drawable.smiley_56);
        EMOJI_DATAS.put("[啤酒]", R.drawable.smiley_57);
        EMOJI_DATAS.put("[篮球]", R.drawable.smiley_58);
        EMOJI_DATAS.put("[乒乓球]", R.drawable.smiley_59);

        EMOJI_DATAS.put("[喝茶]", R.drawable.smiley_60);
        EMOJI_DATAS.put("[吃饭]", R.drawable.smiley_61);
        EMOJI_DATAS.put("[猪头]", R.drawable.smiley_62);
        EMOJI_DATAS.put("[鲜花]", R.drawable.smiley_63);
        EMOJI_DATAS.put("[花谢]", R.drawable.smiley_64);
        EMOJI_DATAS.put("[吻]", R.drawable.smiley_65);
        EMOJI_DATAS.put("[红心]", R.drawable.smiley_66);
        EMOJI_DATAS.put("[心碎]", R.drawable.smiley_67);
        EMOJI_DATAS.put("[生日]", R.drawable.smiley_68);
        EMOJI_DATAS.put("[闪电]", R.drawable.smiley_69);

        EMOJI_DATAS.put("[地雷]", R.drawable.smiley_70);
        EMOJI_DATAS.put("[刀]", R.drawable.smiley_71);
        EMOJI_DATAS.put("[足球]", R.drawable.smiley_72);
        EMOJI_DATAS.put("[甲虫]", R.drawable.smiley_73);
        EMOJI_DATAS.put("[便便]", R.drawable.smiley_74);
        EMOJI_DATAS.put("[月亮]", R.drawable.smiley_75);
        EMOJI_DATAS.put("[太阳]", R.drawable.smiley_76);
        EMOJI_DATAS.put("[礼物]", R.drawable.smiley_77);
        EMOJI_DATAS.put("[拥抱]", R.drawable.smiley_78);
        EMOJI_DATAS.put("[强]", R.drawable.smiley_79);

        EMOJI_DATAS.put("[弱]", R.drawable.smiley_80);
        EMOJI_DATAS.put("[握手]", R.drawable.smiley_81);
        EMOJI_DATAS.put("[胜利]", R.drawable.smiley_82);
        EMOJI_DATAS.put("[抱拳]", R.drawable.smiley_83);
        EMOJI_DATAS.put("[勾引]", R.drawable.smiley_84);
        EMOJI_DATAS.put("[握拳]", R.drawable.smiley_85);
        EMOJI_DATAS.put("[差劲]", R.drawable.smiley_86);
        EMOJI_DATAS.put("[爱你]", R.drawable.smiley_87);
        EMOJI_DATAS.put("[No]", R.drawable.smiley_88);
        EMOJI_DATAS.put("[OK]", R.drawable.smiley_89);

        EMOJI_DATAS.put("[爱情]", R.drawable.smiley_90);
        EMOJI_DATAS.put("[飞吻]", R.drawable.smiley_91);
        EMOJI_DATAS.put("[跳跳]", R.drawable.smiley_92);
        EMOJI_DATAS.put("[发抖]", R.drawable.smiley_93);
        EMOJI_DATAS.put("[怄火]", R.drawable.smiley_94);
        EMOJI_DATAS.put("[转圈]", R.drawable.smiley_95);
        EMOJI_DATAS.put("[磕头]", R.drawable.smiley_96);
        EMOJI_DATAS.put("[回头]", R.drawable.smiley_97);
        EMOJI_DATAS.put("[跳绳]", R.drawable.smiley_98);
        EMOJI_DATAS.put("[投降]", R.drawable.smiley_99);

        EMOJI_DATAS.put("[激动]", R.drawable.smiley_100);
        EMOJI_DATAS.put("[乱舞]", R.drawable.smiley_101);
        EMOJI_DATAS.put("[献吻]", R.drawable.smiley_102);
        EMOJI_DATAS.put("[左太极]", R.drawable.smiley_103);
        EMOJI_DATAS.put("[右太极]", R.drawable.smiley_104);
    }
}
