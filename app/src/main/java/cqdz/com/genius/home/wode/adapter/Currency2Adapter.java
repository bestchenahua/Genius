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
import cqdz.com.genius.utils.ImageLoader;

public class Currency2Adapter extends BaseQuickAdapter<Currency2Model.Response.Data,BaseViewHolder> {

    public Currency2Adapter(int layoutResId, @Nullable List<Currency2Model.Response.Data> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, Currency2Model.Response.Data item) {
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv_img = helper.getView(R.id.iv_img);
            ImageLoader.load(mContext,iv_img,item.getImg(),12.5f);
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }

        if(!TextUtils.isEmpty(item.getMoney()))
        {
            helper.setText(R.id.tv_money,item.getMoney());
        }
        TextView jine = helper.getView(R.id.tv_money);
        if(item.getType()==0)
        {
            if(!TextUtils.isEmpty(item.getMoney()))
            {
                jine.setText("+"+item.getMoney());
            }
        }
        else {
            if(!TextUtils.isEmpty(item.getMoney()))
            {
                jine.setTextColor(Color.parseColor("#8E8E8E"));
                jine.setText("-"+item.getMoney());
            }
        }
    }
}
