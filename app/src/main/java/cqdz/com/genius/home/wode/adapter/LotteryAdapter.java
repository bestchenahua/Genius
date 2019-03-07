package cqdz.com.genius.home.wode.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.Currency2Model;
import cqdz.com.genius.home.wode.model.LotteryModel;
import cqdz.com.genius.utils.ImageLoader;

public class LotteryAdapter extends BaseQuickAdapter<LotteryModel.Response.Data,BaseViewHolder> {

    public LotteryAdapter(int layoutResId, @Nullable List<LotteryModel.Response.Data> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, LotteryModel.Response.Data item) {

        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }

        if(!TextUtils.isEmpty(item.getMoney()))
        {
            helper.setText(R.id.tv_money,item.getMoney());
        }
        if(!TextUtils.isEmpty(item.getTime()))
        {
            helper.setText(R.id.tv_time,item.getTime());
        }
    }
}
