package com.example.administrator.fixdemo;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.lhh.ptrrv.library.PullToRefreshRecyclerView;

public class MainActivity extends AppCompatActivity {

    private static final int DEFAULT_ITEM_SIZE = 60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PullToRefreshRecyclerView  mPtrrv = (PullToRefreshRecyclerView) this.findViewById(R.id.ptrrv);
        mPtrrv.setSwipeEnable(true);//open swipe
        mPtrrv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        mPtrrv.setPagingableListener(new PullToRefreshRecyclerView.PagingableListener() {
            @Override
            public void onLoadMoreItems() {
            }
        });
        mPtrrv.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
            }
        });
        PtrrvAdapter   mAdapter = new PtrrvAdapter(this);
//        mAdapter.setCount(DEFAULT_ITEM_SIZE);
        mPtrrv.setAdapter(mAdapter);
        mPtrrv.onFinishLoading(true, false);

    }
    private class PtrrvAdapter extends PtrrvBaseAdapter<PtrrvAdapter.ViewHolder> {
        public PtrrvAdapter(Context context) {
            super(context);
        }


        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = mInflater.inflate(R.layout.ptrrv_item, null);
            return new ViewHolder(view);
        }


        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {

        }

        class ViewHolder extends RecyclerView.ViewHolder{

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }
    }
}
