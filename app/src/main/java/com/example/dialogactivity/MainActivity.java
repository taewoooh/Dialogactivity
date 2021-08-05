package com.example.dialogactivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    AlertDialog.Builder oDialog;
    ListView listView;
    ArrayList dataList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);


//TODO 리스트 뷰에 표시할 데이터 삽입 실시



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlerDialog();
            }
        });


    }


    public void AlerDialog() { //알럿 다이얼로그 리스트뷰

        View inflate = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_custom_dialog, null, false);
        listView = (ListView) inflate.findViewById(R.id.listView);
        oDialog = new AlertDialog.Builder(this,R.style.CustomDialog);
        //Theme_DeviceDefault_Light_Dialog_Alert
        oDialog.setView(inflate);
        AlertDialog dialog = oDialog.create();

        dataList = new ArrayList();
        dataList.add("20210731");
        dataList.add("20210730");
        dataList.add("20210729");
        dataList.add("20210731");
        dataList.add("20210731");
        dataList.add("20210731");
        dataList.add("20210731");
        dataList.add("20210731");
        dataList.add("20210731");
        dataList.add("20210731");



        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, dataList);

//TODO 리스트 뷰에 어댑터 적용 실시
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String data = String.valueOf(dataList.get(position));

                //TODO 클릭한 아이템 토스트 메시지 출력 실시
                Toast.makeText(getApplication(),data,Toast.LENGTH_SHORT).show();
            }
        });







        dialog.show();



    }


}
