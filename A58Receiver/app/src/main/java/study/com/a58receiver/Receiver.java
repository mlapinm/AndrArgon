package study.com.a58receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class Receiver extends BroadcastReceiver {

    public static final String KEY_TEXT = "KEY_TEXT";

    @Override
    public void onReceive(Context context, Intent intent) {
        String string = intent.getStringExtra(KEY_TEXT);
        if(string != null){
            Intent intent1 = new Intent(context, MainActivity.class);
            intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent1.putExtra(KEY_TEXT, string);
            context.startActivity(intent1);
        }

    }
}
