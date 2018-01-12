package com.vincent.custom_dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.vincent.custom_dialog.view.EcgView;
import com.vincent.custom_dialog.view.Electrocardiogram;

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

    private Electrocardiogram electrocardiogram;
    private String data;

    private EcgView ecgView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrocardiograph);
        data = ReadAssetsUtils.readAssetsTextReturnStr(this,"StarCareData");
        electrocardiogram = findViewById(R.id.e_electrocardiogram);
        electrocardiogram.addData();
        electrocardiogram.setElectrocardiogramData(getData(data));
        electrocardiogram.startDraw();
        ecgView = findViewById(R.id.ecg_view);
        List<Integer> datas = getData2(ReadAssetsUtils.readAssetsTextReturnStr(this,"ecgdata"));
        for (int i=0;i<datas.size();i++){
            EcgView.addEcgData0(datas.get(i));
            EcgView.addEcgData0(datas.get(i));
        }
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


    private List<Float> getData(String data) {
        List<Float> datas = new ArrayList<>();
        String[] strarr = data.split("\n");
        for (int i=0;i<strarr.length;i++){
            datas.add(Float.valueOf(strarr[i]));
        }
        Log.d(getClass().getSimpleName(), "getData: "+datas.size());
        return datas;
    }
}
