package study.com.a57trans;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String ACTION_SEND_TEXT = "study.com.a57trans.intent.action.SEND_TEXT";
    private static final String KEY_TEXT = "KEY_TEXT";
    EditText mEditText;

    BroadcastReceiver mReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String string = intent.getStringExtra(KEY_TEXT);
            if(string!=null) {
                Toast.makeText(getBaseContext(), "onReceive = " + string, Toast.LENGTH_LONG).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = findViewById(R.id.editText);
        registerReceiver(mReceiver, new IntentFilter(ACTION_SEND_TEXT));
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
