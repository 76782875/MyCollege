package com.cj.mycollege.knownall;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cj.mycollege.R;

import java.util.ArrayList;

/**
 * Created by Eason on 2016/4/8.
 */
public class KnownAllAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final String TAG = "KnownAllAdapter";
    private ArrayList<String> mDataSource;
    private Context mContext;
    private LayoutInflater mInflater;
    int [] imgIds = {   //ImageView显示的图片数组
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_manage,
            R.drawable.ic_menu_send,
            R.drawable.ic_menu_share,
            R.drawable.ic_menu_slideshow,
            R.drawable.ic_menu_camera,
            R.drawable.ic_menu_gallery,
            R.drawable.ic_menu_manage,
            R.drawable.ic_menu_send,
            R.drawable.ic_menu_share,
            R.drawable.ic_menu_slideshow,
    };
    String [] titles = {"交通","校园示意图","常用电话","办事流程","银行","购物","景点","影院","KTV","美食","团购"};

    public KnownAllAdapter(Context context, ArrayList<String> dataList) {
        super();
        this.mContext = context;
        mInflater = LayoutInflater.from(mContext);
        this.mDataSource = dataList;

    }


    @Override
    public int getItemCount() {
//        return mDataSource.size();
        return titles.length<imgIds.length ? titles.length : imgIds.length;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, int position) {
        KnownAllViewHolder holder = (KnownAllViewHolder) viewHolder;

        holder.titleKnownAll.setText(titles[position]);
        holder.iconKnownAll.setImageResource(imgIds[position]);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        //初始化一次
        View view = mInflater.inflate(R.layout.known_all_item, viewgroup, false);
        KnownAllViewHolder viewHolder = new KnownAllViewHolder(view);
        viewHolder.setIsRecyclable(true);

        return viewHolder;
    }

    class KnownAllViewHolder extends RecyclerView.ViewHolder {

        public TextView titleKnownAll;
        public ImageView iconKnownAll;

        public KnownAllViewHolder(View layout) {
            super(layout);
            titleKnownAll = (TextView) layout.findViewById(R.id.title_knownAll);
            iconKnownAll = (ImageView) layout.findViewById(R.id.image_view_knownAll);
        }
    }
}
