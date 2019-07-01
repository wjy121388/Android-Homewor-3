package chapter.android.aweme.ss.com.homework;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.LinkedList;

/**
 * 作业2：一个抖音笔试题：统计页面所有view的个数
 * Tips：ViewGroup有两个API
 * {@link android.view.ViewGroup #getChildAt(int) #getChildCount()}
 * 用一个TextView展示出来
 */
public class Exercises2 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise2);
        Toast.makeText(this, String.valueOf(getViewCount(Exercises2.this.getWindow().getDecorView())), Toast.LENGTH_SHORT).show();
    }

    public static int getViewCount(View view) {
        //todo 补全你的代码
        int count = 0;
        if(view == null) {
            return count;
        }
        else if(view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            LinkedList<ViewGroup> linkedList = new LinkedList<>();
            linkedList.add(viewGroup);
            while(!linkedList.isEmpty()) {
                ViewGroup current = linkedList.removeFirst();
                for(int i = 0; i < current.getChildCount(); i ++) {
                    if(current.getChildAt(i) instanceof ViewGroup) {
                        linkedList.addLast((ViewGroup) current.getChildAt(i));
                    }else {
                        count = count + 1;
                    }
                }
            }
        }
        return count;
    }
}
