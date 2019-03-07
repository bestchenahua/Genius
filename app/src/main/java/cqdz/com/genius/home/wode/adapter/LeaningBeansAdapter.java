package cqdz.com.genius.home.wode.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.LeaningBeansModel;

public class LeaningBeansAdapter extends BaseQuickAdapter<LeaningBeansModel.Response.Data,BaseViewHolder> {
    public LeaningBeansAdapter(int layoutResId, @Nullable List<LeaningBeansModel.Response.Data> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, LeaningBeansModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.textView83,item.getName());
        }

        if(!TextUtils.isEmpty(item.getDate()))
        {
            helper.setText(R.id.textView84,item.getDate());
        }

        TextView jine = helper.getView(R.id.textView85);

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
