package cqdz.com.genius.home.shangcheng.customer;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.adapter.GoodsDialogTypeAdapter;
import me.shaohui.bottomdialog.BaseBottomDialog;

public class GoodsTypeDialog extends BaseBottomDialog implements View.OnClickListener {
    public static GoodsTypeDialog getInstance(List<String> data) {
        GoodsTypeDialog dialog = new GoodsTypeDialog();
        dialog.data = data;
        return dialog;
    }
    private List<String> data;
    GoodsDialogTypeAdapter adapter;

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_goods_type;
    }

    @Override
    public int getHeight() {
        return getView().getHeight();
    }

    @Override
    public void bindView(View v) {
        ImageView close = v.findViewById(R.id.imageView64);
        close.setOnClickListener(this);
        RecyclerView recyclerView = v.findViewById(R.id.recyclerView2);
        if (data != null) {
            adapter = new GoodsDialogTypeAdapter(R.layout.item_goods_type, data);
            adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    GoodsDialogTypeAdapter goodsDialogAdapter = (GoodsDialogTypeAdapter) adapter;
                    goodsDialogAdapter.setCheckItem(position);
                }
            });
            recyclerView.setAdapter(adapter);//设置适配器
            //设置布局管理器 , 将布局设置成纵向
            LinearLayoutManager linerLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linerLayoutManager);
        }
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView64:
                dismiss();
                break;
        }
    }
}
