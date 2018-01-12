package com.vincent.custom_dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;

import com.vincent.custom_dialog.view.HistoryMenuPopupwindow;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.custom_dialog
 * @class describe
 * @date 2018/1/12 13:51
 */


public class PopupWindowsActivity extends AppCompatActivity {

    private HistoryMenuPopupwindow historyMenuPopupwindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popupwindows);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(historyMenuPopupwindow == null){
                    historyMenuPopupwindow = new HistoryMenuPopupwindow(PopupWindowsActivity.this, new HistoryMenuPopupwindow.HistoryViewClickListener() {
                        @Override
                        public void onCollectClick() {

                        }

                        @Override
                        public void onDeleteClick() {

                        }
                    });
                }
                historyMenuPopupwindow.showAsDropDown(v,0,110, Gravity.BOTTOM);
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(getClass().getSimpleName(), "onClick: .........");
            }
        });
    }

    @Override
    public void onBackPressed() {
        if(historyMenuPopupwindow!= null && historyMenuPopupwindow.isShowing()){
            historyMenuPopupwindow.dismiss();
        }else {
            super.onBackPressed();
        }
    }
}
