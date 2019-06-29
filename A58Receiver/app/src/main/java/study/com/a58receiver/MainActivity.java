package study.com.a58receiver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String ACTION_SEND_TIMESTAMP =
            "study.com.a57trans.intent.action.SEND_TIMESTAMP";
           //study.com.a57trans.intent.action.SEND_TIMESTAMP
    public static final String KEY_TIMESTAMP = "KEY_TIMESTAMP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String string = getIntent().getStringExtra(Receiver.KEY_TEXT);
        TextView textView = findViewById(R.id.textView);
        textView.setText(string);
        Intent intent = new Intent(ACTION_SEND_TIMESTAMP);
        intent.putExtra(KEY_TIMESTAMP, System.currentTimeMillis());
        sendBroadcast(intent);
    }
}
