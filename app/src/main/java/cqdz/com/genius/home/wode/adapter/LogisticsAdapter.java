package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.LogisticsModel;

public class LogisticsAdapter extends BaseQuickAdapter<LogisticsModel.Response.Data, BaseViewHolder> {
    public LogisticsAdapter(int layoutResId, @Nullable List<LogisticsModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, LogisticsModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getContent()))
        {
            helper.setText(R.id.tv_content,item.getContent());
        }
        if(!TextUtils.isEmpty(item.getTime()))
        {
            helper.setText(R.id.tv_time,item.getTime());
        }
        if(helper.getAdapterPosition()<getData().size()-1)
        {
            TextView line = helper.getView(R.id.tv_line);
            line.setVisibility(View.VISIBLE);
        }
    }
}
