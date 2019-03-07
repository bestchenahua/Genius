package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.CollectionCommodityModel;
import cqdz.com.genius.home.wode.model.CollectionShopModel;
import cqdz.com.genius.utils.ImageLoader;

public class CollectionCommodityAdapter extends BaseQuickAdapter<CollectionCommodityModel.Response.Data,BaseViewHolder> {
    public CollectionCommodityAdapter(int layoutResId, @Nullable List<CollectionCommodityModel.Response.Data> data) {
        super(layoutResId, data);
    }
    private OnDeleteClickLister mDeleteClickListener;
    @Override
    protected void convert(BaseViewHolder helper, CollectionCommodityModel.Response.Data item) {
        View view = helper.getView(R.id.tv_delete);
        if (!view.hasOnClickListeners()) {
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mDeleteClickListener != null) {
                        mDeleteClickListener.onDeleteClick(v, helper.getAdapterPosition());
                    }
                }
            });
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv_img = helper.getView(R.id.iv_img);
            ImageLoader.load(mContext,iv_img,item.getImg(),4f);

        }
        if(!TextUtils.isEmpty(item.getTitle()))
        {
          helper.setText(R.id.tv_title,item.getTitle());
        }
        if(!TextUtils.isEmpty(item.getColloction()))
        {
            helper.setText(R.id.tv_collection,item.getColloction());
        }
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.tv_price,item.getPrice());
        }
    }
    public void setOnDeleteClickListener(OnDeleteClickLister listener) {
        this.mDeleteClickListener = listener;
    }

    public interface OnDeleteClickLister {
        void onDeleteClick(View view, int position);
    }
}
