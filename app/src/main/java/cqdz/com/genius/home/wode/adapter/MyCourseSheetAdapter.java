package cqdz.com.genius.home.wode.adapter;

import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.CourseSheetModel;
import cqdz.com.genius.utils.ImageLoader;

public class MyCourseSheetAdapter extends BaseMultiItemQuickAdapter<CourseSheetModel.Response.Data, BaseViewHolder> {
    boolean isFirstInvalid =true;
    public MyCourseSheetAdapter(List<CourseSheetModel.Response.Data> data) {
        super(data);
        addItemType(0, R.layout.item_my_coursesheet);
        addItemType(1, R.layout.item_my_coursesheet_invalid);
    }

    @Override
    protected void convert(BaseViewHolder helper, CourseSheetModel.Response.Data item) {
        switch (helper.getItemViewType()) {
            case 0:
                CheckBox checkBox = helper.getView(R.id.checkbox);
                checkBox.setChecked(item.isChecked());
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        getData().get(helper.getAdapterPosition()).setChecked(isChecked);
                    }
                });
                helper.addOnClickListener(R.id.checkbox);
                break;
            case 1:
                if(isFirstInvalid) {
                    LinearLayout ll_label  =helper.getView(R.id.ll_label);
                    ll_label.setVisibility(View.VISIBLE);
                    isFirstInvalid= false;
                }
                helper.itemView.setAlpha(0.8f);
                break;
        }

        if(!TextUtils.isEmpty(item.getTitle()))
        {
            helper.setText(R.id.tv_title,item.getTitle());
        }
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv = helper.getView(R.id.iv_img);
            ImageLoader.load(mContext,iv,item.getImg(),2f);
        }
        if(!TextUtils.isEmpty(item.getPrice()))
        {
            helper.setText(R.id.tv_price,item.getPrice());
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }
        if(!TextUtils.isEmpty(item.getNum()))
        {
            helper.setText(R.id.tv_num,item.getNum());
        }

    }
}
