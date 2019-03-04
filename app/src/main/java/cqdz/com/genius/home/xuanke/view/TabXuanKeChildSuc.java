package cqdz.com.genius.home.xuanke.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.orhanobut.logger.Logger;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.adapter.TabXuanKeCurriculumAdapter;
import cqdz.com.genius.home.xuanke.model.HomeCurriculumModel;
import cqdz.com.genius.home.view.TabXuanKeFm;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 速成班
 */

@BindEventBus
public class TabXuanKeChildSuc extends MvpBaseFragment {
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<HomeCurriculumModel.Response.Data> mList;
    TabXuanKeCurriculumAdapter adapter;
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
        mList = new ArrayList<>();
        adapter = new TabXuanKeCurriculumAdapter(R.layout.item_home_curriculum, mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,SucDetailsActivity.class));
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        smartRefreshLayout.setEnableLoadMore(true);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                mList.clear();
                setData();
                onComplete();
            }
        });
        smartRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                setData();
                onComplete();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }
    public void setData() {
        HomeCurriculumModel.Response.Data data = new HomeCurriculumModel.Response.Data();
        data.setName("张木木");
        data.setContent("唱歌也能记单词？一起趣学英语！");
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551180142391&di=9e6b4049599e38e82cf8e75df61c3cdc&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F62%2F50%2F62558PICxm8_1024.jpg");
        data.setPrice("20");
        data.setState("报名中");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onComplete() {
        super.onComplete();
        if (smartRefreshLayout.getState() == RefreshState.Refreshing) {
            smartRefreshLayout.finishRefresh();
        }

        if (smartRefreshLayout.getState() == RefreshState.Loading) {
            smartRefreshLayout.finishLoadMore();
        }
    }
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void getHomeMessageEvent(TabXuanKeFm.TabHomeMessageEvent messageEvent) {
        Logger.d(messageEvent.getPostion()+"TabXuanKeChildSuc");
        if(messageEvent.getPostion()==0)
        {
            EventBus.getDefault().removeStickyEvent(messageEvent);
            Logger.d(messageEvent.getTabName());
            smartRefreshLayout.autoRefresh();
        }
    }
}
