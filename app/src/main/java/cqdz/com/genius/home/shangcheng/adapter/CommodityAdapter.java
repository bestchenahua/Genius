package cqdz.com.genius.home.shangcheng.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.customer.CornerTransform;
import cqdz.com.genius.home.shangcheng.model.CommodityModel;
import cqdz.com.genius.utils.ImageLoader;
import cqdz.com.genius.utils.SizeTransform;

public class CommodityAdapter extends BaseQuickAdapter<CommodityModel.Response.Data, BaseViewHolder> {
    CornerTransform transform;
    RequestOptions options;
    public CommodityAdapter(int layoutResId, @Nullable List<CommodityModel.Response.Data> data) {
        super(layoutResId, data);
        transform= new CornerTransform(mContext, SizeTransform.dip2px(mContext,15));
        options=new RequestOptions().optionalTransform(transform);
        transform.setExceptCorner(false,false,true,true);
    }
    @Override
    protected void convert(BaseViewHolder helper, CommodityModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView bg =  helper.getView(R.id.imageView49);

            ImageLoader.load(mContext,bg,item.getImg(),options);
        }
        helper.setText(R.id.textView46,item.getIntroduction()+"");
        helper.setText(R.id.textView47,item.getPrice()+"");
        helper.setText(R.id.textView48,item.getNum()+"");
    }
}
