package com.vincent.custom_dialog;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.vincent.dialog.util.MyToast;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.custom_dialog
 * @class describe
 * @date 2017/12/28 11:18
 */

public class ViewActivity extends AppCompatActivity {

    private KeyListener keyListener;
    private EditText editText;
    private Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        editText = findViewById(R.id.edit_query);
        button = findViewById(R.id.buttonPanel);
        editTextable(editText,false);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                editTextable(editText,true);
                MyToast.toastMsg(ViewActivity.this,"click");
            }
        });
        findViewById(R.id.open).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextUtils.openKeyboard(ViewActivity.this,editText);
            }
        });
        findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditTextUtils.closeKeyboard(ViewActivity.this);
            }
        });
    }

    //设置EditText可输入和不可输入状态
    private void editTextable(EditText editText, boolean editable) {
        if (!editable) { // disable editing password
            editText.setFocusable(false);
            editText.setFocusableInTouchMode(false); // user touches widget on phone with touch screen
            editText.setClickable(false); // user navigates with wheel and selects widget
        } else { // enable editing of password
            editText.setFocusable(true);
            editText.setFocusableInTouchMode(true);
            editText.setClickable(true);
        }
    }

}
