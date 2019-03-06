package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.MyFollowModel;
import cqdz.com.genius.utils.ImageLoader;

public class MyFollowAdapter extends BaseQuickAdapter<MyFollowModel.Response.Data, BaseViewHolder> {
    public MyFollowAdapter(int layoutResId, @Nullable List<MyFollowModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MyFollowModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getImg()))
        {
            ImageView iv = helper.getView(R.id.iv_img);
            ImageLoader.load(mContext,iv,item.getImg(),25f);
        }
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.tv_name,item.getName());
        }
        if(!TextUtils.isEmpty(item.getIsFollow()))
        {Button btn_follow = helper.getView(R.id.btn_follow);
            if(item.getIsFollow().equals("0"))
            {
                btn_follow.setBackgroundResource(R.drawable.rad16_e7e7e7);
                btn_follow.setText("已关注");
            }
            else {

                btn_follow.setBackgroundResource(R.drawable.rad16_ff7b4d);
                btn_follow.setText("关注");
            }
        }
    }
}
