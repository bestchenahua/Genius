package cqdz.com.genius.home.xuanke.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.XuanKeOrderModel;

public class XuanKeOrderAdapter extends BaseQuickAdapter<XuanKeOrderModel.Response.Data, BaseViewHolder> {
    public XuanKeOrderAdapter(int layoutResId, @Nullable List<XuanKeOrderModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, XuanKeOrderModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getTitle()))
        {
            helper.setText(R.id.tv_title,item.getTitle());
        }
        if(!TextUtils.isEmpty(item.getTime()))
        {
            helper.setText(R.id.tv_time,item.getTime());
        }
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.tv_price,item.getPrice());
        }
    }
}
