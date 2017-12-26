package com.vincent.dialog.simple;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.vincent.dialog.BaseDialog;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.dialog
 * @class describe
 * @date 2017/12/26 10:12
 */

public class OrdinaryMsgDialog extends BaseDialog {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public OrdinaryMsgDialog(@NonNull Context context) {
        super(context);
    }

    public OrdinaryMsgDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

}
