package cqdz.com.genius.home.wode.adapter;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.MallOrderModel;

public class MallOrderAdapter extends BaseQuickAdapter<MallOrderModel.Response.Data, BaseViewHolder> {
    public MallOrderAdapter(int layoutResId, @Nullable List<MallOrderModel.Response.Data> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, MallOrderModel.Response.Data item) {
        if(!TextUtils.isEmpty(item.getName()))
        {
            helper.setText(R.id.textView120,item.getName());
        }
        if(!TextUtils.isEmpty(item.getOrderNum()))
        {
            helper.setText(R.id.tv_orderNum,item.getOrderNum());
        }

        if(!TextUtils.isEmpty(item.getStatus()))
        {
            helper.setText(R.id.textView121,item.getStatus());
            switch (item.getStatus()) {
                case  "已发货":
                    helper.setText(R.id.imageView81,"查看物流");
                    helper.setText(R.id.imageView84,"确认收货");
                    break;
                case  "已付款":
                    helper.setText(R.id.imageView81,"取消订单");
                    helper.setText(R.id.imageView84,"提醒发货");
                    break;
                case  "已签收":
                    helper.setText(R.id.imageView81,"删除订单");
                    helper.setText(R.id.imageView84,"去评价");
                    break;
                case  "等待付款":
                    helper.setText(R.id.imageView81,"取消订单");
                    helper.setText(R.id.imageView84,"去付款");
                    break;
            }
            helper.addOnClickListener(R.id.imageView81);
            helper.addOnClickListener(R.id.imageView84);
        }
        if(!TextUtils.isEmpty(item.getTotalPrice()))
        {
            helper.setText(R.id.textView123,item.getTotalPrice());
        }
        if(item.getChildList().size()>0)
        {
            RecyclerView recyclerView = helper.getView(R.id.recyclerView7);
            helper.addOnClickListener(R.id.recyclerView7);
            MallOrderGoodsAdapter adapter ;
            adapter = new MallOrderGoodsAdapter(R.layout.item_mall_order_goods, item.getChildList());
//            adapter.setOnItemChildClickListener(new OnItemChildClickListener() {
//                @Override
//                public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                    switch (view.getId()) {
////                        case R.id.ll_liuyan:
////                            mContext.startActivity(new Intent(mContext, CircleCommentActivity.class));
////                            break;
//                    }
//                }
//            });
            recyclerView.setAdapter(adapter);//设置适配器
            //设置布局管理器 , 将布局设置成纵向
            LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
            recyclerView.setLayoutManager(linerLayoutManager);
        }
    }
}
