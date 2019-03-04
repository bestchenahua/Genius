package cqdz.com.genius.home.xuanke.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import org.w3c.dom.Text;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.customer.AnswerCardDialog;

public class AnswerCardAdapter extends BaseQuickAdapter<AnswerCardDialog.Data, BaseViewHolder> {
    public AnswerCardAdapter(int layoutResId, @Nullable List<AnswerCardDialog.Data> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, AnswerCardDialog.Data item) {
        if(item!=null)
        {
            TextView tv_content = helper.getView(R.id.tv_content);
            if(item.isDone())
            {
                tv_content.setBackgroundResource(R.drawable.bor_rad27_50d8c0);
                tv_content.setTextColor(Color.parseColor("#50D8C0"));
            }
            if(item.getSerial()!=-1)
            {
                tv_content.setText(item.getSerial()+"");
            }
        }
    }
}
