package study.com.b23list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class DualPaneContaner extends LinearLayout implements PaneContaner {
    private DetailView detailView;

    public DualPaneContaner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        detailView = findViewById(R.id.detailView);
    }

    @Override
    public void showItem(String string) {
        detailView.showItem(string);
    }

}
