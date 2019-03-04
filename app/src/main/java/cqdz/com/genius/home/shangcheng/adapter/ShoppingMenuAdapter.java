package cqdz.com.genius.home.shangcheng.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.model.ShoppingClassifyBean;
import cqdz.com.genius.utils.ImageLoader;

public class ShoppingMenuAdapter extends BaseQuickAdapter<ShoppingClassifyBean.ShoppingMenuBean, BaseViewHolder> {



    public ShoppingMenuAdapter(int layoutResId, @Nullable List<ShoppingClassifyBean.ShoppingMenuBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShoppingClassifyBean.ShoppingMenuBean item) {
        helper.setText(R.id.tv_shopping_menu,item.getTypeName());
        ImageView iv = helper.getView(R.id.iv_shopping_menu);
        ImageLoader.load(mContext,iv,item.getImg());
    }
}
