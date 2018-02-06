package com.vincent.dialog.simple;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.vincent.dialog.BaseDialog;
import com.vincent.dialog.R;

/**
 * @author Administrator QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.dialog.simple
 * @class describe
 * @date 2018/2/6 14:44
 */

public class InputContentCenterDialog extends BaseDialog {

    private TextView tvTitle,tvCancel,tvGo;
    private EditText etInput;
    private String strTitle,strCancel,strGo,strHintText;
    private InputContentDialogListener inputContentDialogListener;
    //是否判断内容为空
    private boolean isCheckNull = false;
    private static final String TAG = InputContentCenterDialog.class.getSimpleName();

    public InputContentCenterDialog setCheckNull(boolean checkNull) {
        isCheckNull = checkNull;
        return this;
    }

    public InputContentCenterDialog setInputContentDialogListener(InputContentDialogListener inputContentDialogListener) {
        this.inputContentDialogListener = inputContentDialogListener;
        return this;
    }

    public InputContentCenterDialog setStrTitle(String strTitle) {
        this.strTitle = strTitle;
        return this;
    }

    public InputContentCenterDialog setStrCancel(String strCancel) {
        this.strCancel = strCancel;
        return this;
    }

    public InputContentCenterDialog setStrGo(String strGo) {
        this.strGo = strGo;
        return this;
    }

    public InputContentCenterDialog setStrHintText(String strHintText) {
        this.strHintText = strHintText;
        return this;
    }

    public InputContentCenterDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.library_layout_input_content_center);
        setShowBottom(false);
        tvTitle = findViewById(R.id.library_input_content_center_title);
        tvCancel = findViewById(R.id.library_input_content_center_tv_cancel);
        tvGo = findViewById(R.id.library_input_content_center_tv_action);
        etInput = findViewById(R.id.library_input_content_center_et);
        tvTitle.setText(strTitle);
        tvCancel.setText(strCancel);
        tvGo.setText(strGo);
        etInput.setHint(strHintText);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        tvGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputContentDialogListener != null){
                    String content = etInput.getText().toString().trim();
                    if(isCheckNull && TextUtils.isEmpty(content)){
                        inputContentDialogListener.onConentNull();
                    }else {
                        inputContentDialogListener.onClick(content);
                        dismiss();
                    }
                }else {
                    Log.e(TAG, "onClick: please setting InputContentCenterDialog's setInputContentDialogListener method" );
                }
            }
        });
    }

    public interface InputContentDialogListener{

        /**
         * 获取内容
         * @param content
         */
        void onClick(String content);

        /**
         * 内容为空
         */
        void onConentNull();
    }

}
