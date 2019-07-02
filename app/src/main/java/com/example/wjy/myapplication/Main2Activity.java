package com.example.wjy.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ViewSwitcher;

public class Main2Activity extends AppCompatActivity {
    private String TAG = "Main2Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Log.d(TAG, "onCreate: ");
        //旋转
        ObjectAnimator animator = ObjectAnimator.ofFloat(findViewById(R.id.image_view),"rotation", 0, 360);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(8000);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.start();
        //呼吸缩放
        View imageView = findViewById(R.id.image_view);
        ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat(imageView,
                "scaleX", 1.1f, 0.9f);
        scaleXAnimator.setRepeatCount(ValueAnimator.INFINITE);
        scaleXAnimator.setInterpolator(new LinearInterpolator());
        scaleXAnimator.setDuration(1000);
        scaleXAnimator.setRepeatMode(ValueAnimator.REVERSE);
        ObjectAnimator scaleYAnimator = ObjectAnimator.ofFloat(imageView,
                "scaleY", 1.1f, 0.9f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(scaleXAnimator, scaleYAnimator);
        animatorSet.start();
        TabLayout tb = findViewById(R.id.tab_layout);
        ViewPager vp = findViewById(R.id.view_pager);
        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new BlankFragment();
            }

            @Override
            public int getCount() {
                return 4;
            }
        });
        tb.setupWithViewPager(vp);

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
