package cqdz.com.genius.home.shangcheng.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.adapter.FirmOrderGoodsAdapter;
import cqdz.com.genius.home.shangcheng.customer.CustomerConfirmDialog;
import cqdz.com.genius.home.shangcheng.model.FirmOrderGoodsModel;
import cqdz.com.genius.home.shangcheng.model.FirmOrderPayMethodModel;
import cqdz.com.genius.home.view.ChooseAddressActivity;
import cqdz.com.genius.home.view.PayActivity;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class FirmOrderActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.textView73)
    TextView name;
    @BindView(R.id.textView75)
    TextView tel;
    @BindView(R.id.addr)
    TextView addr;
    @BindView(R.id.linearLayout48)
    LinearLayout linearLayout48;
    @BindView(R.id.shopImg)
    ImageView shopImg;
    @BindView(R.id.shopName)
    TextView shopName;
    @BindView(R.id.price)
    TextView price;
    @BindView(R.id.remarks)
    TextView remarks;
    @BindView(R.id.recyclerView5)
    RecyclerView goods_RecyclerView;

    @BindView(R.id.pay)
    Button btnPay;

    FirmOrderGoodsAdapter goodsAdapter;


    List<FirmOrderGoodsModel.Response.Data> orderGoods;
    CustomerConfirmDialog confirmDialog;

    @Override
    protected int getLayout() {
        return R.layout.activity_firm_order;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
//        actionbar_title.setText("确认订单");
        action_bar_title.setText("确认订单");
        btnPay.setOnClickListener(this);
        linearLayout48.setOnClickListener(this);
        confirmDialog = new CustomerConfirmDialog(mContext, 123, "确认要放弃付款码?", "未支付订单将在不久后关闭,请尽快支付~", "继续支付", "暂时放弃", new CustomerConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if (requestCode == 123) {
                    if (isPositive) {
                        mToast.showShort("点击了一下继续");
                    } else {
//     mToast.showShort("点击了一下放弃");
                        finish();
                    }
                    confirmDialog.dismiss();
                }
            }
        });

        shopImg.setImageResource(R.drawable.test1);
        shopName.setText("云之尚家居专营店");


        orderGoods = new ArrayList<>();

        setGoods();

        goodsAdapter = new FirmOrderGoodsAdapter(R.layout.item_firmorder_goods, orderGoods);


        goods_RecyclerView.setAdapter(goodsAdapter);//设置适配器
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        goods_RecyclerView.setLayoutManager(linerLayoutManager);


    }

    public void setGoods() {
        FirmOrderGoodsModel.Response.Data data = new FirmOrderGoodsModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547310754848&di=2e56be95577bafb78387b57e4c124018&imgtype=0&src=http%3A%2F%2Fimg3.redocn.com%2F20100622%2F20100621_8c78a30dc5c10ef5552cwCXmHvkvaDCT.jpg");
        data.setColor("颜色:黄色");
        data.setModel("型号:A0002");
        data.setName("纳米天使 水性硅藻泥");
        data.setPrice("￥798");
        data.setNum("1");
        orderGoods.add(data);
        orderGoods.add(data);
    }

    @Override
    public void goBack(View view) {
        confirmDialog.show();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
//                break;
                confirmDialog.show();
                return false;//拦截事件
            case KeyEvent.KEYCODE_MENU:
                break;
            case KeyEvent.KEYCODE_HOME:
                // 收不到
                break;
            case KeyEvent.KEYCODE_APP_SWITCH:
                // 收不到
                break;
            default:
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pay:
//                confirmDialog.show();
                startActivity(new Intent(mContext, PayActivity.class));
                break;
            case R.id.linearLayout48:
                startActivity(new Intent(mContext, ChooseAddressActivity.class));
                break;
        }
    }
}
