package study.com.a33menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView)findViewById(R.id.textView1);
        registerForContextMenu(mTextView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Context menu");
        menu.add(0, Menu.FIRST,Menu.NONE,"Punkt1");
        menu.add(0, Menu.FIRST+1,Menu.NONE,"Punkt2");
        menu.add(0, Menu.FIRST+2,Menu.NONE,"Punkt3");
        menu.add(0, Menu.FIRST+3,Menu.NONE,"Punkt4");
        Log.e("onCreateContextMenu", menuInfo.toString());
    }
}
