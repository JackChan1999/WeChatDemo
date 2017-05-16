package com.jackchan.wechat.ui.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.widget.TextView;

import com.jackchan.wechat.R;
import com.jackchan.wechat.base.Global;
import com.jackchan.wechat.util.EmojiUtil;
import com.jackchan.wechat.util.LinkifyUtil;

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
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/16 12:39
 * updateDes：${TODO}
 * ============================================================
 */
/**
 * 演示TextView展示表情和链接(TextView富文本)
 */
public class TextViewActivity extends AppCompatActivity {

    private TextView tv01;
    private TextView tv02;
    private TextView tv03;
    private TextView tv04;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);

        tv01 = (TextView) findViewById(R.id.tv_01);
        tv02 = (TextView) findViewById(R.id.tv_02);
        tv03 = (TextView) findViewById(R.id.tv_03);
        tv04 = (TextView) findViewById(R.id.tv_04);

        test01();
        test02();
        test03();
    }

    private void test03() {
        LinkifyUtil.addCustomLink(tv04);
        LinkifyUtil.addCustomLink2(tv04);
    }

    private void test02() {
        String text = "高兴[高兴] 再见 [再见] 大兵 [大兵] xxx [xxx]";
        EmojiUtil.setText(tv02, text);
    }

    // 显示表情
    private void test01() {
        String text = "高兴[高兴] 富文本显示";
        SpannableString ss = new SpannableString(text);

        // 指定了一张图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        bitmap = Global.createBitmap(bitmap, Global.dp2px(20));     // 图片的宽高为20dp
        ImageSpan span = new ImageSpan(this, bitmap, ImageSpan.ALIGN_BOTTOM);
        ss.setSpan(span, 2, 6, 0);

        tv01.setText(ss);       // 显示图文混排（文本中包含表情）
    }

}












