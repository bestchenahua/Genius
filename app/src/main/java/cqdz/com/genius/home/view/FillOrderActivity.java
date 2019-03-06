package cqdz.com.genius.home.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.adapter.XuanKeOrderAdapter;
import cqdz.com.genius.home.xuanke.model.XuanKeOrderModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class FillOrderActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.btn_sub)
    Button btn_sub;
    @BindView(R.id.ll_addr)
    LinearLayout ll_addr;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    XuanKeOrderAdapter adapter;
    List<XuanKeOrderModel.Response.Data> mList;
    @Override
    protected int getLayout() {
        return R.layout.activity_fillorder;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("填写订单");
        btn_sub.setOnClickListener(this);
        ll_addr.setOnClickListener(this);
        mList = new ArrayList<>();
        setData();
        adapter = new XuanKeOrderAdapter(R.layout.item_xuanke_order,mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }
    public void setData()
    {
        XuanKeOrderModel.Response.Data data = new XuanKeOrderModel.Response.Data();
        data.setPrice("100（学习币300枚）");
        data.setTime("2月12日-2月19日·每天·10:00-10:45·5课时");
        data.setTitle("【2019年寒】二年级语文字词句综合班");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_sub:
                break;
            case R.id.ll_addr:
                startActivity(new Intent(mContext,ChooseAddressActivity.class));
                break;
        }
    }
}
