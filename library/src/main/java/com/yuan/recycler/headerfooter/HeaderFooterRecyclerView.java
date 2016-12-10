package com.yuan.recycler.headerfooter;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by yuan on 10/12/2016.
 */

public class HeaderFooterRecyclerView extends RecyclerView {
    private ArrayList<View> mHeaderViewInfos = new ArrayList<View>();

    private ArrayList<View> mFooterViewInfos = new ArrayList<View>();

    private Adapter mAdapter;

    public HeaderFooterRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void addHeaderView(View v) {
        mHeaderViewInfos.add(v);

        // Wrap the adapter if it wasn't already wrapped.
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeaderFooterRecyclerAdapter)) {
                mAdapter = new HeaderFooterRecyclerAdapter(mHeaderViewInfos, mFooterViewInfos, mAdapter);
            }
        }
    }

    public void addFooterView(View v) {
        mFooterViewInfos.add(v);

        // Wrap the adapter if it wasn't already wrapped.
        if (mAdapter != null) {
            if (!(mAdapter instanceof HeaderFooterRecyclerAdapter)) {
                mAdapter = new HeaderFooterRecyclerAdapter(mHeaderViewInfos, mFooterViewInfos, mAdapter);
            }
        }
    }

    public int getHeaderViewCount() {
        return mHeaderViewInfos.size();
    }


    public int getFooterViewCount() {
        return mFooterViewInfos.size();
    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (mHeaderViewInfos.size() > 0 || mFooterViewInfos.size() > 0) {
            mAdapter = new HeaderFooterRecyclerAdapter(mHeaderViewInfos, mFooterViewInfos, adapter);
        } else {
            mAdapter = adapter;
        }
        super.setAdapter(mAdapter);
    }

}
