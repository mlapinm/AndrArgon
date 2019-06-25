package study.com.a34menulist;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ListActivity {
    TextView mTextView;
    String[] mStations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mStations = getResources().getStringArray(R.array.stations);
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.list_view, mStations);
        //setListAdapter(aa);
        ListView listView = getListView();
        listView.setAdapter(aa);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) menuInfo;
        TextView textView = (TextView)info.targetView;
        CharSequence stationSelected = textView.getText();
        menu.setHeaderTitle(stationSelected);
        menu.add(0, Menu.FIRST,Menu.NONE,"Punkt 1");
        menu.add(0, Menu.FIRST+1,Menu.NONE,"Punkt 2");
    }

}
