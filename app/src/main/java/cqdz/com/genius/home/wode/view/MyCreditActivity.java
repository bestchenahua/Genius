package cqdz.com.genius.home.wode.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.LeaningBeansAdapter;
import cqdz.com.genius.home.wode.model.LeaningBeansModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyCreditActivity extends MvpBaseActivity {

    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<LeaningBeansModel.Response.Data> mList;
    LeaningBeansAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_learningbeans2;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("学分");
        mList = new ArrayList<>();
        setList();
        adapter = new LeaningBeansAdapter(R.layout.item_learningbeans,mList);
        recyclerView.setAdapter(adapter);//设置适配器
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager);
    }
    public void setList()
    {
        LeaningBeansModel.Response.Data data = new LeaningBeansModel.Response.Data();
        data.setDate("2018-11-02");
        data.setMoney("4分");
        data.setName("测试");
        data.setType(0);
        LeaningBeansModel.Response.Data data2 = new LeaningBeansModel.Response.Data();
        data2.setDate("2018-11-02");
        data2.setMoney("4分");
        data2.setName("观看视频");
        data2.setType(0);
        mList.add(data);
        mList.add(data2);
        mList.add(data);
        mList.add(data2);
    }
}
