package com.example.wjy.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class Main2Activity extends AppCompatActivity {
    private String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: ");

    }

    @Override protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }
    @Override protected void onStop(){
        super.onStop();
        Log.d(TAG, "onStop: ");
    }
    @Override protected void onStart(){
        super.onStart();
        Log.d(TAG, "onStart: ");
    }
    @Override protected void onPause(){
        super.onPause();
        Log.d(TAG, "onPause: ");
    }
    @Override protected void onResume(){
        super.onResume();
        Log.d(TAG, "onResume: ");
    }
    @Override protected void onRestart(){
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
}
