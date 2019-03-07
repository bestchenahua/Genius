package cqdz.com.genius.home.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.model.PriveteLetterModel;
import cqdz.com.genius.utils.ImageLoader;

public class PrivateLetterAdapter extends BaseQuickAdapter<PriveteLetterModel.Response.Data, BaseViewHolder> {
    public PrivateLetterAdapter(int layoutResId, @Nullable List<PriveteLetterModel.Response.Data> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, PriveteLetterModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getComtent()))
        {
            helper.setText(R.id.tv_content,item.getComtent());
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv_img = helper.getView(R.id.iv_img);
            ImageLoader.load(mContext,iv_img,item.getImg(),17.5f);
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }
        if(!TextUtils.isEmpty(item.getNum()))
        {
            helper.setText(R.id.tv_num,item.getNum());
        }
        if(!TextUtils.isEmpty(item.getTime()))
        {
            helper.setText(R.id.tv_time,item.getTime());
        }
    }
}
