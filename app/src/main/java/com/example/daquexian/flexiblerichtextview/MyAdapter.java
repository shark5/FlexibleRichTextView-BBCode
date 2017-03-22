package com.example.daquexian.flexiblerichtextview;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.daquexian.flexiblerichtextview.FlexibleRichTextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by panj on 2017/3/20.
 */

public class MyAdapter extends BaseAdapter {
    public List<String> mDatas = new ArrayList<>();

    public void setData(List<String> datas){
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(parent.getContext(), R.layout.item_list_flex_text, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.bindView(mDatas.get(position));
        return convertView;
    }

    public static class ViewHolder {
        FlexibleRichTextView mText;

        public ViewHolder(View view) {
            mText = (FlexibleRichTextView) view.findViewById(R.id.frtv);
        }

        public void bindView(String text) {
            mText.setText(text, null);
        }
    }
}
