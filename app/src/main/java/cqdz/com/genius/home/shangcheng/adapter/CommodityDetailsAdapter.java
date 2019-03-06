package cqdz.com.genius.home.shangcheng.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.utils.ImageLoader;

public class CommodityDetailsAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public CommodityDetailsAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if(!TextUtils.isEmpty(item))
        {
            ImageView bg =  helper.getView(R.id.details_pic);
            ImageLoader.load(mContext,bg,item);
        }
    }
}
