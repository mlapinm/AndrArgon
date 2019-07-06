package study.com.b21fragm;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frameLayout = findViewById(R.id.frameLayout);
        Logger.logMe();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(frameLayout.getChildCount() == 0) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentTransaction = fragmentManager.beginTransaction();

            MyFragment fragment = MyFragment.getInstance("qqq  "
                + hashCode());
            fragmentTransaction.add(R.id.frameLayout, fragment);

            fragmentTransaction.commit();
        }else{
            Log.d("happy"," " + frameLayout.getChildCount()
                    + " don't insert fragment");
        }
        Logger.logMe();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Logger.logMe();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Logger.logMe();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Logger.logMe();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.logMe();
    }
}
