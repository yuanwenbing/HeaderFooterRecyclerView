package com.yuan.headerfooterrecyclerview;

import java.util.List;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yuan on 10/12/2016.
 */

public class TestAdapter extends Adapter<TestAdapter.ViewHolder> {
	private List<String> list;

	public TestAdapter(List<String> list) {
		this.list = list;
	}

	
	public class ViewHolder extends RecyclerView.ViewHolder{

		public TextView tv;
		public ViewHolder(View view) {
			super(view);
			tv = (TextView) view.findViewById(R.id.tv);
		}
		
	}

	@Override
	public int getItemCount() {
		return list.size();
	}

	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		holder.tv.setText(list.get(position));
	}

	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
		View view = layoutInflater.inflate(R.layout.listitem, parent, false);
		return new ViewHolder(view);
	}
}
