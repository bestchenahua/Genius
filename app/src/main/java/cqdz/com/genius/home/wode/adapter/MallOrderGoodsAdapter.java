package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.MallOrderModel;
import cqdz.com.genius.utils.ImageLoader;


public class MallOrderGoodsAdapter extends BaseQuickAdapter<MallOrderModel.Response.Data.Child, BaseViewHolder> {
    public MallOrderGoodsAdapter(int layoutResId, @Nullable List<MallOrderModel.Response.Data.Child> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MallOrderModel.Response.Data.Child item) {
        if(helper.getAdapterPosition()==0) {
            helper.getView(R.id.line).setVisibility(View.GONE);
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv = helper.getView(R.id.imageView85);
            ImageLoader.load(mContext,iv,item.getImg(),4);
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.textView124,item.getName());
        }
        if(!TextUtils.isEmpty(item.getIntroduction()))
        {
            helper.setText(R.id.textView125,item.getIntroduction());
        }
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.textView126,item.getPrice());
        }
        if(item.getNum()>0)
        {
            helper.setText(R.id.textView127,"x"+item.getNum());
        }

    }
}
