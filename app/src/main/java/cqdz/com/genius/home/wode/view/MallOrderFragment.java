package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.customer.DeleteConfirmDialog;
import cqdz.com.genius.home.view.PayActivity;
import cqdz.com.genius.home.wode.adapter.MallOrderAdapter;
import cqdz.com.genius.home.wode.model.MallOrderModel;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

@BindEventBus
public class MallOrderFragment extends MvpBaseFragment implements View.OnClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefresh;
    MallOrderAdapter adapter;
    String title;
    List<MallOrderModel.Response.Data> mList;
    DeleteConfirmDialog confirmDialog ;
    DeleteConfirmDialog confirmDialog2 ;
    String orderNum_Checked;
    public static MallOrderFragment getInstance(String title) {
        MallOrderFragment cf = new MallOrderFragment();
        cf.title = title;
        return cf;
    }

    @Override
    protected int getLayout() {
        return R.layout.smart_recyclerview;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        smartRefresh.setBackgroundColor(Color.parseColor("#EEEEEE"));
        smartRefresh.setEnableLoadMore(true);
        confirmDialog = new DeleteConfirmDialog(mContext, 123,  "确定删除该订单吗?", "确定删除", "我再想想", new DeleteConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if(requestCode==123)
                {
                    if(isPositive)
                    {

                        if(!TextUtils.isEmpty(orderNum_Checked))
                        {
                            mToast.showShort("点了一下左边"+orderNum_Checked);
                        }

                    }else {
                        mToast.showShort("点了一下右边");
                    }
                    confirmDialog.dismiss();
                }
            }
        });
        confirmDialog2 = new DeleteConfirmDialog(mContext, 124,  "确定取消该订单吗?", "确定取消", "我再想想", new DeleteConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if(requestCode==124)
                {
                    if(isPositive)
                    {
                        if(!TextUtils.isEmpty(orderNum_Checked))
                        {
                            mToast.showShort("点了一下左边"+orderNum_Checked);
                        }
                    }else {
                        mToast.showShort("点了一下右边");
                    }
                    confirmDialog2.dismiss();
                }
            }
        });
        mList = new ArrayList<>();
        adapter = new MallOrderAdapter(R.layout.item_mall_order, mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,OrderDetailsActivity.class).putExtra("state",mList.get(position).getStatus()));
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.imageView81:
                        switch (mList.get(position).getStatus()) {
                            case  "已发货":
                                startActivity(new Intent(mContext,MallOrderLogisticsActivity.class));
                                break;
                            case  "已付款":
                                orderNum_Checked = mList.get(position).getOrderNum();
                                confirmDialog2.show();
                                break;
                            case  "已签收":
//                                mToast.showText("删除订单");
                                orderNum_Checked = mList.get(position).getOrderNum();
                                confirmDialog.show();
                                break;
                            case  "等待付款":
                                orderNum_Checked = mList.get(position).getOrderNum();
                                confirmDialog2.show();
                                break;
                        }
                        break;
                    case R.id.imageView84:
                        //右边按钮
                        switch (mList.get(position).getStatus()) {
                            case  "已发货":
                                mToast.showText("确认收货");
                                break;
                            case  "已付款":
                                mToast.showText("成功提醒卖家发货");
                                break;
                            case  "已签收":
//                                mToast.showText("去评价");
                                startActivity(new Intent(mContext,EvaluateActivity.class));
                                break;
                            case  "等待付款":
                                startActivity(new Intent(mContext,PayActivity.class));
                                break;
                        }
                        break;
                        case R.id.recyclerView7:
                            startActivity(new Intent(mContext,OrderDetailsActivity.class).putExtra("state",mList.get(position).getStatus()));
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
                if (getUserVisibleHint()) {
                    Logger.d("刷新" + title + "" + getUserVisibleHint() + "---");
                    setData();
                } else {
                    onComplete();
                }
            }
        });
    }
    public void setData() {
        mList.clear();
        MallOrderModel.Response.Data data = new MallOrderModel.Response.Data();

        MallOrderModel.Response.Data.Child child = new MallOrderModel.Response.Data.Child();
        List<MallOrderModel.Response.Data.Child> children = new ArrayList<>();
        child.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1549880252281&di=799ab77a7543428c0ba70c81bad65607&imgtype=0&src=http%3A%2F%2Fpic1.16pic.com%2F00%2F50%2F63%2F16pic_5063889_b.jpg");
        child.setName("纳米天使 水性硅藻泥");
        child.setIntroduction("2000ml");
        child.setPrice("￥798");
        child.setNum(2);
        children.add(child);
        children.add(child);

        data.setName("云之尚建材旗舰店");
        data.setStatus("已发货");
        data.setTotalPrice("￥798");
        data.setChildList(children);
        data.setOrderNum("订单编号:1");
        MallOrderModel.Response.Data data2 = new MallOrderModel.Response.Data();
        data2.setName("云之尚建材旗舰店");
        data2.setStatus("已付款");
        data2.setTotalPrice("￥798");
        data2.setChildList(children);
        data2.setOrderNum("订单编号:2");
        MallOrderModel.Response.Data data3 = new MallOrderModel.Response.Data();
        data3.setName("云之尚建材旗舰店");
        data3.setStatus("已签收");
        data3.setTotalPrice("￥798");
        data3.setChildList(children);
        data3.setOrderNum("订单编号:3");
        MallOrderModel.Response.Data data4= new MallOrderModel.Response.Data();
        data4.setName("云之尚建材旗舰店");
        data4.setStatus("等待付款");
        data4.setTotalPrice("￥798");
        data4.setChildList(children);
        data4.setOrderNum("订单编号:4");
        mList.add(data);
        mList.add(data2);
        mList.add(data3);
        mList.add(data4);
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

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMessageEvent(FmMyOrderCommodity.MessageEvent messageEvent) {
        smartRefresh.autoRefresh();
        EventBus.getDefault().removeStickyEvent(messageEvent);
    }
}
