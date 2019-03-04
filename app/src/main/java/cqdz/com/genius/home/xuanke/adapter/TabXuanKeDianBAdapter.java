package cqdz.com.genius.home.xuanke.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.DianBModel;

public class TabXuanKeDianBAdapter extends BaseQuickAdapter<DianBModel.Response.Data.Child, BaseViewHolder> {

    public TabXuanKeDianBAdapter(int layoutResId, @Nullable List<DianBModel.Response.Data.Child> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DianBModel.Response.Data.Child item) {
        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.tv_name, item.getName());
        }
        View line = helper.getView(R.id.line);
        if (item.getItems().size() > 0) {
            ImageView arrow = helper.getView(R.id.arrow);
            TabXuanKeDianBChildAdapter adapter = new TabXuanKeDianBChildAdapter(R.layout.item_home_dianb_child, item.getItems());

            RecyclerView recyclerView = helper.getView(R.id.recyclerView);

            recyclerView.setAdapter(adapter);

            recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (recyclerView.getVisibility() == View.VISIBLE) {
                        recyclerView.setVisibility(View.GONE);
                        arrow.setImageResource(R.drawable.ic4);
                        if (helper.getAdapterPosition() + 1 != getData().size()) {
                            line.setVisibility(View.VISIBLE);
                        }
                    } else {
                        arrow.setImageResource(R.drawable.ic3);
                        recyclerView.setVisibility(View.VISIBLE);
                        line.setVisibility(View.GONE);
                    }

                }
            });
        }


    }
}
