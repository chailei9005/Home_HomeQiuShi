package chailei.com.homeqiushi.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import chailei.com.homeqiushi.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    public static final String TEXT = "text";
    public BlankFragment() {
        // Required empty public constructor
    }

    public static BlankFragment newInstance(String string) {

        Bundle args = new Bundle();

        BlankFragment fragment = new BlankFragment();
        args.putString(TEXT,string);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        TextView textView = (TextView) view.findViewById(R.id.txt);
        textView.setText(getArguments().getString(TEXT));
        super.onViewCreated(view, savedInstanceState);
    }
}
