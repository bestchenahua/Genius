package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.CurriculumOrderModel;
import cqdz.com.genius.home.wode.model.ErrorBookListModel;

public class ErrorBookListAdapter extends BaseQuickAdapter<ErrorBookListModel.Response.Data, BaseViewHolder> {
    public ErrorBookListAdapter(int layoutResId, @Nullable List<ErrorBookListModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ErrorBookListModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getContent()))
        {
            helper.setText(R.id.tv_content,item.getContent());
        }
        if(!TextUtils.isEmpty(item.getNum()))
        {
            helper.setText(R.id.tv_num,item.getNum()+"");
        }
        if(helper.getAdapterPosition()==getData().size()-1)
        {
            View line = helper.getView(R.id.line);
            line.setVisibility(View.GONE);
        }

    }
}
