package cqdz.com.genius.home.xuanke.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.XuanKeTiKuModel;
import cqdz.com.genius.utils.ImageLoader;

public class TabXuanKeTiKuAdapter extends BaseQuickAdapter<XuanKeTiKuModel.Response.Data, BaseViewHolder> {
    public TabXuanKeTiKuAdapter(int layoutResId, @Nullable List<XuanKeTiKuModel.Response.Data> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, XuanKeTiKuModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv = helper.getView(R.id.imageView2);
            ImageLoader.load(mContext,iv,item.getImg(),2);
        }
        if(!TextUtils.isEmpty(item.getState()))
        {
            helper.setText(R.id.textView,item.getState());
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.name,item.getName());
        }
        if(!TextUtils.isEmpty(item.getContent()))
        {
            helper.setText(R.id.content,item.getContent());
        }
    }
}
