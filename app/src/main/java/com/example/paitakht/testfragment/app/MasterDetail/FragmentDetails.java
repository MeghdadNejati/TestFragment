package com.example.paitakht.testfragment.app.MasterDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paitakht.testfragment.R;
import com.example.paitakht.testfragment.app.MasterDetail.Model.News;
import com.example.paitakht.testfragment.app.MasterDetail.Util.DataCenter;

/**
 * Created by Fakher on 2/6/2017.
 */

public class FragmentDetails extends Fragment {

    private static final String TAG = "sh_SAHER";

    public static final String PARAM_NEWS_ID = "param:news_id";
    private int newsID;

    private TextView mTvID, mTvTitle, mTvSummary, mTvContent;

    public FragmentDetails() {
    }

    public static FragmentDetails newInstance(int newsID) {
        FragmentDetails dFrag = new FragmentDetails();
        Bundle mBundle = new Bundle();
        mBundle.putInt(PARAM_NEWS_ID, newsID);
        dFrag.setArguments(mBundle);

        return dFrag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            newsID = getArguments().getInt(PARAM_NEWS_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mTvID = (TextView) view.findViewById(R.id.tv_news_id);
        mTvTitle = (TextView) view.findViewById(R.id.tv_news_title);
        mTvSummary = (TextView) view.findViewById(R.id.tv_news_summary);
        mTvContent = (TextView) view.findViewById(R.id.tv_news_content);

       // Log.i(TAG, "received news id : " + newsID);

        News mNews = DataCenter.getNews(newsID);

        mTvID.setText(mNews.getId()+"");
        mTvTitle.setText(mNews.getTitle());
        mTvSummary.setText(mNews.getSummary());
        mTvContent.setText(mNews.getContent());

        super.onViewCreated(view, savedInstanceState);
    }

}
