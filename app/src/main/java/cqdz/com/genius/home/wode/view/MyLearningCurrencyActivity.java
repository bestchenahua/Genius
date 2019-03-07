package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.LeaningBeansAdapter;
import cqdz.com.genius.home.wode.model.LeaningBeansModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyLearningCurrencyActivity extends MvpBaseActivity {

    @BindView(R.id.btn_getCash)
    Button btn_getCash;
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<LeaningBeansModel.Response.Data> mList;
    LeaningBeansAdapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_learningcurrency;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("学习币");
        btn_getCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,MyLearningCurrency3Activity.class));
            }
        });
        mList = new ArrayList<>();
        setList();
        adapter = new LeaningBeansAdapter(R.layout.item_learningcurrency,mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext,MyLearningCurrency2Activity.class));
            }
        });
        recyclerView.setAdapter(adapter);//设置适配器
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager);
    }
    public void setList()
    {
        LeaningBeansModel.Response.Data data = new LeaningBeansModel.Response.Data();
        data.setDate("2018-11-02");
        data.setMoney("5000枚");
        data.setName("直播");
        data.setType(0);
        LeaningBeansModel.Response.Data data2 = new LeaningBeansModel.Response.Data();
        data2.setDate("2018-11-02");
        data2.setMoney("5000枚");
        data2.setName("提现");
        data2.setType(1);
        mList.add(data);
        mList.add(data2);
        mList.add(data);
        mList.add(data2);
    }
}
