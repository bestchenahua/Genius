package cqdz.com.genius.home.wode.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.MyFollowAdapter;
import cqdz.com.genius.home.wode.model.MyFollowModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyFollowActivity extends MvpBaseActivity {
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<MyFollowModel.Response.Data> mList;

    MyFollowAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_myfollow;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("我的关注");
        mList = new ArrayList<>();
        setData();
        adapter = new MyFollowAdapter(R.layout.item_follow,mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }

    private void setData() {
        MyFollowModel.Response.Data data = new MyFollowModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551860731158&di=5ecdc316497f09e653720381ed4272b5&imgtype=0&src=http%3A%2F%2Fimg3.redocn.com%2Ftupian%2F20150318%2Fshengdanquanbiankuangsucai_4020876.jpg");
        data.setIsFollow("0");
        data.setName("张三");

        MyFollowModel.Response.Data data2 = new MyFollowModel.Response.Data();
        data2.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551860731158&di=5ecdc316497f09e653720381ed4272b5&imgtype=0&src=http%3A%2F%2Fimg3.redocn.com%2Ftupian%2F20150318%2Fshengdanquanbiankuangsucai_4020876.jpg");
        data2.setIsFollow("1");
        data2.setName("李四");

        mList.add(data);
        mList.add(data2);
        mList.add(data);
        mList.add(data2);
        mList.add(data);
        mList.add(data2);
    }
}
