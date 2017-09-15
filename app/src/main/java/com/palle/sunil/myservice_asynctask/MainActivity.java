 package com.palle.sunil.myservice_asynctask;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
public static ProgressBar pb;
public static     TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pb= (ProgressBar) findViewById(R.id.progressbar1);
        tv1= (TextView) findViewById(R.id.textview1);
    }

    public void startService(View view) {


        Intent in=new Intent(MainActivity.this,MyService.class);
        startService(in);
    }
}
