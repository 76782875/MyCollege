package com.cj.mycollege.announcement;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cj.mycollege.R;
import com.cj.mycollege.util.LogUtil;

import java.util.ArrayList;

/**
 * Created by Eason on 2016/4/8.
 */
public class AnnouncementAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String TAG = "AnnouncementAdapter";
    private ArrayList<String> mDataSource;
    private Context mContext;
    private LayoutInflater mInflater;

    public AnnouncementAdapter(Context context, ArrayList<String> dataList) {
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
        AnnouncementViewHolder holder = (AnnouncementViewHolder) viewHolder;

        if (position == 0) {
            holder.linearLayout.setVisibility(View.GONE);
            holder.imageView.setVisibility(View.VISIBLE);
        } else {
            holder.linearLayout.setVisibility(View.VISIBLE);
            holder.imageView.setVisibility(View.GONE);

            String item = mDataSource.get(position);
            if (item == null)
                return;

            LogUtil.i(TAG, "item: " + item);
            holder.titleTextView.setText(item);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        //初始化一次
        View view = mInflater.inflate(R.layout.announcement_item, viewgroup, false);
        AnnouncementViewHolder viewHolder = new AnnouncementViewHolder(view);
        viewHolder.setIsRecyclable(true);

        return viewHolder;
    }

    class AnnouncementViewHolder extends RecyclerView.ViewHolder {
        public LinearLayout linearLayout;
        public TextView titleTextView;
        public ImageView imageView;

        public AnnouncementViewHolder(View layout) {
            super(layout);
            titleTextView = (TextView) layout.findViewById(R.id.text_view_title);
            linearLayout = (LinearLayout) layout.findViewById(R.id.linearLayout_item);
            imageView = (ImageView) layout.findViewById(R.id.imageView_advise);

        }
    }
}
