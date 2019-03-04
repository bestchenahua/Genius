package cqdz.com.genius.home.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.model.CiecleModel;
import cqdz.com.genius.home.model.TeachExpModel;


public class TeachExpAdapter extends BaseQuickAdapter<TeachExpModel.Response.Data, BaseViewHolder> {
    public TeachExpAdapter(int layoutResId, @Nullable List<TeachExpModel.Response.Data> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, TeachExpModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getDate()))
        {
            helper.setText(R.id.tv_date,item.getDate());
        }
        if(!TextUtils.isEmpty(item.getExperience()))
        {
            helper.setText(R.id.tv_exp,item.getExperience());
        }
    }
}
