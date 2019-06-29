package study.com.a57trans;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainActivity extends AppCompatActivity {

    static final String ACTION_SEND_TEXT =
            "study.com.a57trans.intent.action.SEND_TEXT";
    static final String ACTION_SEND_TIMESTAMP =
            "study.com.a57trans.intent.action.SEND_TIMESTAMP";
    private static final String KEY_TEXT = "KEY_TEXT";
    private static final String KEY_TIMESTAMP = "KEY_TIMESTAMP";
    EditText mEditText;
    TextView mTextView;

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            long time = intent.getLongExtra(KEY_TIMESTAMP, 0);
            if(time != 0) {
                String string = "";//
                SimpleDateFormat simpleDateFormat =
                        new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
                string = simpleDateFormat.format(time);
                mTextView.setText(string);
                Toast.makeText(getBaseContext(), "onReceive = " + string, Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText);
        mTextView = findViewById(R.id.textView);
        registerReceiver(mReceiver, new IntentFilter(ACTION_SEND_TIMESTAMP));
    }

    public void onClick(View view) {
        String string = mEditText.getText().toString().trim();
        mEditText.setText("");
        if(string.length()>0){
            Intent intent = new Intent(ACTION_SEND_TEXT);
            intent.putExtra(KEY_TEXT, string);
            sendBroadcast(intent);
        }

        Toast.makeText(this, "onClick = " + string, Toast.LENGTH_LONG).show();
    }
}
