package cqdz.com.genius.home.adapter;

import android.support.annotation.Nullable;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.home.model.CiecleModel;


public class CirCleAdapter extends BaseQuickAdapter<CiecleModel.Response.Data, BaseViewHolder> {
    public CirCleAdapter(int layoutResId, @Nullable List<CiecleModel.Response.Data> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, CiecleModel.Response.Data item) {
    }
}
