package chapter.android.aweme.ss.com.homework.widget;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import chapter.android.aweme.ss.com.homework.R;

public class chatroomActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatroom);
        final String msg = getIntent().getStringExtra("itemNum");
        Toast.makeText(this,"打开了第"+msg+"个item", Toast.LENGTH_LONG).show();

    }
}
