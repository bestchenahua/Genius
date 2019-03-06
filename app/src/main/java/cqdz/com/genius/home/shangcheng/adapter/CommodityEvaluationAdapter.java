package cqdz.com.genius.home.shangcheng.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.model.CommodityEvaluationModel;
import cqdz.com.genius.utils.ImageLoader;

public class CommodityEvaluationAdapter extends BaseQuickAdapter<CommodityEvaluationModel.Response.Data, BaseViewHolder> {

    public CommodityEvaluationAdapter(int layoutResId, @Nullable List<CommodityEvaluationModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CommodityEvaluationModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView bg =  helper.getView(R.id.imageView50);
            ImageLoader.load(mContext,bg,item.getImg(),(float) 17.5);
        }
        helper.setText(R.id.textView50,item.getName()+"");
        helper.setText(R.id.textView51,item.getContent()+"");
    }
}
