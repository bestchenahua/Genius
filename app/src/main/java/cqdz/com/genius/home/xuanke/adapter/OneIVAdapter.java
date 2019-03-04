package cqdz.com.genius.home.xuanke.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.utils.ImageLoader;


public class OneIVAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    public OneIVAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        if(!TextUtils.isEmpty(item))
        {
            ImageView iv = helper.getView(R.id.iv);
            ImageLoader.load(mContext,iv,item);
        }
    }
}
