package study.com.b23list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class SinglePaneContainer extends FrameLayout implements PaneContaner {
    private View listView;

    public SinglePaneContainer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        listView = getChildAt(0);
    }

    @Override
    public void showItem(String string) {
        if(isListAttached()) {
            removeViewAt(0);
            View.inflate(getContext(), R.layout.detail_layout, this);
        }
        DetailView detailView = (DetailView)getChildAt(0);
        detailView.showItem(string);
    }

    @Override
    public boolean onBackPressed() {
        if(isListAttached())
            return false;
        removeViewAt(0);
        addView(listView);
        return true;
    }

    private boolean isListAttached(){
        return listView.getParent() != null;
    }
}
