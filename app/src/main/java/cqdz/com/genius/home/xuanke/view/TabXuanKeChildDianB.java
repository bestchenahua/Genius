package cqdz.com.genius.home.xuanke.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

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
import cqdz.com.genius.home.view.TeacherInfoActivity;
import cqdz.com.genius.home.xuanke.adapter.TabXuanKeDianBAdapter;
import cqdz.com.genius.home.xuanke.model.DianBModel;
import cqdz.com.genius.home.view.TabXuanKeFm;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.ImageLoader;

/**
 * 点播
 */

@BindEventBus
public class TabXuanKeChildDianB extends MvpBaseFragment {
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id.iv_touxiang)
    ImageView iv_touxiang;
    @BindView(R.id.ll_teacher)
    LinearLayout ll_teacher;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<DianBModel.Response.Data.Child> mList;
    TabXuanKeDianBAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.tab_home_dianb;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        ll_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext, TeacherInfoActivity.class));
            }
        });
        mList = new ArrayList<>();
        adapter = new TabXuanKeDianBAdapter(R.layout.item_home_dianb, mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));
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
        ImageLoader.load(mContext,iv_touxiang,"http://pic27.photophoto.cn/20130615/0005018689966500_b.jpg",2);

        DianBModel.Response.Data.Child data = new DianBModel.Response.Data.Child();
        DianBModel.Response.Data.Child.Item item = new DianBModel.Response.Data.Child.Item();
        List<DianBModel.Response.Data.Child.Item> items = new ArrayList<>();
        item.setName("第1节 怎样快速理解文言文");
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        items.add(item);
        data.setName("二年级语文上册一单元");
        data.setItems(items);
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
        if(messageEvent.getPostion()==1)
        {
            EventBus.getDefault().removeStickyEvent(messageEvent);
            Logger.d(messageEvent.getTabName());
            smartRefreshLayout.autoRefresh();
        }
    }
}
