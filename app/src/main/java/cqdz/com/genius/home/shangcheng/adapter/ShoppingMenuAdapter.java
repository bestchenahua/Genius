package cqdz.com.genius.home.shangcheng.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.model.ShoppingClassifyModel;
import cqdz.com.genius.utils.ImageLoader;

public class ShoppingMenuAdapter extends BaseQuickAdapter<ShoppingClassifyModel.Response.Data.ShoppingMenuBean, BaseViewHolder> {

    public ShoppingMenuAdapter(int layoutResId, @Nullable List<ShoppingClassifyModel.Response.Data.ShoppingMenuBean> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ShoppingClassifyModel.Response.Data.ShoppingMenuBean item) {
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.tv_price,item.getPrice());
        }
        if(!TextUtils.isEmpty(item.getPurchased()))
        {
            helper.setText(R.id.tv_goumai,item.getPurchased());
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv = helper.getView(R.id.iv_img);
            ImageLoader.load(mContext,iv,item.getImg());
        }
    }
}
