package me.lyh.example.adater.provider;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import me.lyh.example.adater.R;
import me.lyh.example.adater.bean.TypeExample1;
import me.yh.adapter.smart.provider.IProvider;

/**
 * Created by lyh on 2017/8/19.
 */

public class Type2Provider implements IProvider<TypeExample1> {
    @Override
    public int itemLayoutID() {
        return R.layout.item_type_e2;
    }

    @Override
    public void onBindItemData(View view, TypeExample1 typeExample1) {
        TextView textView = (TextView) view.findViewById(R.id.tv_content);
        textView.setText(typeExample1.content);
    }

    @Override
    public void onClick(View view, int position, TypeExample1 typeExample1) {
        Toast.makeText(view.getContext(), "Type2Provider onClick", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onLongClick(View view, int position, TypeExample1 typeExample1) {
        Toast.makeText(view.getContext(), "Type2Provider onLongClick", Toast.LENGTH_SHORT).show();
        return false;
    }
}
