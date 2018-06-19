package com.vincent.dialog.simple;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.vincent.dialog.BaseDialog;
import com.vincent.dialog.R;


/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name StartKangMedical_Android
 * @page com.toncentsoft.starkangmedical_android.view
 * @class describe
 * @date 2018/4/23 10:10
 */
public class RecordStyleDialog extends BaseDialog {

    private ImageView iv;
    private double db;

    public RecordStyleDialog(@NonNull Context context) {
        super(context);
        setContentView(R.layout.library_dialog_layout_record);
        setDimAmount(0);
        iv = findViewById(R.id.library_dialog_layout_record);
        iv.setImageDrawable(ContextCompat.getDrawable(context,R.mipmap.dialog_icon_record_1));
    }

    public void upDbSize(double db){
        if(iv == null){
            return;
        }



    }

}
