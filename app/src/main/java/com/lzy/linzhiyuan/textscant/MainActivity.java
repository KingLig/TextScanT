package com.lzy.linzhiyuan.textscant;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editbarcode;
    Receiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editbarcode=(EditText)findViewById(R.id.editbarcode);

    }




    @Override
    protected void onStart() {
        super.onStart();
        receiver = new Receiver();
        IntentFilter filter = new IntentFilter(ScannerHelper.ACTION_SCANNER_SEND_BARCODE);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(receiver!=null){
            unregisterReceiver(receiver);
        }
    }


    /**
     * 扫描获取条码
     *

     */
    public class Receiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub
            Context mContext = null;

            String barcode = intent.getExtras().getString("scannerdata");

            editbarcode.setText(barcode);

            Log.v("条码信息77777",barcode);



        }};
}