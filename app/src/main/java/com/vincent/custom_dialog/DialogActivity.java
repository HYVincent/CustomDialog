package com.vincent.custom_dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.elvishew.xlog.XLog;
import com.vincent.dialog.entity.SelectEntity;
import com.vincent.dialog.simple.FileUploadProgressDialog;
import com.vincent.dialog.simple.InputContentCenterDialog;
import com.vincent.dialog.simple.InputContentDialog;
import com.vincent.dialog.simple.LoadingDialog;
import com.vincent.dialog.simple.MultipleSelectDialog;
import com.vincent.dialog.simple.OrdinaryMsgDialog;
import com.vincent.dialog.simple.SingleSelectDialog;
import com.vincent.dialog.simple.SlideListDialog;
import com.vincent.dialog.util.MyToast;
import com.vincent.dialog.util.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.custom_dialog
 * @class describe
 * @date 2017/12/28 14:12
 */

public class DialogActivity extends AppCompatActivity  implements View.OnClickListener{

    private static final String TAG = DialogActivity.class.getSimpleName();

    private Button btnLoadingDialog,btnSingleSelectDialog,btnMultipleSelectDialog,btnInputContentCenterDialog,
            btnSlideListDialog,btnOrdinaryMsgDialog,btnInputContentDialog,btnFileUploadProgressDialog;
    private LoadingDialog loadingDialog;
    private SingleSelectDialog singleSelectDialog;
    private MultipleSelectDialog multipleSelectDialog;
    private SlideListDialog slideListDialog;
    private OrdinaryMsgDialog ordinaryMsgDialog;
    private InputContentDialog inputContentDialog;
    private FileUploadProgressDialog fileUploadProgressDialog;
    private InputContentCenterDialog inputContentCenterDialog;
    
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
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
        btnInputContentDialog = findViewById(R.id.btn_input_content);
        btnInputContentDialog.setOnClickListener(this);
        btnFileUploadProgressDialog = findViewById(R.id.btn_file_upload);
        btnFileUploadProgressDialog.setOnClickListener(this);
        btnInputContentCenterDialog = findViewById(R.id.btn_input_content_center);
        btnInputContentCenterDialog.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_loading:
                Log.d(TAG, "onClick: click..");
                XLog.d("test.......");
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
            case R.id.btn_input_content:
                showInputContentDialog();
                break;
            case R.id.btn_file_upload:
                showFileUploadProgressDialog();
                break;
            case R.id.btn_input_content_center:
                showInputContentCenterDialog();
                break;
            default:break;
        }
    }

    /**
     * 屏幕中心弹出dialog
     */
    private void showInputContentCenterDialog() {
        if(inputContentCenterDialog == null){
            inputContentCenterDialog = new InputContentCenterDialog(DialogActivity.this);
        }
        inputContentCenterDialog.setStrTitle("title")
                .setStrHintText("请输入内容")
                .setStrCancel("取消")
                .setStrGo("完成")
                .setCheckNull(true)
                .setInputContentDialogListener(new InputContentCenterDialog.InputContentDialogListener() {
                    @Override
                    public void onClick(String content) {
                        MyToast.toastMsg(DialogActivity.this,content);
                    }

                    @Override
                    public void onConentNull() {
                        MyToast.toastMsg(DialogActivity.this,"请输入内容");
                    }
                })
                .show();
    }

    private int progress = 0;

    private void showFileUploadProgressDialog() {
        if(fileUploadProgressDialog == null){
            fileUploadProgressDialog = new FileUploadProgressDialog(DialogActivity.this);
            fileUploadProgressDialog.setOutCancel(false);
        }
        fileUploadProgressDialog.setStrTitle("正在上传..")
                .setStrCancel("取消上传")
                .setCurrentProgress(progress)
                .setCancelUploadFileListener(new FileUploadProgressDialog.CancelUploadFileListener() {
                    @Override
                    public void onCancel() {
                        TimeUtils.cancelTimeTask();
                        progress =0;
                    }
                }).show();
        TimeUtils.startTime(0, 1000, 1000, 5, new TimeUtils.TimeListener() {
            @Override
            public void doAction(int index) {
                if(progress <100){
                    progress++;
                }else {
                    progress = 0;
                }
                Log.d(TAG, "doAction: progress ="+progress);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fileUploadProgressDialog.setCurrentProgress(progress);
                    }
                });
            }
        });
    }

    /**
     * 显示输入内容dialog，键盘弹出在dialog的下方
     */
    private void showInputContentDialog() {
        if(inputContentDialog == null){
            inputContentDialog = new InputContentDialog(DialogActivity.this);
        }
        inputContentDialog.setCheckNull(true,"请输入")
                .setInputContentListener(new InputContentDialog.InputContentListener() {
                    @Override
                    public void input(String content) {
                        MyToast.toastMsg(DialogActivity.this,content);
                    }
                }).show();
    }

    /**
     * 显示一般消息
     */
    private void showOrdinaryMsgDialog() {
        if(ordinaryMsgDialog == null){
            ordinaryMsgDialog = new OrdinaryMsgDialog(DialogActivity.this);
        }
        ordinaryMsgDialog.setWidth(0);
        ordinaryMsgDialog.setStrTitle("温馨提示")
                .setStrContent("有美女")
                .setStrCancel("不需要")
                .setStrOk("好吧")
                .setOnActionClickListener(new OrdinaryMsgDialog.OnActionClickListener() {
                    @Override
                    public void doAction() {
                        MyToast.toastMsg(DialogActivity.this,"do something...");
                    }
                })
                .show();
    }

    private void showSlideListDialog() {
        slideListDialog = new SlideListDialog(DialogActivity.this);
        slideListDialog.setShowBottom(true);
        slideListDialog.setTitleText("选择性别")
                .setData(getSexData2())
                .setSlideListDialogResultListener(new SlideListDialog.SlideListDialogResultListener() {
                    @Override
                    public void result(int position) {
                        MyToast.toastMsg(DialogActivity.this,getSexData2().get(position));
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
        multipleSelectDialog = new MultipleSelectDialog(DialogActivity.this);
        multipleSelectDialog.setHeight(ScreenUtils.getScreenHeight(DialogActivity.this)/2);
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
        singleSelectDialog = new SingleSelectDialog(DialogActivity.this);
//        }
//        singleSelectDialog.setHeight(ScreenUtils.getScreenHeight(DialogActivity.this)/2);
        singleSelectDialog.setCancelText("不选")
                .setOkText("好了")
                .setTitleText("请选择性别")
                .setData(getSexData())
                .setSelectResultOnListener(new SingleSelectDialog.SelectResultOnListener() {
                    @Override
                    public void onResult(String result) {
                        MyToast.toastMsg(DialogActivity.this,result);
                    }
                }).show();
    }

    private void showLoadingDialog() {
//        if(loadingDialog == null){
        loadingDialog = new LoadingDialog(DialogActivity.this);
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
