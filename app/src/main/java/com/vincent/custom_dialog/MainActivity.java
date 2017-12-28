package com.vincent.custom_dialog;

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
    private Button btnLoadingDialog,btnSingleSelectDialog,btnMultipleSelectDialog,btnSlideListDialog,btnOrdinaryMsgDialog;
    private LoadingDialog loadingDialog;
    private SingleSelectDialog singleSelectDialog;
    private MultipleSelectDialog multipleSelectDialog;
    private SlideListDialog slideListDialog;
    private OrdinaryMsgDialog ordinaryMsgDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLoadingDialog = findViewById(R.id.btn_loading);
        btnLoadingDialog.setOnClickListener(this);
        btnSingleSelectDialog = findViewById(R.id.btn_single_select);
        btnSingleSelectDialog.setOnClickListener(this);
        btnMultipleSelectDialog = findViewById(R.id.btn_multiple_select);
        btnMultipleSelectDialog.setOnClickListener(this);
        btnSlideListDialog = findViewById(R.id.btn_slide_list);
        btnSlideListDialog.setOnClickListener(this);
        btnOrdinaryMsgDialog = findViewById(R.id.btn_ordinary_msg);
        btnOrdinaryMsgDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_loading:
                Log.d(TAG, "onClick: click..");
                showLoadingDialog();
                break;
            case R.id.btn_single_select:
                showSingleDialog();
                break;
            case R.id.btn_multiple_select:
                showMultipleSelectDialog();
                break;
            case R.id.btn_slide_list:
                showSlideListDialog();
                break;
            case R.id.btn_ordinary_msg:
                showOrdinaryMsgDialog();
                break;
            default:break;
        }
    }

    /**
     * 显示一般消息
     */
    private void showOrdinaryMsgDialog() {
        if(ordinaryMsgDialog == null){
            ordinaryMsgDialog = new OrdinaryMsgDialog(MainActivity.this);
        }
        ordinaryMsgDialog.setWidth(0);
        ordinaryMsgDialog.setStrTitle("温馨提示")
                .setStrContent("有美女")
                .setStrCancel("不需要")
                .setStrOk("好吧")
                .setOnActionClickListener(new OrdinaryMsgDialog.OnActionClickListener() {
                    @Override
                    public void doAction() {
                        MyToast.toastMsg(MainActivity.this,"do something...");
                    }
                })
                .show();
    }

    private void showSlideListDialog() {
        slideListDialog = new SlideListDialog(MainActivity.this);
        slideListDialog.setShowBottom(true);
        slideListDialog.setTitleText("选择性别")
                .setData(getSexData2())
                .setSlideListDialogResultListener(new SlideListDialog.SlideListDialogResultListener() {
                    @Override
                    public void result(int position) {
                        MyToast.toastMsg(MainActivity.this,getSexData2().get(position));
                    }
                })
                .show();
    }

    private List<String> getSexData2() {
        List<String> data = new ArrayList<>();
        data.add("男");
        data.add("女");
        return data;
    }

    private void showMultipleSelectDialog() {
        multipleSelectDialog = new MultipleSelectDialog(MainActivity.this);
        multipleSelectDialog.setHeight(ScreenUtils.getScreenHeight(MainActivity.this)/2);
        multipleSelectDialog.setMargin(12);
        multipleSelectDialog.setCancelText("不选")
                .setTitleText("多选测试")
                .setOkText("选好了")
                .setData(getMultipleData())
                .setMultipleSelectResultOnClickListener(new MultipleSelectDialog.MultipleSelectResultOnClickListener() {
                    @Override
                    public void result(List<String> data) {
                        Log.d(TAG, "result : "+String.valueOf(data.size()));
                    }
                })
                .show();
    }

    private void showSingleDialog() {
//        if (singleSelectDialog == null) {
            singleSelectDialog = new SingleSelectDialog(MainActivity.this);
//        }
//        singleSelectDialog.setHeight(ScreenUtils.getScreenHeight(MainActivity.this)/2);
        singleSelectDialog.setCancelText("不选")
                .setOkText("好了")
                .setTitleText("请选择性别")
                .setData(getSexData())
                .setSelectResultOnListener(new SingleSelectDialog.SelectResultOnListener() {
                    @Override
                    public void onResult(String result) {
                        MyToast.toastMsg(MainActivity.this,result);
                    }
                }).show();
    }

    private void showLoadingDialog() {
//        if(loadingDialog == null){
            loadingDialog = new LoadingDialog(MainActivity.this);
//        }
        loadingDialog.setOutCancel(false);
        loadingDialog.setMsg("登录中..");
        loadingDialog.show();
    }

    public List<SelectEntity> getSexData() {
        List<SelectEntity> data = new ArrayList<>();
        /*for (int i=0;i<100;i++){
            SelectEntity entity = new SelectEntity();
            entity.setItemContent("item "+String.valueOf(i));
            data.add(entity);
        }*/
        SelectEntity man = new SelectEntity();
        man.setItemContent("男");
        man.setSelect(true);
        SelectEntity woman = new SelectEntity();
        woman.setItemContent("女");
        data.add(man);
        data.add(woman);
        return data;
    }


    public List<SelectEntity> getMultipleData() {
        List<SelectEntity> data = new ArrayList<>();
        for (int i=0;i<200;i++){
            SelectEntity selectEntity = new SelectEntity();
            selectEntity.setItemContent("item "+String.valueOf(i));
            data.add(selectEntity);
        }
        return data;
    }
}
