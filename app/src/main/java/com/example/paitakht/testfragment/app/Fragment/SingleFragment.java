package com.example.paitakht.testfragment.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.paitakht.testfragment.R;
import com.example.paitakht.testfragment.app.TestFragment;

/**
 * Created by Fakher on 2/3/2017.
 */

// Fragments have Life cycle like Activities ... (onResume, onPause and etc ...)

public class SingleFragment extends Fragment implements View.OnClickListener {

    private static final String TAG  = "sh_SingleFragment";

    public static final String PARAM_TEXT = "param:text";
    private String strText;

    private TextView mTvTitle;
    private Button mBtnCallback;
    private EditText mEtMessage;

    // Listener interface that we used in Fragment ...
    private TestFragment.FragmentCallback mCallback;

    public SingleFragment() {
    }

    public static SingleFragment newInstance(String text, TestFragment.FragmentCallback callback) {
        SingleFragment fragment = new SingleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PARAM_TEXT, text);
        fragment.setArguments(bundle);
        fragment.setCallback(callback);
        return fragment;
    }

    private void setCallback(TestFragment.FragmentCallback callback) {
        this.mCallback = callback;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            strText = getArguments().getString(PARAM_TEXT);
        }
    }

    /**
     * create view layout of Fragment ...
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.single_fragment, container, false);
    }

    /**
     * make refrence to your view's and use them in your functionality ...
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTvTitle = (TextView) view.findViewById(R.id.tv_frag_title);
        mTvTitle.setText(strText);
        mBtnCallback = (Button) view.findViewById(R.id.btn_callback);
        mBtnCallback.setOnClickListener(this);
        mEtMessage = (EditText) view.findViewById(R.id.et_content);
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public void onClick(View v) {
        Log.i(TAG, "onClick");
        int id = v.getId();
        if (id == R.id.btn_callback) {
            if (mCallback != null) {
                String msg = mEtMessage.getText().toString().trim();
                if (!TextUtils.isEmpty(msg)) {
                    mCallback.onCall(msg);
                    mEtMessage.setText(null);
                }
            }
        }
    }
}
