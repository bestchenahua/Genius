package cqdz.com.genius.home.wode.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.Currency2Adapter;
import cqdz.com.genius.home.wode.adapter.LeaningBeansAdapter;
import cqdz.com.genius.home.wode.model.Currency2Model;
import cqdz.com.genius.home.wode.model.LeaningBeansModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyLearningCurrency2Activity extends MvpBaseActivity {

    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefresh;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    List<Currency2Model.Response.Data> mList;
    Currency2Adapter adapter;
    @Override
    protected int getLayout() {
        return R.layout.activity_learningcurrency2;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("学习币");
        mList = new ArrayList<>();
        setList();
        adapter = new Currency2Adapter(R.layout.item_learningcurrency2,mList);
        recyclerView.setAdapter(adapter);//设置适配器
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager);
    }
    public void setList()
    {
        Currency2Model.Response.Data data = new Currency2Model.Response.Data();
        data.setImg("http://pic1.nipic.com/2008-12-30/200812308231244_2.jpg");
        data.setMoney("5000枚");
        data.setName("直播");
        data.setType(0);
        Currency2Model.Response.Data data2 = new Currency2Model.Response.Data();
        data.setImg("http://pic1.nipic.com/2008-12-30/200812308231244_2.jpg");
        data2.setMoney("5000枚");
        data2.setName("提现");
        data2.setType(1);
        mList.add(data);
        mList.add(data2);
        mList.add(data);
        mList.add(data2);
    }
}
