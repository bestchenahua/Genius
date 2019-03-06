package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.CurriculumOrderModel;
import cqdz.com.genius.home.wode.model.MyCurriculumModel;
import cqdz.com.genius.utils.ImageLoader;

public class MyCurriculumAdapter extends BaseQuickAdapter<MyCurriculumModel.Response.Data, BaseViewHolder> {
    public MyCurriculumAdapter(int layoutResId, @Nullable List<MyCurriculumModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyCurriculumModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getTitle()))
        {
            helper.setText(R.id.tv_title,item.getTitle());
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv = helper.getView(R.id.iv_img);
            ImageLoader.load(mContext,iv,item.getImg(),2f);
        }
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.tv_price,item.getPrice());
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }
        if(!TextUtils.isEmpty(item.getNum()))
        {
            helper.setText(R.id.tv_num,item.getNum());
        }

    }
}
