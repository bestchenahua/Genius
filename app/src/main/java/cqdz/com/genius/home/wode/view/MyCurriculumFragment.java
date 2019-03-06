package cqdz.com.genius.home.wode.view;

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
import cqdz.com.genius.home.wode.adapter.MyCurriculumAdapter;
import cqdz.com.genius.home.wode.model.MyCurriculumModel;
import cqdz.com.genius.mvpInterface.BindEventBus;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

@BindEventBus
public class MyCurriculumFragment extends MvpBaseFragment implements View.OnClickListener {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefresh;
    MyCurriculumAdapter adapter;
    String title;
    List<MyCurriculumModel.Response.Data> mList;
    DeleteConfirmDialog confirmDialog ;
    public static MyCurriculumFragment getInstance(String title) {
        MyCurriculumFragment cf = new MyCurriculumFragment();
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
        adapter = new MyCurriculumAdapter(R.layout.item_mycurr, mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

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
        MyCurriculumModel.Response.Data data = new MyCurriculumModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551845328212&di=488952a4d491180cd69716bda9e7e94a&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F14%2F89%2F39%2F79958PICQmt_1024.jpg");
        data.setName("张哞哞");
        data.setNum("1802");
        data.setTitle("三年级数学人教同步提升班（全国）");
        data.setPrice("20元/每课时");
        data.setTitle("唱歌也能记单词？一起趣学英语！");


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
    public void getMessageEvent(MyCurriculumActivity.MessageEvent messageEvent) {
        smartRefresh.autoRefresh();
        EventBus.getDefault().removeStickyEvent(messageEvent);
    }
}
