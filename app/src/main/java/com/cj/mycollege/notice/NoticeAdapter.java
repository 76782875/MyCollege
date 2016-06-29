package com.cj.mycollege.notice;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cj.mycollege.R;
import com.cj.mycollege.util.LogUtil;

import java.util.ArrayList;

/**
 * Created by Eason on 2016/4/8.
 */
public class NoticeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String TAG = "NoticeAdapter";
    private ArrayList<String> mDataSource;
    private Context mContext;
    private LayoutInflater mInflater;

    public NoticeAdapter(Context context, ArrayList<String> dataList) {
        super();
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.mDataSource = dataList;

    }


    @Override
    public int getItemCount() {
        return mDataSource.size();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {
        NoticeViewHolder holder = (NoticeViewHolder) viewHolder;

        if(position % 4 ==0){
            holder.categoryImageView.setImageResource(R.drawable.ticket_xin);
            holder.descriptionTextView.setText(R.string.notice_description);
        }else if(position % 4 ==1){
            holder.categoryImageView.setImageResource(R.drawable.ticket_yellow);
            holder.descriptionTextView.setText(R.string.notice_description2);
        }else if(position % 4 ==2){
            holder.categoryImageView.setImageResource(R.drawable.ticket_blue);
            holder.descriptionTextView.setText(R.string.notice_description3);
        }else{
            holder.categoryImageView.setImageResource(R.drawable.ticket_xin);
            holder.descriptionTextView.setText(R.string.notice_description);
        }


        String item = mDataSource.get(position);
        if (item == null)
            return;

        LogUtil.i(TAG, "item: " + item);
        holder.itemTv.setText(item);

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        //初始化一次
        View view = mInflater.inflate(R.layout.notice_item_1, viewgroup, false);
        NoticeViewHolder viewHolder = new NoticeViewHolder(view);
        viewHolder.setIsRecyclable(true);

        return viewHolder;
    }

    class NoticeViewHolder extends RecyclerView.ViewHolder {

        public TextView itemTv;
        public TextView descriptionTextView;
        public ImageView categoryImageView;

        public NoticeViewHolder(View layout) {
            super(layout);
            itemTv = (TextView) layout.findViewById(R.id.text_view_title);
            descriptionTextView = (TextView) layout.findViewById(R.id.text_view_description);
            categoryImageView = (ImageView) layout.findViewById(R.id.image_view_category);
        }
    }
}
