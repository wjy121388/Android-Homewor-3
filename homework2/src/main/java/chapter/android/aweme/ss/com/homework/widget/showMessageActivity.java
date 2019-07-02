package chapter.android.aweme.ss.com.homework.widget;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import chapter.android.aweme.ss.com.homework.R;

public class showMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_message);
        Button bt = findViewById(R.id.bt1);
        final String msg = getIntent().getStringExtra("buttonName");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(showMessageActivity.this, msg, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
