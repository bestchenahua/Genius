package cqdz.com.genius.home.shangcheng.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.model.SpecialModel;
import cqdz.com.genius.utils.ImageLoader;

public class SpecialAdapter extends BaseQuickAdapter<SpecialModel.Response.Data,BaseViewHolder> {

    public SpecialAdapter(int layoutResId, @Nullable List<SpecialModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SpecialModel.Response.Data item) {
        ImageView img = helper.getView(R.id.imageView70);
        TextView name = helper.getView(R.id.textView80);
        if(!TextUtils.isEmpty(item.getName()))
        {
            name.setText(item.getName()+"");
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageLoader.load(mContext,img,item.getImg());
        }
    }
}
