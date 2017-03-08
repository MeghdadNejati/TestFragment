package com.example.paitakht.testfragment.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paitakht.testfragment.R;

/**
 * Created by Fakher on 2/4/2017.
 */

public class ResultFragment extends Fragment {

    private static final String TAG = "sh_ResultFragment";
    public static final String PARAM_RESULT = "param:result";
    private int intResult;
    private TextView mTvResult;

    public ResultFragment() {
    }

    public static ResultFragment newInstance(int result) {
        ResultFragment rFrag = new ResultFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(PARAM_RESULT, result);
        rFrag.setArguments(bundle);
        return rFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            intResult = getArguments().getInt(PARAM_RESULT);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.result_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTvResult = (TextView) view.findViewById(R.id.tv_result);
        mTvResult.setText(intResult + "");
        super.onViewCreated(view, savedInstanceState);
    }

    public void setResult(String result) {
        Log.e(TAG, "setResult Called ... : " + result);
        mTvResult.setText(null);
        mTvResult.setText(result);
    }

}


