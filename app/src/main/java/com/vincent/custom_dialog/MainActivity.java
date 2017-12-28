package com.vincent.custom_dialog;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vincent.dialog.entity.SelectEntity;
import com.vincent.dialog.simple.LoadingDialog;
import com.vincent.dialog.simple.MultipleSelectDialog;
import com.vincent.dialog.simple.OrdinaryMsgDialog;
import com.vincent.dialog.simple.SingleSelectDialog;
import com.vincent.dialog.simple.SlideListDialog;
import com.vincent.dialog.util.MyToast;
import com.vincent.dialog.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_custom_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DialogActivity.class);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_custom_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ViewActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){

            default:break;
        }
    }


}
