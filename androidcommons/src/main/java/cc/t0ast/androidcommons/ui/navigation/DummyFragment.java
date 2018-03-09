package cc.t0ast.androidcommons.ui.navigation;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import htl.t0ast.androidcommons.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DummyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DummyFragment extends Fragment
{
    private static final String ARG_TEXT = "text";

    private String viewText;


    public DummyFragment()
    {
    }

    public static DummyFragment newInstance(String text)
    {
        DummyFragment fragment = new DummyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TEXT, text);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            this.viewText = getArguments().getString(ARG_TEXT, getString(R.string.app_name));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_dummy_page, container, false);
        ((TextView) view.findViewById(R.id.textView)).setText(this.viewText);
        return view;
    }
}
