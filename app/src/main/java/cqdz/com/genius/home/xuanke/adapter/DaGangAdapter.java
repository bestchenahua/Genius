package cqdz.com.genius.home.xuanke.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.DaGangModel;


public class DaGangAdapter extends BaseQuickAdapter<DaGangModel.Response.Data, BaseViewHolder> {
    public DaGangAdapter(int layoutResId, @Nullable List<DaGangModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DaGangModel.Response.Data item) {
        if (!TextUtils.isEmpty(item.getDate())) {
            helper.setText(R.id.tv_date, item.getDate());
        }
        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.tv_title, item.getName());
        }
        if (!TextUtils.isEmpty(item.getDay())) {
            helper.setText(R.id.tv_day, item.getDay());
        }
        if(!TextUtils.isEmpty(item.getBtn()))
        {
            Button btn = helper.getView(R.id.btn);
            btn.setVisibility(View.VISIBLE);
            btn.setText(item.getBtn());
        }
    }
}
