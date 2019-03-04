package cqdz.com.genius.home.xuanke.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.HomeCurriculumModel;
import cqdz.com.genius.utils.ImageLoader;

public class TabXuanKeCurriculumAdapter extends BaseQuickAdapter<HomeCurriculumModel.Response.Data, BaseViewHolder> {
    public TabXuanKeCurriculumAdapter(int layoutResId, @Nullable List<HomeCurriculumModel.Response.Data> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, HomeCurriculumModel.Response.Data item) {
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
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.price,item.getPrice());
        }
        if(!TextUtils.isEmpty(item.getUnit()))
        {
            helper.setText(R.id.unit,item.getUnit());
        }
    }
}
