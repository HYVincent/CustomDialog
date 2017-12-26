package com.vincent.custom_dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;


/**
 * @author Administrator QQ:1032006226
 * @version v1.0
 * @name StarKangMedical
 * @page com.vincent.mylibrary.dialog
 * @class describe
 * @date 2017/12/8 14:24
 */


public abstract class BaseDialog extends Dialog {

    private static final String TAG = BaseDialog.class.getSimpleName();

    private int margin;//左右边距
    private int width;//宽度
    private int height;//高度
    private float dimAmount = 0.5f;//灰度深浅
    private boolean showBottom;//是否底部显示
    private boolean outCancel = true;//是否点击外部取消

    @StyleRes
    private int animStyle;

    @LayoutRes
    protected int layoutId;

    public BaseDialog(@NonNull Context context) {
        super(context,R.style.MyDialogBgIsTransparent);
    }

    public BaseDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if(width == 0){
//            width = ScreenUtils.getScreenWidth(getContext());
            width = ScreenUtils.getScreenWidth(getContext()) - 2 * DpUtil.dp2px(getContext(), margin);
        }
        if(height == 0){
            height = WindowManager.LayoutParams.WRAP_CONTENT;
        }
        if(showBottom){
            layoutParams.gravity = Gravity.BOTTOM;
        }else {
            layoutParams.gravity = Gravity.CENTER;
        }
        layoutParams.height = height;
        layoutParams.width = width;
        layoutParams.dimAmount = dimAmount;
        window.setAttributes(layoutParams);
    }




    public void setMargin(int margin) {
        this.margin = margin;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * 设置背景变暗程度 设置为0的时候背景不变  0.5 半透明
     * @param dimAmount
     * @return
     */
    public void setDimAmount(float dimAmount) {
        this.dimAmount = dimAmount;
    }

    public void setShowBottom(boolean showBottom) {
        this.showBottom = showBottom;
    }

    public void setOutCancel(boolean outCancel) {
        this.outCancel = outCancel;
    }

    public void setAnimStyle(@StyleRes int animStyle) {
        this.animStyle = animStyle;
    }

}