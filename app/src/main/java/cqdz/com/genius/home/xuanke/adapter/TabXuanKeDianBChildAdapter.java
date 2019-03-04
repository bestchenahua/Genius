package cqdz.com.genius.home.xuanke.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.DianBModel;

public class TabXuanKeDianBChildAdapter extends BaseQuickAdapter<DianBModel.Response.Data.Child.Item, BaseViewHolder> {

    public TabXuanKeDianBChildAdapter(int layoutResId, @Nullable List<DianBModel.Response.Data.Child.Item> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, DianBModel.Response.Data.Child.Item item) {
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }
        if(helper.getAdapterPosition()+1==getData().size())
        {
            View line = helper.getView(R.id.line);
            line.setVisibility(View.GONE);
        }
//
//        setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//
//            }
//        });
    }
}
