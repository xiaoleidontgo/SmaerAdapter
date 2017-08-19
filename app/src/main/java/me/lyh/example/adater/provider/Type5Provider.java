package me.lyh.example.adater.provider;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.lyh.example.adater.R;
import me.lyh.example.adater.bean.TypeExample2;
import me.yh.adapter.smart.provider.IProvider;

/**
 * Created by lyh on 2017/8/19.
 */

public class Type5Provider implements IProvider<TypeExample2> {

    @Override
    public int itemLayoutID() {
        return R.layout.item_type_e5;
    }

    @Override
    public void onBindItemData(View view, TypeExample2 typeExample2) {
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText(typeExample2.content);
    }

    @Override
    public void onClick(View view, int position, TypeExample2 typeExample2) {
        Toast.makeText(view.getContext(), "Type5Provider onClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view, int position, TypeExample2 typeExample2) {
        Toast.makeText(view.getContext(), "Type5Provider onLongClick", Toast.LENGTH_SHORT).show();
        return false;
    }
}
