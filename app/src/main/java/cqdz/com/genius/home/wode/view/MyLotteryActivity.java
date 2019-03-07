package cqdz.com.genius.home.wode.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.LotteryAdapter;
import cqdz.com.genius.home.wode.model.LotteryModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyLotteryActivity extends MvpBaseActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    LotteryAdapter adapter;
    List<LotteryModel.Response.Data> mList;
    @Override
    protected int getLayout() {
        return R.layout.activity_lottery;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("我的奖券");
        mList = new ArrayList<>();
        setData();
        adapter = new LotteryAdapter(R.layout.item_lottery,mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }
    public void setData()
    {
        LotteryModel.Response.Data data = new LotteryModel.Response.Data();
        data.setMoney("￥20");
        data.setName("10元奖券");
        data.setTime("还有1天过期，有效期至：2019-02-05");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);

    }
}
