package me.yh.adapter.smart.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lyh on 2017/8/8.
 */

public class SViewHolder extends RecyclerView.ViewHolder {

    //持有view， view数据绑定

    private View itemView;

    public SViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public SViewHolder(Context context, View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public View getItemView() {
        return itemView;
    }


    public static SViewHolder createViewHolder(Context context, View itemView) {
        SViewHolder holder = new SViewHolder(context, itemView);
        return holder;
    }

    public static SViewHolder createViewHolder(Context context,
                                               ViewGroup parent, int layoutId) {
        View itemView = LayoutInflater.from(context).inflate(layoutId, parent,
                false);
        SViewHolder holder = new SViewHolder(context, itemView);
        return holder;
    }
}
