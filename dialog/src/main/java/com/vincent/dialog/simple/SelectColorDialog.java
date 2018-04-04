package com.vincent.dialog.simple;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vincent.dialog.BaseDialog;
import com.vincent.dialog.R;
import com.vincent.dialog.util.DpUtil;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.dialog.simple
 * @class describe
 * @date 2018/4/4 17:33
 */
public class SelectColorDialog extends BaseDialog {

    private ImageView imageView ;
    private Button btnCancel,btnOk;
    private TextView tvColor;
    private ColorSelectResultListener selectResultListener;
    //触摸屏幕获取到的颜色值
    private int selectColor;
    //转化之后的颜色值
    private String resultColor;
    private int imgageViewWidth;
    private int imageViewHeight;
    private final String TAG = SelectColorDialog.class.getSimpleName();

    public SelectColorDialog setSelectResultListener(ColorSelectResultListener selectResultListener) {
        this.selectResultListener = selectResultListener;
        return this;
    }

    public SelectColorDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.library_layout_color_select);
        imageView = findViewById(R.id.library_select_color_show);
        btnCancel = findViewById(R.id.library_btn_cancel);
        btnOk = findViewById(R.id.library_btn_ok);
        tvColor = findViewById(R.id.library_select_color);
        tvColor.setBackgroundColor(ContextCompat.getColor(context,R.color.color_black_000000));
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(selectResultListener != null ){
                    selectResultListener.select(resultColor);
                }
                dismiss();
            }
        });
        final Bitmap bm = ((BitmapDrawable) (imageView).getDrawable()).getBitmap();
        imgageViewWidth = bm.getWidth();
        imageViewHeight = bm.getHeight();
        Log.d(TAG, "SelectColorDialog: "+imgageViewWidth+" "+imageViewHeight);
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float x = 0;
                float y = 0;
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        x = event.getX();
                        y = event.getY();
                    case MotionEvent.ACTION_MOVE:
                        x = event.getX();
                        y = event.getY();
                        if(bm != null && x < imgageViewWidth && y<imageViewHeight){
                            selectColor = bm.getPixel((int) x,(int) y);
                            resultColor = Integer.toHexString(convert_RGB_to_ARGB(selectColor));
                            tvColor.setBackgroundColor(selectColor);
                        }
                }
                return true;
            }
        });
    }

    //(x,y)是否在view的区域内
    private boolean isTouchPointInView(View view, int x, int y) {
        if (view == null) {
            return false;
        }
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        int left = location[0];
        int top = location[1];
        int right = left + view.getMeasuredWidth();
        int bottom = top + view.getMeasuredHeight();
        //view.isClickable() &&
        if (y >= top && y <= bottom && x >= left
                && x <= right) {
            return true;
        }
        return false;
    }

    /**
     * 十进制颜色值转为16进制
     * @param rgb
     * @return
     */
    public int  convert_RGB_to_ARGB(int
                                     rgb) {
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = (rgb >> 0) & 0xFF;
        return 0xff000000  | (r << 16) | (g << 8) | b;
    }

    public interface ColorSelectResultListener{
        void select(String selectColor);
    }

}
