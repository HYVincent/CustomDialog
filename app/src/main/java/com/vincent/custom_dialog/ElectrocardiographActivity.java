package com.vincent.custom_dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


/**
 * @author Vincent QQ:1032006226
 * @version v1.0
 * @name CustomDialog
 * @page com.vincent.custom_dialog
 * @class describe
 * @date 2017/12/28 14:19
 */

public class ElectrocardiographActivity extends AppCompatActivity {

    private String data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrocardiograph);
        data = ReadAssetsUtils.readAssetsTextReturnStr(this,"StarCareData");
    }

    private List<Integer> getData2(String data) {
        List<Integer> datas = new ArrayList<>();
        String[] strarr = data.split(",");
        for (int i=0;i<strarr.length;i++){
            datas.add(Integer.valueOf(strarr[i]));
        }
        Log.d(getClass().getSimpleName(), "getData: "+datas.size());
        return datas;
    }

}
