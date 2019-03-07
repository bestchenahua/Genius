package cqdz.com.genius.home.wode.view;

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
import cqdz.com.genius.home.shangcheng.adapter.FirmOrderPayMethodAdapter;
import cqdz.com.genius.home.shangcheng.model.FirmOrderPayMethodModel;
import cqdz.com.genius.home.wode.adapter.LeaningBeansAdapter;
import cqdz.com.genius.home.wode.model.LeaningBeansModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class MyLearningRechargeActivity extends MvpBaseActivity {

    @BindView(R.id.btn_goRecharge)
    Button btn_goRecharge;
    FirmOrderPayMethodAdapter payMethodAdapter;
    List<FirmOrderPayMethodModel.Response.Data> payMethods;
    @BindView(R.id.recyclerView)
    RecyclerView payMethod_RecyclerView;

    @Override
    protected int getLayout() {
        return R.layout.activity_learningrecharge;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("学习豆充值");
        btn_goRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        payMethods = new ArrayList<>();
        setMethods();
        payMethodAdapter = new FirmOrderPayMethodAdapter(R.layout.item_firmorder_paymethod,payMethods);
        payMethodAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                FirmOrderPayMethodAdapter adapter1 = (FirmOrderPayMethodAdapter)adapter;
                adapter1.setCheckedPosition(position);
            }
        });
        payMethod_RecyclerView.setAdapter(payMethodAdapter);//设置适配器
        LinearLayoutManager linerLayoutManager2 = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        payMethod_RecyclerView.setLayoutManager(linerLayoutManager2);
    }
    public void setMethods()
    {
        FirmOrderPayMethodModel.Response.Data data = new FirmOrderPayMethodModel.Response.Data();
        data.setName("微信支付");
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547310754851&di=7115d73bf84a0a7b0df21cdc58b4e552&imgtype=0&src=http%3A%2F%2Fgbres.dfcfw.com%2FFiles%2Fpicture%2F20170306%2Fsize500%2F9FEA9AB789FA665C3418A84E561F3FCB.jpg");
        payMethods.add(data);
        payMethods.add(data);
        payMethods.add(data);
    }
}
