package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import cqdz.com.genius.home.wode.adapter.CurriculumOrderAdapter;
import cqdz.com.genius.home.wode.adapter.MallOrderAdapter;
import cqdz.com.genius.home.wode.model.CurriculumOrderModel;
import cqdz.com.genius.home.wode.model.MallOrderModel;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

@BindEventBus
public class CurriculumOrderFragment extends MvpBaseFragment implements View.OnClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefresh;
    CurriculumOrderAdapter adapter;
    String title;
    List<CurriculumOrderModel.Response.Data> mList;
    DeleteConfirmDialog confirmDialog ;
    public static CurriculumOrderFragment getInstance(String title) {
        CurriculumOrderFragment cf = new CurriculumOrderFragment();
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
        confirmDialog = new DeleteConfirmDialog(mContext, 123,  "确定删除该订单嘛?", "取消", "删除", new DeleteConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if(requestCode==123)
                {
                    if(isPositive)
                    {
                        mToast.showShort("点了一下取消");

                    }else {
                        mToast.showShort("点了一下删除");
                    }
                    confirmDialog.dismiss();
                }
            }
        });

        mList = new ArrayList<>();
        adapter = new CurriculumOrderAdapter(R.layout.item_curriculum_order, mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,CurriculumOrderDetailsActivity.class)
                        .putExtra("state",mList.get(position).getStatus()));
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.imageView84:
                        //右边按钮
                        mToast.showText("点了一下右边按钮");
                        break;
                    case R.id.imageView81:
                        //左边按钮
                        mToast.showText("点了一下左边按钮");
//                        startActivity(new Intent(mContext,MallOrderLogisticsActivity.class));
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);//设置适配器
        //设置布局管理器 , 将布局设置成纵向
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager);
        adapter.setEmptyView(R.layout.empty,recyclerView);
//        adapter.setEmptyView(R.layout.empty);
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
        CurriculumOrderModel.Response.Data data = new CurriculumOrderModel.Response.Data();
        data.setOrderNum("订单编号：245869718");
        data.setPrice("应付：￥200(学习币)");
        data.setStatus("待支付");
        data.setTitle("三年级数学人教同步提升班（全国）");
        data.setTime("2月15日-2月22日·王雨晴");


        CurriculumOrderModel.Response.Data data2 = new CurriculumOrderModel.Response.Data();
        data2.setOrderNum("订单编号：245869718");
        data2.setPrice("应付：￥200(学习币)");
        data2.setStatus("已取消");
        data2.setTitle("三年级数学人教同步提升班（全国）");
        data2.setTime("2月15日-2月22日·王雨晴");

        CurriculumOrderModel.Response.Data data3 = new CurriculumOrderModel.Response.Data();
        data3.setOrderNum("订单编号：245869718");
        data3.setPrice("应付：￥200(学习币)");
        data3.setStatus("已支付");
        data3.setTitle("三年级数学人教同步提升班（全国）");
        data3.setTime("2月15日-2月22日·王雨晴");
        mList.add(data);
        mList.add(data2);
        mList.add(data3);
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
    public void getMessageEvent(FmMyOrderCurriculum.MessageEvent messageEvent) {
        smartRefresh.autoRefresh();
        EventBus.getDefault().removeStickyEvent(messageEvent);
    }
}
