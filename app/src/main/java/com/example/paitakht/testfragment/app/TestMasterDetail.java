package com.example.paitakht.testfragment.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.paitakht.testfragment.R;
import com.example.paitakht.testfragment.app.MasterDetail.FragmentDetails;
import com.example.paitakht.testfragment.app.MasterDetail.FragmentMaster;
import com.example.paitakht.testfragment.app.MasterDetail.Model.News;
import com.example.paitakht.testfragment.app.MasterDetail.Util.DataCenter;

public class TestMasterDetail extends AppCompatActivity {

    private static final String TAG = "sh_SAHER";

    public static final String MASTER_TAG = "tag:master_fragment";
    public static final String DETAIL_TAG = "tag:detail_fragment";

    private View masterFragmentView;
    private View detailsFragmentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_master_detail);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.master_fragment, FragmentMaster.newInstance(new MasterFragmentCallback() {
                    @Override
                    public void onCall(News mNews) {
                        Log.i(TAG, "-------------");
                        Log.i(TAG, "id : " + mNews.getId());
                        Log.i(TAG, "title : " + mNews.getTitle());
                        Log.i(TAG, "sumurry : " + mNews.getSummary());
                        Log.i(TAG, " ");
                        showDetailFragment(mNews.getId());
                    }
                }), MASTER_TAG)
                .commit();

//        .addToBackStack(MASTER_TAG)

        masterFragmentView = findViewById(R.id.master_fragment);
        detailsFragmentView = findViewById(R.id.detail_fragment);


    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed();
//
//        Log.i(TAG, "onBackPressed");
//        int count = getSupportFragmentManager().getBackStackEntryCount();
//        Log.i(TAG, "back stack count : " + count);
//
//        if (count == 1 || count == 0) {
//            getSupportFragmentManager().popBackStack();
//            super.onBackPressed();
//        } else if (count == 2) {
//            FragmentDetails dFrag = (FragmentDetails) getSupportFragmentManager().findFragmentByTag(DETAIL_TAG);
//
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .remove(dFrag)
//                    .commit();
//
//            getSupportFragmentManager().popBackStack();
//
//        }


        if (masterFragmentView.getVisibility() != View.VISIBLE &&
                detailsFragmentView.getVisibility() == View.VISIBLE) {
            detailsFragmentView.setVisibility(View.INVISIBLE);
            masterFragmentView.setVisibility(View.VISIBLE);
        } else {
            super.onBackPressed();
        }


    }

    public void handleBtnGetOneNewsAction(View view) {
        News mNews = DataCenter.getNews(7);
        Log.i(TAG, "-------------");
        Log.i(TAG, "id : " + mNews.getId());
        Log.i(TAG, "title : " + mNews.getTitle());
        Log.i(TAG, "sumurry : " + mNews.getSummary());
        Log.i(TAG, " ");

        showDetailFragment(7);
    }

    private void showDetailFragment(int newsId) {

        if (detailsFragmentView.getVisibility() == View.INVISIBLE) {
            masterFragmentView.setVisibility(View.INVISIBLE);
            detailsFragmentView.setVisibility(View.VISIBLE);
        }

        getSupportFragmentManager()
            .beginTransaction()
            .add(R.id.detail_fragment, FragmentDetails.newInstance(newsId), DETAIL_TAG)
            .commit();

//        .addToBackStack(DETAIL_TAG)
    }

    public interface MasterFragmentCallback {
        void onCall(News mNews);
    }

}
