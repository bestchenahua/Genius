package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import cqdz.com.genius.home.view.OrderPayActivity;
import cqdz.com.genius.home.view.PayActivity;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class ShoppingCartOrder extends MvpBaseActivity implements View.OnClickListener {
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

    @BindView(R.id.recyclerView5)
    RecyclerView goods_RecyclerView;

    @BindView(R.id.pay)
    Button btnPay;

    FirmOrderGoodsAdapter goodsAdapter;

    List<FirmOrderGoodsModel.Response.Data> orderGoods;
    CustomerConfirmDialog confirmDialog ;

    @Override
    protected int getLayout() {
        return R.layout.activity_shopcart_order;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("确认订单");
        btnPay.setOnClickListener(this);

        confirmDialog = new CustomerConfirmDialog(mContext, 123, "确认要放弃付款码?", "未支付订单将在不久后关闭,请尽快支付~", "继续支付", "暂时放弃", new CustomerConfirmDialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isPositive) {
                if(requestCode==123)
                {
                    if(isPositive)
                    {
                        mToast.showShort("点击了一下继续");
                    }else {
                        mToast.showShort("点击了一下放弃");
                    }
                    confirmDialog.dismiss();
                }
            }
        });
        shopImg.setImageResource(R.drawable.test3);
        shopName.setText("云之尚家居专营店");
        orderGoods = new ArrayList<>();
        setGoods();
        goodsAdapter = new FirmOrderGoodsAdapter(R.layout.item_firmorder_goods,orderGoods);
        goods_RecyclerView.setAdapter(goodsAdapter);//设置适配器
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        goods_RecyclerView.setLayoutManager(linerLayoutManager);
    }
    public void setGoods()
    {
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
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.pay:
                startActivity(new Intent(mContext,PayActivity.class));
                break;
        }
    }
}
