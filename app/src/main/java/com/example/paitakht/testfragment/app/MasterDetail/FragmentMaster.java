package com.example.paitakht.testfragment.app.MasterDetail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.paitakht.testfragment.R;
import com.example.paitakht.testfragment.app.MasterDetail.Model.News;
import com.example.paitakht.testfragment.app.MasterDetail.Util.DataCenter;
import com.example.paitakht.testfragment.app.TestMasterDetail;

import java.util.List;

/**
 * Created by Fakher on 2/6/2017.
 */

public class FragmentMaster extends Fragment {

    private RecyclerView mRvItems;
    private TestMasterDetail.MasterFragmentCallback mCallback;

    public FragmentMaster() {
    }

    public void setCallback(TestMasterDetail.MasterFragmentCallback mCallBack){
        this.mCallback=mCallBack;
    }

    public static FragmentMaster newInstance(TestMasterDetail.MasterFragmentCallback callback) {
        FragmentMaster mFrag = new FragmentMaster();
        mFrag.setCallback(callback);
        return mFrag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_master, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mRvItems = (RecyclerView) view.findViewById(R.id.rv_master_items);
        mRvItems.setLayoutManager(new LinearLayoutManager(getContext()));
        DataAdapter mAdapter = new DataAdapter(DataCenter.getNews());
        mRvItems.setAdapter(mAdapter);
        super.onViewCreated(view, savedInstanceState);
    }





    private class DataAdapter extends RecyclerView.Adapter<DataAdapter.NewsViewHolder> {

        private List<News> mData;

        public DataAdapter(List<News> mData) {
            this.mData = mData;
        }

        @Override
        public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item_layout, parent, false);
            return new NewsViewHolder(view);
        }

        @Override
        public void onBindViewHolder(NewsViewHolder holder, int position) {
            holder.onBind(position);
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        public class NewsViewHolder extends RecyclerView.ViewHolder {

            public TextView mTvID;
            public TextView mTvTitle;
            public TextView mTvSummary;
            public View mView;


            public NewsViewHolder(View itemView) {
                super(itemView);
                mView = itemView;
                mTvID = (TextView) itemView.findViewById(R.id.tv_news_id);
                mTvTitle = (TextView) itemView.findViewById(R.id.tv_news_title);
                mTvSummary = (TextView) itemView.findViewById(R.id.tv_news_summary);
            }

            public void onBind(int position) {
                final News mNews = mData.get(position);
                mTvID.setText(mNews.getId() + "");
                mTvTitle.setText(mNews.getTitle());
                mTvSummary.setText(mNews.getSummary());
                mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mCallback != null) {
                            mCallback.onCall(mNews);
                        }
                    }
                });
            }
        }

    }

}
