package com.vincent.custom_dialog;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.vincent.dialog.util.MyToast;

import java.util.ArrayList;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.custom_dialog
 * @class describe
 * @date 2017/12/28 11:18
 */

public class ViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        findViewById(R.id.button_electrocardiograph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ViewActivity.this,ElectrocardiographActivity.class));
            }
        });
    }
}
