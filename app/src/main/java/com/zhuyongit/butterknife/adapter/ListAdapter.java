package com.zhuyongit.butterknife.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.zhuyongit.butterknife.R;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Created by zhuyong < zhuyongit@163.com > on 2015/6/14.
 *
 * 列表图
 */
public class ListAdapter extends BaseAdapter {

    private List<String> mList ;
    private LayoutInflater mLayoutInflater ;
    private Context mContext ;

    public ListAdapter(Context context , List<String> list) {
        this.mContext = context ;
        this.mList = list ;
        this.mLayoutInflater = LayoutInflater.from(context) ;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null ;
        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item,null) ;
            viewHolder = new ViewHolder(convertView) ;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        final String titleName = mList.get(position) ;
        viewHolder.tvTitleName.setText(titleName);
        viewHolder.btnClickName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "我的名字叫==="+titleName, Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    public class ViewHolder {
        @InjectView(R.id.tvTitleName)
        TextView tvTitleName ;
        @InjectView(R.id.btnClickName)
        Button btnClickName ;

        public ViewHolder(View view) {
            ButterKnife.inject(this,view);
        }
    }
}
