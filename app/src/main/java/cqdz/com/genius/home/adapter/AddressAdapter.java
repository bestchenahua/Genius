package cqdz.com.genius.home.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.model.AddressModel;


public class AddressAdapter extends BaseQuickAdapter<AddressModel.Response.Data, BaseViewHolder> {

    int checkedPosition = 0;
    public void setCheckedPosition(int position)
    {
        this.checkedPosition = position;
        notifyDataSetChanged();
    }

    public AddressAdapter(int layoutResId, @Nullable List<AddressModel.Response.Data> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, AddressModel.Response.Data item) {
        CheckBox checkBox = helper.getView(R.id.checkBox4);
        checkBox.setClickable(false);
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.textView115,item.getName());
        }

        if(!TextUtils.isEmpty(item.getTel()))
        {
            helper.setText(R.id.textView116,item.getTel());
        }

        if(!TextUtils.isEmpty(item.getAddr()))
        {
            helper.setText(R.id.textView117,item.getAddr());
        }


        if(helper.getAdapterPosition()==checkedPosition)
        {
            checkBox.setChecked(true);
        }
        else {
            checkBox.setChecked(false);
        }
        helper.addOnClickListener(R.id.textView119);
    }
}
