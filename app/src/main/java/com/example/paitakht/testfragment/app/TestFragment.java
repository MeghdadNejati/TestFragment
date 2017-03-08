package com.example.paitakht.testfragment.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.paitakht.testfragment.app.Fragment.ResultFragment;
import com.example.paitakht.testfragment.app.Fragment.SingleFragment;
import com.example.paitakht.testfragment.R;

public class TestFragment extends AppCompatActivity {

    private static final String TAG = "sh_SAHER";
    public static final String TAG_SINGLE_FRAGMENT = "single_fragment";
    public static final String TAG_RESULT_FRAGMENT = "result_fragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_fragment);

        SingleFragment sFrag = SingleFragment.newInstance("Meghdad", new FragmentCallback() {
            @Override
            public void onCall(String str) {
                Log.e(TAG, "Message from Single Fragment : " + str);
                addResultToResultFragment(str);
            }
        });
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_single_container, sFrag, TAG_SINGLE_FRAGMENT)
                .commit();

        ResultFragment rFrag = ResultFragment.newInstance(15);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_result_container, rFrag, TAG_RESULT_FRAGMENT)
                .commit();

    }


    private void addResultToResultFragment(String result) {
        ResultFragment rFrag = (ResultFragment) getSupportFragmentManager().findFragmentByTag(TAG_RESULT_FRAGMENT);
        if (rFrag != null) {
            Log.e(TAG, "rFrag is Not Null ");
            rFrag.setResult(result);
        }
    }

    public void handleCallMethodCklick(View view) {
        Log.e(TAG, "handleCallMethodCklick");
        addResultToResultFragment("Meghdad is my sun ...");
    }


    public interface FragmentCallback {
        void onCall(String str);
    }

}
