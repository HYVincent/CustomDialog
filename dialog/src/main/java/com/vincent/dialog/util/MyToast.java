package com.vincent.dialog.util;

import android.content.Context;
import android.widget.Toast;

/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.dialog.util
 * @class describe
 * @date 2017/12/26 12:53
 */

public class MyToast {

    public static void toastMsg(Context mContext,String msg){
        Toast.makeText(mContext,msg,Toast.LENGTH_LONG).show();
    }

}
