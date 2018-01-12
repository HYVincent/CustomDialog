package com.vincent.custom_dialog.view;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.vincent.custom_dialog.R;


/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name StartKangMedical_Android
 * @page com.toncentsoft.starkangmedical_android.view
 * @class describe
 * @date 2018/1/12 11:21
 */


public class HistoryMenuPopupwindow extends BasePopupWindows {

    private static final String TAG = HistoryMenuPopupwindow.class.getSimpleName();
    private LinearLayout llCollect,llDelete;


    public HistoryMenuPopupwindow(final Activity activity, final HistoryViewClickListener historyViewClickListener) {
        super(activity);
        View view = LayoutInflater.from(activity).inflate(R.layout.popup_layout_history_menu,null,false);
        setContentView(view);
        llCollect = view.findViewById(R.id.popup_collect_ll);
        llDelete = view.findViewById(R.id.popup_delete_ll);
        llCollect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyViewClickListener.onCollectClick();
                dismiss();
            }
        });
        llDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyViewClickListener.onDeleteClick();
                dismiss();
            }
        });

    }


    public interface HistoryViewClickListener{

        void onCollectClick();

        void onDeleteClick();

    }


}
