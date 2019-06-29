package study.com.b11notif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mTextView = findViewById(R.id.textView);
        Intent intent = getIntent();
        String string =
                intent.getStringExtra("KEY_TEXT");
        if(string != null){
            mTextView.setText(string);
        }
    }
}
