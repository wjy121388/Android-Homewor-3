package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class PlaceholderFragment extends Fragment {

    private String[] data = {"item1","item2","item3","item4","item5","item6","item7","item8","item9"};
    private LottieAnimationView loading_view;
    private ListView listView;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_placeholder, container, false);
        loading_view = view.findViewById(R.id.loading_view);
        loading_view.playAnimation();
        listView = view.findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (Objects.requireNonNull(getContext()), android.R.layout.simple_expandable_list_item_1, data);
        listView.setAdapter(adapter);
        listView.setVisibility(View.INVISIBLE);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Objects.requireNonNull(getView()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                listView.setVisibility(View.VISIBLE);
                listView.setAlpha(0f);

                ObjectAnimator animator1 = ObjectAnimator.ofFloat(loading_view,
                        "alpha", 1.0f,0f);
                animator1.setDuration(500);
//                animator1.setRepeatCount(0);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(listView,
                        "alpha", 0f,1.0f);
                animator2.setDuration(500);
//                animator2.setRepeatCount(0);
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playSequentially(animator1,animator2);
                animatorSet.start();
                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        loading_view.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });

            }
        }, 5000);
    }
}
