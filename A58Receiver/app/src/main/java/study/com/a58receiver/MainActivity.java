package study.com.a58receiver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String string = getIntent().getStringExtra(Receiver.KEY_TEXT);
        TextView textView = findViewById(R.id.textView);
        textView.setText(string);
    }
}
