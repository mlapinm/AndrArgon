package study.com.b21fragm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyFragment extends Fragment {

    public static final String PARAMETER_1 = "parameter1";
    TextView textView2;

    public static MyFragment getInstance(String string){
        Bundle bundle;
        bundle = new Bundle();
        bundle.putString(PARAMETER_1, string);

        MyFragment fragment = new MyFragment();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Logger.logMe();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        Logger.logMe();

        textView2 = view.findViewById(R.id.textViewFragment2);
        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("parameter1")){
            String string = bundle.getString("parameter1");
            textView2.setText(string);
        }
        Log.d("happy", "onCreate fragment " + hashCode());

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Logger.logMe();
    }

    @Override
    public void onResume() {
        super.onResume();
        Logger.logMe();
    }

    @Override
    public void onPause() {
        super.onPause();
        Logger.logMe();
    }

    @Override
    public void onStop() {
        super.onStop();
        Logger.logMe();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Logger.logMe();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Logger.logMe();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Logger.logMe();
    }
}
