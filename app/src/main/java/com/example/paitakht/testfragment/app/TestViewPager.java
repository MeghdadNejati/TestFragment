package com.example.paitakht.testfragment.app;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.paitakht.testfragment.R;
import com.example.paitakht.testfragment.app.ViewPager.BaseFragment;
import com.example.paitakht.testfragment.app.ViewPager.OneFragment;
import com.example.paitakht.testfragment.app.ViewPager.SampleFragment;
import com.example.paitakht.testfragment.app.ViewPager.ThreeFragment;
import com.example.paitakht.testfragment.app.ViewPager.TwoFragment;

import java.util.ArrayList;
import java.util.List;

public class TestViewPager extends AppCompatActivity {

    private static final String TAG = "sh_TestViewPager";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_view_pager);

        TabLayout mTabLayout = (TabLayout) findViewById(R.id.tl_vp_home);
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.vp_home);

        final List<ViewPagerDataModel> dataList = new ArrayList<>();
        dataList.add(new ViewPagerDataModel(SampleFragment.newInstance("Frag 1"), "Frag 1 Title"));
        dataList.add(new ViewPagerDataModel(SampleFragment.newInstance("Frag 2"), "Frag 2 Title"));
        dataList.add(new ViewPagerDataModel(SampleFragment.newInstance("Frag 3"), "Frag 3 Title"));
        dataList.add(new ViewPagerDataModel(SampleFragment.newInstance("Frag 4"), "Frag 4 Title"));
        dataList.add(new ViewPagerDataModel(SampleFragment.newInstance("Frag 5"), "Frag 5 Title"));
        dataList.add(new ViewPagerDataModel(SampleFragment.newInstance("Frag 6"), "Frag 6 Title"));
        dataList.add(new ViewPagerDataModel(SampleFragment.newInstance("Frag 7"), "Frag 7 Title"));
//
//        dataList.add(new ViewPagerDataModel(OneFragment.newInstance("Frag 1"), "Frag 1"));
//        dataList.add(new ViewPagerDataModel(TwoFragment.newInstance("Frag 2"), "Frag 2"));
//        dataList.add(new ViewPagerDataModel(ThreeFragment.newInstance("Frag 3"), "Frag 3"));

        final ViewPagerAdapter mAdapter = new ViewPagerAdapter(getSupportFragmentManager(), dataList);

        mViewPager.setOffscreenPageLimit(6);
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Log.i(TAG, "Page ( " + mAdapter.getPageTitle(position) + " ) was Selected ...");
//                ((SampleFragment)mAdapter.getItem(position)).refresh();
//                ((BaseFragment) mAdapter.getItem(position)).refresh();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mTabLayout.setupWithViewPager(mViewPager);


        // region Handle Manually Change Page :
        Button btnGotoPage = (Button) findViewById(R.id.btn_select_page);
        final EditText etPageNumber = (EditText) findViewById(R.id.et_page_num);


        btnGotoPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etPageNumber.getText())) {
                    int pageNum = Integer.valueOf(etPageNumber.getText().toString().trim());
                    Log.i(TAG, "index = " + pageNum);

                    if (pageNum < 0 || pageNum > dataList.size()-1) {
                        Log.e(TAG, "Index Out Of Bounds Error ...");
                    } else {
                        mViewPager.setCurrentItem(pageNum, true);
                    }
                }
            }
        });
        // endregion

    }



    public class ViewPagerAdapter extends FragmentStatePagerAdapter {

        private List<ViewPagerDataModel> mDataList;

        public ViewPagerAdapter(FragmentManager fm, List<ViewPagerDataModel> dataList) {
            super(fm);
            this.mDataList = dataList;
        }

        @Override
        public Fragment getItem(int position) {
            return mDataList.get(position).getFragment();
        }

        @Override
        public int getCount() {
            return mDataList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mDataList.get(position).getTitle();
        }

        public ViewPagerDataModel getDataModel(int position) {
            return mDataList.get(position);
        }

    }

    public class ViewPagerDataModel {

        Fragment fragment;
        String title;

        public ViewPagerDataModel(Fragment fragment, String title) {
            this.fragment = fragment;
            this.title = title;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public void setFragment(Fragment fragment) {
            this.fragment = fragment;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

}
