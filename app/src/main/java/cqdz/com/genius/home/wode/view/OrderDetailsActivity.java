package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.customer.DeleteConfirmDialog;
import cqdz.com.genius.home.shangcheng.model.CommodityModel;
import cqdz.com.genius.home.wode.adapter.MallOrderGoodsAdapter;
import cqdz.com.genius.home.wode.model.MallOrderModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class OrderDetailsActivity extends MvpBaseActivity implements View.OnClickListener {

    @BindView(R.id.imageView81)
    Button btn_left;
    @BindView(R.id.imageView84)
    Button btn_right;
    @BindView(R.id.state)
    ImageView iv_state;
    @BindView(R.id.recyclerView5)
    RecyclerView recyclerView;

    List<MallOrderModel.Response.Data.Child> orderList;
    MallOrderGoodsAdapter adapter;
    String state;
    DeleteConfirmDialog confirmDialog ;
    DeleteConfirmDialog confirmDialog2 ;
    String orderNum_Checked;
    @Override
    protected int getLayout() {
        return R.layout.activity_mallorder_details;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("订单详情");
        state = getIntent().getStringExtra("state");
        orderNum_Checked="订单编号";
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        switch (state) {
            case  "已发货":
                btn_left.setText("查看物流");
                btn_right.setText("确认收货");
                iv_state.setImageResource(R.drawable.ic_order_state6);
                break;
            case  "已付款":
                btn_left.setText("取消订单");
                btn_right.setText("提醒发货");
                iv_state.setImageResource(R.drawable.ic_order_state3);
                break;
            case  "已签收":
                btn_left.setText("删除订单");
                btn_right.setText("去评价");
                iv_state.setImageResource(R.drawable.ic_order_state2);
                break;
            case  "等待付款":
                btn_left.setText("删除订单");
                btn_right.setText("去付款");
                iv_state.setImageResource(R.drawable.ic_order_state1);
                break;
        }
        confirmDialog = new DeleteConfirmDialog(mContext, 123,  "确定删除该订单吗?", "确定删除", "我再想想", new DeleteConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if(requestCode==123)
                {
                    if(isPositive)
                    {

                        if(!TextUtils.isEmpty(orderNum_Checked))
                        {
                            mToast.showShort("点了一下左边"+orderNum_Checked);
                        }

                    }else {
                        mToast.showShort("点了一下右边");
                    }
                    confirmDialog.dismiss();
                }
            }
        });
        confirmDialog2 = new DeleteConfirmDialog(mContext, 124,  "确定取消该订单吗?", "确定取消", "我再想想", new DeleteConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if(requestCode==124)
                {
                    if(isPositive)
                    {
                        if(!TextUtils.isEmpty(orderNum_Checked))
                        {
                            mToast.showShort("点了一下左边"+orderNum_Checked);
                        }
                    }else {
                        mToast.showShort("点了一下右边");
                    }
                    confirmDialog2.dismiss();
                }
            }
        });

        orderList = new ArrayList<>();
        setData();
        adapter = new MallOrderGoodsAdapter(R.layout.item_mall_order_goods, orderList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(mContext, OrderDetailsActivity.class));
            }
        });

        recyclerView.setAdapter(adapter);//设置适配器
        //设置布局管理器 , 将布局设置成纵向
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager);
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

        CommodityModel.Response.Data data = new CommodityModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1548669869554&di=12bd391aec8fdf84e2d489c819b65e1d&imgtype=0&src=http%3A%2F%2Fimgq.duitang.com%2Fuploads%2Fitem%2F201503%2F12%2F20150312225658_3e3Sr.thumb.700_0.png");
        data.setIntroduction("欧式 水晶玻璃石材马赛克 厨房淋浴室装修材料 15*15");
        data.setNum("158人付款");
        data.setPrice("￥28.8");

//        adapter.notifyDataSetChanged();
//        onComplete();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView81:
                switch (state) {
                    case  "已发货":
                        mToast.showText("查看物流");
                        break;
                    case  "已付款":
                        confirmDialog2.show();
                        break;
                    case  "已签收":
                        confirmDialog.show();
                        break;
                    case  "等待付款":
                        confirmDialog2.show();
                        break;
                }
                break;
            case R.id.imageView84:
                //右边按钮
                switch (state) {
                    case  "已发货":
                        mToast.showText("确认收货");
                        startActivity(new Intent(mContext,MallOrderLogisticsActivity.class));

                        break;
                    case  "已付款":
                        mToast.showText("成功提醒卖家发货");
                        break;
                    case  "已签收":
                        startActivity(new Intent(mContext,EvaluateActivity.class));
                        break;
                    case  "等待付款":
                        mToast.showText("去付款");
                        break;
                }
                break;
        }
    }
}
