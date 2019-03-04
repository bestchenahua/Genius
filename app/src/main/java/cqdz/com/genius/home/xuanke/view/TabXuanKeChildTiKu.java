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
import cqdz.com.genius.home.view.TabXuanKeFm;
import cqdz.com.genius.home.xuanke.adapter.TabXuanKeTiKuAdapter;
import cqdz.com.genius.home.xuanke.model.XuanKeTiKuModel;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 题库
 */

@BindEventBus
public class TabXuanKeChildTiKu extends MvpBaseFragment {
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<XuanKeTiKuModel.Response.Data> mList;
    TabXuanKeTiKuAdapter adapter;
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
        adapter = new TabXuanKeTiKuAdapter(R.layout.item_home_itembank, mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,TiKuTest1Activity.class));
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
        XuanKeTiKuModel.Response.Data data = new XuanKeTiKuModel.Response.Data();
        data.setName("张木木");
        data.setContent("唱歌也能记单词？一起趣学英语！");
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551180142391&di=9e6b4049599e38e82cf8e75df61c3cdc&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F62%2F50%2F62558PICxm8_1024.jpg");
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
        Logger.d(messageEvent.getPostion()+"TabXuanKeChildTiKu");
        if(messageEvent.getPostion()==2)
        {
            EventBus.getDefault().removeStickyEvent(messageEvent);
            Logger.d(messageEvent.getTabName());
            smartRefreshLayout.autoRefresh();
        }
    }
}
