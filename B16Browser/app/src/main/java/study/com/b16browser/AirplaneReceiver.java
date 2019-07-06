package study.com.b16browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AirplaneReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent != null){
            if(intent.getBooleanExtra("state",false)){
                Log.d("happy", "onReceive true");
            }else {
                Log.d("happy", "onReceive false");
            }
        }
    }
}
