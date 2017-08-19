package me.lyh.example.adater.provider;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.lyh.example.adater.R;
import me.lyh.example.adater.bean.TitleContent;
import me.yh.adapter.smart.provider.IProvider;

/**
 * Created by lyh on 2017/8/18.
 */

public class TitleProvider implements IProvider<TitleContent> {
    @Override
    public int itemLayoutID() {
        return R.layout.item_title;
    }

    @Override
    public void onBindItemData(View view, TitleContent titleContent) {
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        textView.setText(titleContent.title);
        textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText(titleContent.Content);
        textView = (TextView) view.findViewById(R.id.tv_timeline);
        textView.setText(titleContent.dateLine);
    }

    @Override
    public void onClick(View view, int position, TitleContent titleContent) {
        Toast.makeText(view.getContext(), "TitleProvider onClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view, int position, TitleContent titleContent) {
        Toast.makeText(view.getContext(), "TitleProvider onLongClick", Toast.LENGTH_SHORT).show();
        return false;
    }
}
