package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.CurriculumOrderModel;

public class CurriculumOrderAdapter extends BaseQuickAdapter<CurriculumOrderModel.Response.Data, BaseViewHolder> {
    public CurriculumOrderAdapter(int layoutResId, @Nullable List<CurriculumOrderModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CurriculumOrderModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getTitle()))
        {
            helper.setText(R.id.tv_title,item.getTitle());
        }
        if(!TextUtils.isEmpty(item.getOrderNum()))
        {
            helper.setText(R.id.tv_ordernum,item.getOrderNum());
        }
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.tv_price,item.getPrice());
        }
        if(!TextUtils.isEmpty(item.getTime()))
        {
            helper.setText(R.id.tv_time,item.getTime());
        }
        if(!TextUtils.isEmpty(item.getStatus()))
        {
            helper.setText(R.id.textView121,item.getStatus());
            if(item.getStatus().equals("待支付"))
            {
                LinearLayout ll_btn = helper.getView(R.id.ll_btn);
                ll_btn.setVisibility(View.VISIBLE);
                helper.addOnClickListener(R.id.imageView81);
                helper.addOnClickListener(R.id.imageView84);
            }
        }

    }
}
