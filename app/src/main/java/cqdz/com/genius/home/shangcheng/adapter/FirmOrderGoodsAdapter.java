package cqdz.com.genius.home.shangcheng.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.model.FirmOrderGoodsModel;
import cqdz.com.genius.utils.ImageLoader;

public class FirmOrderGoodsAdapter extends BaseQuickAdapter<FirmOrderGoodsModel.Response.Data, BaseViewHolder> {
    public FirmOrderGoodsAdapter(int layoutResId, @Nullable List<FirmOrderGoodsModel.Response.Data> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, FirmOrderGoodsModel.Response.Data item) {

        TextView num = helper.getView(R.id.num);


        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView bg =  helper.getView(R.id.imageView65);
//            CornerTransform transform= new CornerTransform(mContext, SizeTransform.dip2px(mContext,8));
//            transform.setExceptCorner(false,false,true,true);
//            RequestOptions options=new RequestOptions().optionalTransform(transform);
            ImageLoader.load(mContext,bg,item.getImg());
        }
        helper.setTag(R.id.textView74,item.getName());
        helper.setText(R.id.textView76,item.getModel()+"");
        helper.setText(R.id.textView77,item.getColor()+"");
        helper.setText(R.id.textView78,item.getPrice()+"");
        helper.setText(R.id.num,item.getNum()+"");
    }
}
