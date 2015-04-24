package com.gxu.administrator.navigationfinally;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2015/4/24.
 */
public class firstFragment extends Fragment{
    private TextView tv_first;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.firstlayout, container, false);
        tv_first = (TextView) view.findViewById(R.id.tv_first);
        return view;
    }
}

