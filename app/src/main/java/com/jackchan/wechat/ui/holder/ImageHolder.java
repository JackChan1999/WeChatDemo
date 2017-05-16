package com.jackchan.wechat.ui.holder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jackchan.wechat.R;
import com.jackchan.wechat.base.Global;
import com.jackchan.wechat.ui.adapter.BaseAdapterRV;
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
 * des ：朋友圈中的图片展示
 * gitVersion：2.12.0.windows.1
 * updateAuthor：AllenIverson
 * updateDate：2017/5/16 12:39
 * updateDes：${TODO}
 * ============================================================
 */

public class ImageHolder extends BaseHolderRV<String> {

    private ImageView ivImage;

    public ImageHolder(Context context, ViewGroup parent,
                       BaseAdapterRV<String> adapter, int itemType) {
        super(context, parent, adapter, itemType, R.layout.item_image);
    }

    // 查找item中的子控件
    @Override
    public void onFindViews(View itemView) {
        ivImage = (ImageView) itemView.findViewById(R.id.iv_image);
    }

    // 刷新item子控件的显示
    @Override
    protected void onRefreshView(String imagePath, int position) {
        // 动态设置图片宫格的宽高
        // 1张图片  ->   宫格的宽高为图片的宽高
        // 其它情况  ->  宫格的宽高为Global.getGridWidth()
        ViewGroup.LayoutParams param = super.itemView.getLayoutParams();
        if (super.adapter.getItemCount() == 1) {    // 一张图片
            // 图片资源id
            int imageResId = Global.getResId(context, imagePath);
            Bitmap bitmap = BitmapFactory.decodeResource(
                    context.getResources(), imageResId);
            // 指定宫格的宽高为图片的宽高
            param.width = bitmap.getWidth();
            param.height = bitmap.getHeight();
            // 显示图片
            ivImage.setBackgroundResource(imageResId);
        } else {    // 多张图片
            // 显示宫格图片
            int imageResId = Global.getResId(context, imagePath);
            ivImage.setBackgroundResource(imageResId);

            param.width = Global.getGridWidth();    // 指定宫格图片的宽
            param.height = Global.getGridWidth();
        }
    }
}
