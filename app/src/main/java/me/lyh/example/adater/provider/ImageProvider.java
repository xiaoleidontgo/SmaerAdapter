package me.lyh.example.adater.provider;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.lyh.example.adater.R;
import me.lyh.example.adater.bean.ImageContent;
import me.lyh.example.adater.bean.TitleContent;
import me.yh.adapter.smart.provider.IProvider;

/**
 * Created by lyh on 2017/8/18.
 */

public class ImageProvider implements IProvider<ImageContent> {
    @Override
    public int itemLayoutID() {
        return R.layout.item_image;
    }

    @Override
    public void onBindItemData(View view, ImageContent imageContent) {
        TextView textView = (TextView) view.findViewById(R.id.tv_title);
        textView.setText(imageContent.uploadUser);
        textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText(imageContent.imgUrl);
        textView = (TextView) view.findViewById(R.id.tv_timeline);
        textView.setText(imageContent.uplodTime);
    }


    @Override
    public void onClick(View view, int position, ImageContent imageContent) {
        Toast.makeText(view.getContext(), "ImageProvider onClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view, int position, ImageContent imageContent) {
        Toast.makeText(view.getContext(), "ImageProvider onLongClick", Toast.LENGTH_SHORT).show();
        return false;
    }
}
