package me.yh.adapter.smart;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.yh.adapter.smart.bean.Footer;
import me.yh.adapter.smart.bean.Header;
import me.yh.adapter.smart.container.Container;
import me.yh.adapter.smart.provider.IProvider;
import me.yh.adapter.smart.type.TypeJudgment;
import me.yh.adapter.smart.viewholder.SViewHolder;

/**
 * Created by lyh on 2017/8/8.
 */

public class SmartAdapter extends RecyclerView.Adapter<SViewHolder> {

    protected List<Object> mDatas = new ArrayList<>();
    protected Container itemTypeContainer;

    public SmartAdapter(List<Object> data, Container itemTypeContainer) {

        this.itemTypeContainer = itemTypeContainer;

        //Header
        int headerCount = itemTypeContainer.getHeaderCount();
        if (headerCount != 0) {
            for (int i = 0; i < headerCount; i++) {
                Header<String> header = new Header<>();
                header.headerIndex = i;
                mDatas.add(header);
            }
        }

        //Items
        mDatas.addAll(data);

        //Footer
        int footerCount = itemTypeContainer.getFooterCount();
        if (footerCount != 0) {
            for (int i = 0; i < footerCount; i++) {
                Footer<String> footer = new Footer<>();
                footer.footerIndex = i;
                mDatas.add(footer);
            }
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position) == null) {
            throw new NullPointerException("the data for item can't be null!");
        }

        IProvider itemProvider = getProviderByPosition(position);

        if (itemProvider == null) {
            throw new NullPointerException("item of key:" + keyOfPosition(position) + ",provider is null ! is you register a null provider?");
        }

        //条目LayoutID作为类型ID
        int itemType = itemProvider.itemLayoutID();
        if (itemType != -1) {
            return itemType;
        }
        return super.getItemViewType(position);
    }

    @Override
    public SViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //其实viewType就是条目的layoutID,这里只是作为逻辑演示
        IProvider provider = itemTypeContainer.getItemProvider(viewType);
        int layoutID = provider.itemLayoutID();
        SViewHolder sViewHolder = SViewHolder.createViewHolder(parent.getContext(), parent, layoutID);
        setListener(parent, sViewHolder, viewType, provider);
        return sViewHolder;
    }

    @Override
    public void onBindViewHolder(SViewHolder holder, int position) {
        IProvider itemProvider = getProviderByPosition(position);
        itemProvider.onBindItemData(holder.getItemView(), mDatas.get(position));
    }


    /**
     * 获取列表数据集
     *
     * @return
     */
    public List<Object> getDatas() {
        return mDatas;
    }

    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    protected void setListener(final ViewGroup parent, final SViewHolder viewHolder, int viewType, final IProvider provider) {
//        if (!isEnabled(viewType)) return;
        viewHolder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                provider.onClick(v, position, mDatas.get(position));
            }
        });

        viewHolder.getItemView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                int position = viewHolder.getAdapterPosition();
                return provider.onLongClick(v, position, mDatas.get(position));
            }
        });
    }


    /**
     * 根据position 获取IProvider
     */
    private IProvider getProviderByPosition(int position) {
        Object itemData = mDatas.get(position);

        String key = itemData.getClass().getSimpleName();
        if (itemData instanceof Header) {
            key = itemData.getClass().getSimpleName() + ((Header) itemData).headerIndex;
        } else if (itemData instanceof Footer) {
            key = itemData.getClass().getSimpleName() + ((Footer) itemData).footerIndex;
        }

        IProvider itemProvider = itemTypeContainer.getItemProvider(key);
        if (itemProvider == null) {
            TypeJudgment typeJudgment =
                    itemTypeContainer.getTypeJudgment(mDatas.get(position).getClass());
            if (typeJudgment == null) {
                throw new IllegalArgumentException("key :" + mDatas.get(position).getClass().getSimpleName()
                        + " is not provider , do you register ?");
            }
            itemProvider = typeJudgment.onJudge(mDatas.get(position));
            itemTypeContainer.putItemType(mDatas.get(position).getClass().getSimpleName() + itemProvider.itemLayoutID(), itemProvider);
        }
        return itemProvider;
    }

    /**
     * 根据position获取此条目的类型key
     *
     * @param position
     * @return
     */
    private String keyOfPosition(int position) {
        Object itemData = mDatas.get(position);

        String key = itemData.getClass().getSimpleName();
        if (itemData instanceof Header) {
            key = itemData.getClass().getSimpleName() + ((Header) itemData).headerIndex;
        } else if (itemData instanceof Footer) {
            key = itemData.getClass().getSimpleName() + ((Footer) itemData).footerIndex;
        }
        IProvider itemProvider = itemTypeContainer.getItemProvider(key);
        if (itemProvider == null) {
            TypeJudgment typeJudgment =
                    itemTypeContainer.getTypeJudgment(mDatas.get(position).getClass());
            if (typeJudgment == null) {
                throw new IllegalArgumentException("key :" + mDatas.get(position).getClass().getSimpleName()
                        + " is not provider , do you register ?");
            }
            key = mDatas.get(position).getClass().getSimpleName() + itemProvider.itemLayoutID();
        }
        return key;
    }
}
