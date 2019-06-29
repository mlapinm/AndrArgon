package study.com.b11notif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_TEXT = "KEY_TEXT";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEditText = findViewById(R.id.editText);
    }

    public void onClick(View view) {
        String string =
                mEditText.getText().toString();
        Intent intent = new Intent(view.getContext(), SecondActivity.class);
        intent.putExtra(KEY_TEXT, string);
        startActivity(intent);
    }
}
