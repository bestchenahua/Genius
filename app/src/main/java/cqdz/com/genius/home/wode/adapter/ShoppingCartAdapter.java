package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.ShoppingCartModel;

public class ShoppingCartAdapter extends BaseQuickAdapter<ShoppingCartModel.Response.Data, BaseViewHolder> {
    Refresh refreshListener;
    public ShoppingCartAdapter(int layoutResId, @Nullable List<ShoppingCartModel.Response.Data> data, Refresh refresh) {
        super(layoutResId, data);
        refreshListener = refresh;
    }
    public interface Refresh
    {
        void onRefresh(List<ShoppingCartModel.Response.Data> data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ShoppingCartModel.Response.Data item) {
        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.textView104, item.getName());

            ShoppingCartChildAdapter shoppingCartChildAdapter = null;
            RecyclerView recyclerView;
            CheckBox checkBox = helper.getView(R.id.checkBox2);
            if (item.getChildList() != null) {
                if (item.getChildList().size() > 0) {
                    recyclerView = helper.getView(R.id.recyclerView);
                    shoppingCartChildAdapter = new ShoppingCartChildAdapter(R.layout.item_shopcart_child, getData().get(helper.getAdapterPosition()).getChildList());
                    shoppingCartChildAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
                        @Override
                        public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                            switch (view.getId()) {
                                case R.id.checkBox3:
                                    List<ShoppingCartModel.Response.Data.Child> childList = adapter.getData();
                                    boolean isChecked = true;
                                    for (int i = 0; i < childList.size(); i++) {
                                        if (!childList.get(i).isCheck()) {
                                            isChecked = false;
                                        }
                                    }
                                    item.setAll(isChecked);
                                    checkBox.setChecked(isChecked);
//                                    notifyDataSetChanged();
                                    break;
                            }
                        }
                    });
                    recyclerView.setAdapter(shoppingCartChildAdapter);//设置适配器
                    //设置布局管理器 , 将布局设置成纵向
                    LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
                    recyclerView.setLayoutManager(linerLayoutManager);
                }
            }
            checkBox.setChecked(item.isAll());
            ShoppingCartChildAdapter finalAdapter = shoppingCartChildAdapter;
            helper.addOnClickListener(R.id.checkBox2);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    item.setAll(isChecked);
//                    checkBox.callOnClick();
                    refreshListener.onRefresh(getData());
                    if (finalAdapter != null) {
                        finalAdapter.notifyDataSetChanged();
                    }
                }
            });
        }
    }
}
