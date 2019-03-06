package cqdz.com.genius.home.shangcheng.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;


public class GoodsDialogTypeAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    private int checkItemPosition = 0;
    public void setCheckItem(int position) {
        checkItemPosition = position;
        notifyDataSetChanged();
    }
    public GoodsDialogTypeAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if(!TextUtils.isEmpty(item))
        {
            helper.setText(R.id.text_details,item);
            if (checkItemPosition != -1) {
                if (checkItemPosition == helper.getAdapterPosition()) {
                    helper.setTextColor(R.id.text_details,Color.parseColor("#2DB7B5"));
                } else {
                    helper.setTextColor(R.id.text_details,Color.parseColor("#515151"));
                }
            }
        }
    }
}
