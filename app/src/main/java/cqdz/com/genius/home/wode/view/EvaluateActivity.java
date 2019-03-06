package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.MallOrderGoodsAdapter;
import cqdz.com.genius.home.wode.model.MallOrderModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SoftHideKeyBoardUtil;

/**
 * 商城订单-评价
 */
public class EvaluateActivity extends MvpBaseActivity implements View.OnClickListener {

    @BindView(R.id.tv_comment_good)
    TextView tv_comment_good;
    @BindView(R.id.tv_comment_normal)
    TextView tv_comment_normal;
    @BindView(R.id.tv_comment_bad)
    TextView tv_comment_bad;

    @BindView(R.id.ed_pingjia)
    EditText ed_pingjia;

    @BindView(R.id.recyclerView5)
    RecyclerView recyclerView;

    List<MallOrderModel.Response.Data.Child> orderList;
    MallOrderGoodsAdapter adapter;

    Drawable evaluate_good;
    Drawable evaluate_normal;
    Drawable evaluate_bad;
    Drawable evaluate_good_on;
    Drawable evaluate_normal_on;
    Drawable evaluate_bad_on;

    @Override
    protected int getLayout() {
        return R.layout.activity_evaluate;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        SoftHideKeyBoardUtil.assistActivity(this);
        action_bar_title.setText("评价");
        getDrawable();
        tv_comment_good.setOnClickListener(this);
        tv_comment_normal.setOnClickListener(this);
        tv_comment_bad.setOnClickListener(this);
        ed_pingjia.setOnTouchListener(
                new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //触摸的是EditText并且当前EditText可以滚动则将事件交给EditText处理；否则将事件交由其父类处理   && canVerticalScroll(workExceptionEdit)     
                if ((v.getId() == R.id.ed_pingjia))
                {
                    v.getParent().requestDisallowInterceptTouchEvent(true);
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                    }
                }
                return false;
            }
        });

        orderList = new ArrayList<>();

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
        setData();

    }
    public void getDrawable()
    {
        evaluate_good = mContext.getResources().getDrawable(R.drawable.evaluate_good);
        evaluate_good.setBounds(0, 0, evaluate_good.getMinimumWidth(), evaluate_good.getMinimumHeight());

        evaluate_normal = mContext.getResources().getDrawable(R.drawable.evaluate_normal);
        evaluate_normal.setBounds(0, 0, evaluate_normal.getMinimumWidth(), evaluate_normal.getMinimumHeight());

        evaluate_bad = mContext.getResources().getDrawable(R.drawable.evaluate_bad);
        evaluate_bad.setBounds(0, 0, evaluate_bad.getMinimumWidth(), evaluate_bad.getMinimumHeight());

        evaluate_good_on = mContext.getResources().getDrawable(R.drawable.evaluate_good_on);
        evaluate_good_on.setBounds(0, 0, evaluate_good_on.getMinimumWidth(), evaluate_good_on.getMinimumHeight());

        evaluate_normal_on = mContext.getResources().getDrawable(R.drawable.evaluate_normal_on);
        evaluate_normal_on.setBounds(0, 0, evaluate_good.getMinimumWidth(), evaluate_normal_on.getMinimumHeight());

        evaluate_bad_on = mContext.getResources().getDrawable(R.drawable.evaluate_bad_on);
        evaluate_bad_on.setBounds(0, 0, evaluate_bad_on.getMinimumWidth(), evaluate_bad_on.getMinimumHeight());
    }
    public void swichComment(int viewID)
    {
        tv_comment_good.setTextColor(Color.parseColor("#8E8E8E"));
        tv_comment_good.setCompoundDrawables(evaluate_good,null,null,null);

        tv_comment_normal.setTextColor(Color.parseColor("#8E8E8E"));
        tv_comment_normal.setCompoundDrawables(evaluate_normal,null,null,null);

        tv_comment_bad.setTextColor(Color.parseColor("#8E8E8E"));
        tv_comment_bad.setCompoundDrawables(evaluate_bad,null,null,null);
        switch (viewID) {
            case  R.id.tv_comment_good:
                tv_comment_good.setTextColor(Color.parseColor("#FF8600"));
                tv_comment_good.setCompoundDrawables(evaluate_good_on,null,null,null);
                break;
            case  R.id.tv_comment_normal:
                tv_comment_normal.setTextColor(Color.parseColor("#FF8600"));
                tv_comment_normal.setCompoundDrawables(evaluate_normal_on,null,null,null);
                break;
            case  R.id.tv_comment_bad:
                tv_comment_bad.setTextColor(Color.parseColor("#FF8600"));
                tv_comment_bad.setCompoundDrawables(evaluate_bad_on,null,null,null);
                break;
        }
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
        adapter.notifyDataSetChanged();
//        onComplete();
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case  R.id.tv_comment_good:
            case  R.id.tv_comment_normal:
            case  R.id.tv_comment_bad:
                swichComment(v.getId());
                break;
        }
    }
}
