package com.vincent.dialog.simple;

import android.content.Context;
import android.support.annotation.NonNull;

import com.vincent.dialog.BaseDialog;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.dialog.util
 * @class describe 多选对话框
 * @date 2017/12/26 10:02
 */

public class MultipleSelectDialog extends BaseDialog {


    public MultipleSelectDialog(@NonNull Context context) {
        super(context);
    }

    public MultipleSelectDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }
}
