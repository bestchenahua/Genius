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
import cqdz.com.genius.home.wode.adapter.ErrorBookListAdapter;
import cqdz.com.genius.home.wode.model.ErrorBookListModel;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

@BindEventBus
public class MyErrorBookFragment extends MvpBaseFragment implements View.OnClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefresh;
    ErrorBookListAdapter adapter;
    String title;
    List<ErrorBookListModel.Response.Data> mList;
    public static MyErrorBookFragment getInstance(String title) {
        MyErrorBookFragment cf = new MyErrorBookFragment();
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
        mList = new ArrayList<>();
        adapter = new ErrorBookListAdapter(R.layout.item_errorbook, mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,ViewErrorSubjectActivity.class));
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
        ErrorBookListModel.Response.Data data = new ErrorBookListModel.Response.Data();
        data.setNum("1802");
        data.setContent("三年级数学人教同步提升班（全国）");
        mList.add(data);
        mList.add(data);
        mList.add(data);
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

        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getMessageEvent(MyErrorBookActivity.MessageEvent messageEvent) {
        smartRefresh.autoRefresh();
        EventBus.getDefault().removeStickyEvent(messageEvent);
    }
}
