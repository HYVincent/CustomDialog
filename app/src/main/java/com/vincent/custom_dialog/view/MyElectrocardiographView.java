package com.vincent.custom_dialog.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.custom_dialog
 * @class describe
 * @date 2017/12/28 17:42
 */

public class MyElectrocardiographView extends View {

    private Handler handler = new Handler(){};
    //画笔
    private Paint mPaint;
    //背景颜色
    private int colorBg;


    public MyElectrocardiographView(Context context) {
        super(context);
    }

    public MyElectrocardiographView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getResources().get
    }
}
