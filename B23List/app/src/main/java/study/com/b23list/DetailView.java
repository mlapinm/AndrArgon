package study.com.b23list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DetailView extends LinearLayout {


    private TextView itemView;

    public DetailView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        itemView = findViewById(R.id.info);

    }

    public void showItem(String string){
        itemView.setText(string);
    }
}
