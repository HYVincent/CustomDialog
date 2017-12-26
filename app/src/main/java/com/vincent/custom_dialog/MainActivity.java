package com.vincent.custom_dialog;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.vincent.dialog.BaseDialog;
import com.vincent.dialog.LoadingDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = MainActivity.class.getSimpleName();
    private Button btn1;
    private LoadingDialog loadingDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn);
        btn1.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:
                Log.d(TAG, "onClick: click..");
                showLoadingDialog();
                break;
            default:break;
        }
    }

    private void showLoadingDialog() {
        if(loadingDialog == null){
            loadingDialog = new LoadingDialog(MainActivity.this);
        }
        loadingDialog.setOutCancel(false);
        loadingDialog.setMsg("登录中..");
        loadingDialog.show();
    }
}
