package com.yuan.headerfooterrecyclerview;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

import com.yuan.recycler.headerfooter.HeaderFooterRecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 10/12/2016.
 */

public class MainActivity extends Activity {

    private HeaderFooterRecyclerView mRecyclerView;

    private int[] attrs= new int[]{
            android.R.attr.selectableItemBackground
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (HeaderFooterRecyclerView) findViewById(R.id.recyclerView);

        TextView headerView = new TextView(this);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        headerView.setPadding(20, 100, 20, 100);
        headerView.setBackgroundColor(Color.parseColor("#EEEEEE"));
        headerView.setGravity(Gravity.CENTER);
        headerView.setLayoutParams(params);
        headerView.setText("HEADER");
        mRecyclerView.addHeaderView(headerView);

        TextView footerView = new TextView(this);
        params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        footerView.setBackgroundColor(Color.parseColor("#EEEEEE"));
        footerView.setPadding(20, 100, 20, 100);
        footerView.setGravity(Gravity.CENTER);
        footerView.setLayoutParams(params);
        footerView.setText("FOOTER");
        mRecyclerView.addFooterView(footerView);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("Item " + i);
        }

        TestAdapter adapter = new TestAdapter(list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(adapter);

        mRecyclerView.addOnItemTouchListener(new OnItemTouchListener(mRecyclerView) {
            @Override
            public void onItemClick(RecyclerView.ViewHolder vh) {
                // if you want to get the content real position, you must vh.getAdapterPosition()-mRecyclerView.getHeaderViewCount()
                Toast.makeText(MainActivity.this, "vh.getAdapterPosition():" + (vh.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(RecyclerView.ViewHolder vh) {
                Toast.makeText(MainActivity.this, "vh.getAdapterPosition():" + (vh.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });

    }

}
