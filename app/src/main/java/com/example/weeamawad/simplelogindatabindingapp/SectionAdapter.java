package com.example.weeamawad.simplelogindatabindingapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.weeamawad.simplelogindatabindingapp.model.Item;

import java.util.List;

/**
 * Created by Weeam Awad on 5/7/2018.
 */

public class SectionAdapter extends RecyclerView.Adapter {
    private static final int HEADER = 0;
    private static final int OTHER = 1;
    List<Item> mItemlist;

    public SectionAdapter(List<Item> itemList) {
        mItemlist = itemList;
    }

    public class HeaderViewHolder extends RecyclerView.ViewHolder {
        public TextView headerTextView;

        public HeaderViewHolder(View view) {
            super(view);
            headerTextView = view.findViewById(R.id.rv_list_item_header);
        }
    }

    public class OtherViewHolder extends RecyclerView.ViewHolder {
        public TextView otherTextView;

        public OtherViewHolder(View view) {
            super(view);
            otherTextView = view.findViewById(R.id.rv_list_item_other);
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        switch (viewType) {
            case HEADER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_header, parent, false);
                return new HeaderViewHolder(view);
            case OTHER:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_other, parent, false);
                return new OtherViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case HEADER:
                HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
                headerViewHolder.headerTextView.setText(mItemlist.get(position).getType().name());
                break;
            case OTHER:
                OtherViewHolder otherViewHolder = (OtherViewHolder) holder;
                otherViewHolder.otherTextView.setText(mItemlist.get(position).getLabel());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItemlist.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == HEADER) {
            return HEADER;
        } else {
            return OTHER;
        }
    }
}
