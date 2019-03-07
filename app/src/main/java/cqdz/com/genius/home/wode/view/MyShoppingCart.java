package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.customer.DeleteConfirmDialog;
import cqdz.com.genius.home.shangcheng.view.FirmOrderActivity;
import cqdz.com.genius.home.wode.adapter.ShoppingCartAdapter;
import cqdz.com.genius.home.wode.model.ShoppingCartModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyShoppingCart extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.smartRefresh)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.ll_jiesuan)
    LinearLayout ll_jiesuan;
    @BindView(R.id.checkBox)
    CheckBox checkBox;
    @BindView(R.id.fasong)
    ImageView fasong;


    ShoppingCartAdapter adapter;
    List<ShoppingCartModel.Response.Data> mList;
    DeleteConfirmDialog confirmDialog ;
    @Override
    protected int getLayout() {
        return R.layout.activity_shoppingcart;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        confirmDialog = new DeleteConfirmDialog(mContext, 123, "确定要删除该商品吗?", "我再想想", "确定", new DeleteConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if(requestCode==123)
                {
                    if(isPositive)
                    {
                        mToast.showShort("点击了一下继续");
                    }else {
                        mToast.showShort("点击了一下放弃");
                    }
                    confirmDialog.dismiss();
                }
            }
        });
        action_bar_title.setText("我的购物车");
        action_bar_right.setText("管理");
        action_bar_right.setOnClickListener(this);
        fasong.setOnClickListener(this);
        mList = new ArrayList<>();
        adapter = new ShoppingCartAdapter(R.layout.item_shopcart, mList, new ShoppingCartAdapter.Refresh() {
            @Override
            public void onRefresh(List<ShoppingCartModel.Response.Data> data) {
                mList= data;
                boolean isChecked = true;
                for (int i = 0; i < mList.size(); i++) {
                    if (!mList.get(i).isAll()) {
                        isChecked = false;
                    }
                }
                checkBox.setChecked(isChecked);
            }
        });
        ShoppingCartAdapter finalAdapter = adapter;
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                finalAdapter.notifyDataSetChanged();
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < mList.size(); i++) {
                    mList.get(i).setAll(checkBox.isChecked());
                    for (int j = 0; j < mList.get(i).getChildList().size(); j++) {
                        mList.get(i).getChildList().get(j).setCheck(checkBox.isChecked());
                    }
                }
                finalAdapter.notifyDataSetChanged();
            }
        });
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Logger.d("onItemClick");
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                CheckBox checkBox1 = (CheckBox) view;
                switch (view.getId()) {
                    case R.id.checkBox2:
                        mList = adapter.getData();
                        for (int i = 0; i < mList.get(position).getChildList().size(); i++) {
                            mList.get(position).getChildList().get(i).setCheck(checkBox1.isChecked());
                        }
                        boolean isChecked = true;
                        for (int i = 0; i < mList.size(); i++) {
                            if (!mList.get(i).isAll()) {
                                isChecked = false;
                            }
                        }
                        checkBox.setChecked(isChecked);
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);//设置适配器
        //设置布局管理器 , 将布局设置成纵向
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager);
        smartRefresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                setData();
            }
        });
        smartRefresh.autoRefresh();
    }

    public void setData() {
        mList.clear();

        //如果数据完全一样  在Adapter中将会被视为一个数据  即改变一个会改变其他相同的数据
        ShoppingCartModel.Response.Data data = new ShoppingCartModel.Response.Data();
        List<ShoppingCartModel.Response.Data.Child> child1 = new ArrayList<>();
        ShoppingCartModel.Response.Data.Child child = new ShoppingCartModel.Response.Data.Child();
        child.setCheck(true);
        child.setImg("http://pic1.nipic.com/2008-12-30/200812308231244_2.jpg");
        child.setName("纳米天使 水性硅藻泥");
        child.setIntroduction("采用纳米硅藻净醛技术");
        child.setNum(3);
        child.setPrice("￥198");
        ShoppingCartModel.Response.Data.Child child2 = new ShoppingCartModel.Response.Data.Child();
        child2.setCheck(false);
        child2.setImg("http://pic1.nipic.com/2008-12-30/200812308231244_2.jpg");
        child2.setName("纳米天使");
        child2.setIntroduction("采用纳米硅藻净醛技术");
        child2.setNum(3);
        child2.setPrice("￥798");
        ShoppingCartModel.Response.Data.Child child3 = new ShoppingCartModel.Response.Data.Child();
        child3.setCheck(true);
        child3.setImg("http://pic1.nipic.com/2008-12-30/200812308231244_2.jpg");
        child3.setName("藻泥");
        child3.setIntroduction("采用纳米硅藻净醛技术");
        child3.setNum(6);
        child3.setPrice("￥200");
        ShoppingCartModel.Response.Data.Child child4 = new ShoppingCartModel.Response.Data.Child();
        child4.setCheck(false);
        child4.setImg("http://pic1.nipic.com/2008-12-30/200812308231244_2.jpg");
        child4.setName("纳米使");
        child4.setIntroduction("采用纳藻净醛技术");
        child4.setNum(2);
        child4.setPrice("￥98");
        ShoppingCartModel.Response.Data data2 = new ShoppingCartModel.Response.Data();
        List<ShoppingCartModel.Response.Data.Child> childList = new ArrayList<>();
        childList.add(child2);
        childList.add(child);
        data2.setName("来自星星的你");
        data2.setChildList(childList);
        child1.add(child3);
        child1.add(child4);
        data.setName("来自星");
        data.setChildList(child1);
        mList.add(data2);
        mList.add(data);
        adapter.notifyDataSetChanged();
        onComplete();
    }

    @Override
    public void onComplete() {
        super.onComplete();
        if (smartRefresh != null) {
            if (smartRefresh.getState() == RefreshState.Loading) {
                smartRefresh.finishLoadMore();
            }
            if (smartRefresh.getState() == RefreshState.Refreshing) {
                smartRefresh.finishRefresh();
            }
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.action_bar_right:
                if (action_bar_right.getText().toString().equals("管理")) {
                    action_bar_right.setText("完成");
                    ll_jiesuan.setVisibility(View.GONE);
                    fasong.setImageResource(R.drawable.btn_shanchu);
                } else {
                    action_bar_right.setText("管理");
                    ll_jiesuan.setVisibility(View.VISIBLE);
                    fasong.setImageResource(R.drawable.btn_jiesuan);
                }
                break;
            case R.id.fasong:
                if (action_bar_right.getText().toString().equals("管理")) {
                    mToast.showShort("结算");
                    startActivity(new Intent(mContext,FirmOrderActivity.class));
                } else {
//                    mToast.showShort("删除");
                    confirmDialog.show();
                }
                break;
        }
    }
}
