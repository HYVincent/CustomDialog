package com.vincent.custom_dialog.view;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0 自定义PopupWindows基类
 * @name StartKangMedical_Android
 * @page com.vincent.mylibrary.dialog
 * @class describe
 * @date 2018/1/4 13:47
 */

public class BasePopupWindows extends PopupWindow {

    private int params_width = 0;
    private int params_height = 0;

    private static final String TAG = BasePopupWindows.class.getSimpleName();

    private Activity activity;
    //0.5f半透明 1不透明
    private float values = 0.5f;
    //动画id
    private int animId;

    public BasePopupWindows(final Activity activity){
        super(activity);
        this.activity = activity;
        initParams();
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                setWindowAlpha(activity,1);
            }
        });
    }

    /**
     * 背景恢复
     * @param activity
     * @param alpha
     * @return
     */
    public BasePopupWindows setWindowAlpha(Activity activity,float alpha) {
        if (alpha < 0 || alpha > 1||activity ==null){
            return this;
        }
        WindowManager.LayoutParams windowLP =activity. getWindow().getAttributes();
        windowLP.alpha = alpha;
        if (alpha == 1) {
            activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//不移除该Flag的话,在有视频的页面上的视频会出现黑屏的bug
        } else {
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);//此行代码主要是解决在华为手机上半透明效果无效的bug
        }
        activity.getWindow().setAttributes(windowLP);
        return this;
    }


    /**
     * 设置宽度
     * @param params_width
     * @return
     */
    public BasePopupWindows setWindowWidth(int params_width) {
        this.params_width = params_width;
        return this;
    }

    /**
     * 设置高度
     * @param params_height
     * @return
     */
    public BasePopupWindows setWindowHeight(int params_height) {
        this.params_height = params_height;
        return this;
    }


    /**
     * 设置背景透明度值
     * @param values
     * @return
     */
    public BasePopupWindows setValues(float values) {
        this.values = values;
        return this;
    }

    /**
     * 设置弹出动画
     * @param animId
     * @return
     */
    public BasePopupWindows setAnimId(int animId) {
        setAnimationStyle(animId);
        return this;
    }

    private void initParams() {
        //是否响应外部点击事件,设置为true时不响应外部事件，此时点击外部popupwindows消失，
        // 如果设置false，则可以点击popupwindow以外的控件，不影响本身显示
        setOutsideTouchable(true);
        // 聚焦点击事件不会透传给下面的View
        setFocusable(true);
        //设置响应点击事件
        setTouchable(true);
        if(params_width == 0){
            params_width = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        setWidth(params_width);
        if(params_height == 0){
            params_height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        setWidth(params_height);
        setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        if(activity != null){
            //设置了这个之后背景会变暗
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
            WindowManager.LayoutParams lp = activity.getWindow()
                    .getAttributes();
            lp.alpha = values;//0.5f 为半透明
            activity.getWindow().setAttributes(lp);
        }
        update();
    }

    @Override
    public void showAsDropDown(View anchor) {
        initParams();
        super.showAsDropDown(anchor);
    }

    @Override
    public void showAtLocation(View parent, int gravity, int x, int y) {
        initParams();
        super.showAtLocation(parent, gravity, x, y);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff) {
        initParams();
        super.showAsDropDown(anchor, xoff, yoff);
    }

    @Override
    public void showAsDropDown(View anchor, int xoff, int yoff, int gravity) {
        initParams();
        super.showAsDropDown(anchor, xoff, yoff, gravity);
    }

}
