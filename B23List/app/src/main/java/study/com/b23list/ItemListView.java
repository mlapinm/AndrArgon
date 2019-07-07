package study.com.b23list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

//import javax.swing.text.html.ListView;

public class ItemListView extends ListView {


    private ItemListAdapter adaptor;

    public ItemListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        adaptor = new ItemListAdapter(getContext());
        setAdapter(adaptor);

        setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String string = adaptor.getItem(position);
                MainActivity activity = (MainActivity) getContext();
                PaneContaner paneContaner = activity.getMainActivity();
                paneContaner.showItem(string);
            }
        });
    }
}
