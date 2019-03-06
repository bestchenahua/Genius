package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.view.CommodityDetailsActivity;
import cqdz.com.genius.home.wode.adapter.LogisticsAdapter;
import cqdz.com.genius.home.wode.adapter.MallOrderGoodsAdapter;
import cqdz.com.genius.home.wode.model.LogisticsModel;
import cqdz.com.genius.home.wode.model.MallOrderModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 物流信息
 */
public class MallOrderLogisticsActivity extends MvpBaseActivity {
    @BindView(R.id.recyclerView7)
    RecyclerView recyclerView;

    List<MallOrderModel.Response.Data.Child> orderList;
    MallOrderGoodsAdapter adapter;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView2;
    LogisticsAdapter adapter2;
    List<LogisticsModel.Response.Data> mList;

    @Override
    protected int getLayout() {
        return R.layout.activity_mallorder_logistics;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("物流信息");

        orderList = new ArrayList<>();
        mList = new ArrayList<>();
        setData();
        adapter = new MallOrderGoodsAdapter(R.layout.item_mall_order_goods, orderList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(mContext, OrderDetailsActivity.class));//订单详情
                startActivity(new Intent(mContext, EvaluateActivity.class));//评价

            }
        });

        recyclerView.setAdapter(adapter);//设置适配器
        //设置布局管理器 , 将布局设置成纵向
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager);

        adapter2 = new LogisticsAdapter(R.layout.item_logistics, mList);
        adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                startActivity(new Intent(mContext, CommodityDetailsActivity.class));
            }
        });
        recyclerView2.setAdapter(adapter2);//设置适配器
        //设置布局管理器 , 将布局设置成纵向
        recyclerView2.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false));
    }

    public void setData() {
        orderList.clear();
        MallOrderModel.Response.Data.Child child = new MallOrderModel.Response.Data.Child();
        List<MallOrderModel.Response.Data.Child> children = new ArrayList<>();
        child.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1549880252281&di=799ab77a7543428c0ba70c81bad65607&imgtype=0&src=http%3A%2F%2Fpic1.16pic.com%2F00%2F50%2F63%2F16pic_5063889_b.jpg");
        child.setName("纳米天使 水性硅藻泥");
        child.setIntroduction("2000ml");
        child.setPrice("￥798");
        child.setNum(2);
        children.add(child);
        children.add(child);
        orderList.addAll(children);

        LogisticsModel.Response.Data data = new LogisticsModel.Response.Data();
        data.setContent("【镇州市】快件离开，发往【重庆中转】，现已在重庆");
        data.setTime("2018-11-11 22:05:26");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
//        adapter.notifyDataSetChanged();
//        onComplete();
    }
}
