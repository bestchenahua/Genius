package cqdz.com.genius.home.shangcheng.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.model.FirmOrderPayMethodModel;
import cqdz.com.genius.utils.ImageLoader;

public class FirmOrderPayMethodAdapter extends BaseQuickAdapter<FirmOrderPayMethodModel.Response.Data, BaseViewHolder> {
    int checkedPosition = 0;
    public void setCheckedPosition(int position)
    {
        this.checkedPosition = position;
        notifyDataSetChanged();
    }

    public FirmOrderPayMethodAdapter(int layoutResId, @Nullable List<FirmOrderPayMethodModel.Response.Data> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, FirmOrderPayMethodModel.Response.Data item) {
        ImageView check = helper.getView(R.id.imageView67);

        if(helper.getAdapterPosition()==checkedPosition)
        {
            check.setVisibility(View.VISIBLE);
        }
        else {
            check.setVisibility(View.INVISIBLE);
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView bg =  helper.getView(R.id.imageView66);
//            CornerTransform transform= new CornerTransform(mContext, SizeTransform.dip2px(mContext,8));
//            transform.setExceptCorner(false,false,true,true);
//            RequestOptions options=new RequestOptions().optionalTransform(transform);
            ImageLoader.load(mContext,bg,item.getImg());
        }
        helper.setText(R.id.textView79,item.getName()+"");
    }
}
