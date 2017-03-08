package com.example.paitakht.testfragment.app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.paitakht.testfragment.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void handleFragmentAction(View view) {
        loadActivity(TestFragment.class);
    }

    public void handleMasterDetailAction(View view) {
        loadActivity(TestMasterDetail.class);
    }

    public void handleViewPagerAction(View view) {
        loadActivity(TestViewPager.class);
    }

    private void loadActivity(Class clz) {
        Intent mIntent = new Intent(this, clz);
        startActivity(mIntent);
    }

    public void handleTest9PatchAction(View view) {

    }
}
