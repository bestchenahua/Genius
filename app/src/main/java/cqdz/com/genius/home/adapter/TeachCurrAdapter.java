package cqdz.com.genius.home.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.model.TeachCurrModel;
import cqdz.com.genius.home.model.TeachExpModel;
import cqdz.com.genius.utils.ImageLoader;


public class TeachCurrAdapter extends BaseQuickAdapter<TeachCurrModel.Response.Data, BaseViewHolder> {
    public TeachCurrAdapter(int layoutResId, @Nullable List<TeachCurrModel.Response.Data> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, TeachCurrModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv_touxiang = helper.getView(R.id.iv_touxiang);
            ImageLoader.load(mContext,iv_touxiang,item.getImg(),2);
        }
        if(!TextUtils.isEmpty(item.getTitle()))
        {
            helper.setText(R.id.tv_title,item.getTitle());
        }
        if(!TextUtils.isEmpty(item.getFollow()))
        {
            helper.setText(R.id.tv_follow,item.getFollow());
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }
        if(!TextUtils.isEmpty(item.getState()))
        {
            helper.setText(R.id.tv_state,item.getState());
        }
    }
}
