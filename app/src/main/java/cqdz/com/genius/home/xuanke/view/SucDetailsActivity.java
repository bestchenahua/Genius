package cqdz.com.genius.home.xuanke.view;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.view.FillOrderActivity;
import cqdz.com.genius.home.view.OrderPayActivity;
import cqdz.com.genius.home.view.TeacherInfoActivity;
import cqdz.com.genius.home.xuanke.adapter.DaGangAdapter;
import cqdz.com.genius.home.xuanke.adapter.OneIVAdapter;
import cqdz.com.genius.home.xuanke.model.DaGangModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 速成班详情
 */
public class SucDetailsActivity extends MvpBaseActivity implements View.OnClickListener {
    //    @BindView(R.id.tab)
//    TabLayout tab;
    @BindView(R.id.scrollablelayout)
    ScrollableLayout scrollablelayout;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_bar_content)
    ImageView titleBarContent;
    @BindView(R.id.tv_collection)
    TextView tv_collection;
    @BindView(R.id.tv_dagang)
    TextView tv_dagang;
    @BindView(R.id.tv_kefu)
    TextView tv_kefu;
    @BindView(R.id.btn_toPay)
    Button btn_toPay;

    @BindView(R.id.tv_xuanK)
    TextView tv_xuanK;

    @BindView(R.id.tv_baoM)
    TextView tv_baoM;

    @BindView(R.id.ll_teacher)
    LinearLayout ll_teacher;

    @BindView(R.id.recyclerView_daGang)
    RecyclerView recyclerView_daGang;

    DaGangAdapter adapter;

    List<DaGangModel.Response.Data> daGangs;


    @BindView(R.id.recyclerView_xiangQing)
    RecyclerView recyclerView_xiangQing;

    OneIVAdapter adapter2;

    List<String> details;

    @Override
    protected int getLayout() {
        return R.layout.activity_suc_details;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        initView();

        daGangs = new ArrayList<>();
        details = new ArrayList<>();
        setDaGang();
        adapter = new DaGangAdapter(R.layout.item_suc_details_dagang, daGangs);

        recyclerView_daGang.setAdapter(adapter);
        recyclerView_daGang.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));


        adapter2 = new OneIVAdapter(R.layout.item_suc_details_oneiv, details);

        recyclerView_xiangQing.setAdapter(adapter2);

        recyclerView_xiangQing.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false));

        recyclerView_xiangQing.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollablelayout.getHelper().setCurrentScrollableContainer(new ScrollableHelper.ScrollableContainer() {
                    @Override
                    public View getScrollableView() {
                        return recyclerView_xiangQing;
                    }
                });
                return false;
            }
        });
        recyclerView_daGang.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                scrollablelayout.getHelper().setCurrentScrollableContainer(new ScrollableHelper.ScrollableContainer() {
                    @Override
                    public View getScrollableView() {
                        return recyclerView_daGang;
                    }
                });
                return false;
            }
        });
    }

    public void setDaGang() {
        DaGangModel.Response.Data data = new DaGangModel.Response.Data();
        data.setDate("2月13日·周三·10:00-10:45");
        data.setDay("第1天");
        data.setName("【快乐阅读】《小猪唏哩呼噜》");
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
        String imgUrl = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1551262753954&di=15d057351245a0e435579c32e58b2382&imgtype=0&src=http%3A%2F%2Fwww.pptbz.com%2Fpptpic%2FUploadFiles_6909%2F201203%2F2012031220134655.jpg";
        details.add(imgUrl);
        details.add(imgUrl);
        details.add(imgUrl);
        details.add(imgUrl);
    }

    private void initView() {
        titleBarContent.setOnClickListener(this);
        tv_collection.setOnClickListener(this);
        btn_toPay.setOnClickListener(this);
        tv_xuanK.setOnClickListener(this);
        tv_baoM.setOnClickListener(this);
        ll_teacher.setOnClickListener(this);
        btn_toPay.setText("去上课");
//        initBanner();
//        initTabLayout();
//        initFragment();
        title.setBackgroundColor(Color.argb((int) 0, 0, 0, 0));
        titleBarTitle.setTextColor(Color.argb((int) 255, 198, 166, 102));
        initOnClickScroll();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_toPay:
                if (btn_toPay.getText().toString().trim().equals("去上课")) {
                    startActivity(new Intent(mContext, AttendClassActivity.class));
                } else {
                    startActivity(new Intent(mContext, OrderPayActivity.class));

                }
                break;
            case R.id.tv_xuanK:

                break;
            case R.id.tv_baoM:
                startActivity(new Intent(mContext, FillOrderActivity.class));
                break;
            case R.id.ll_teacher:
                startActivity(new Intent(mContext, TeacherInfoActivity.class));
                break;
        }
    }

    /*滚动监听*/
    private void initOnClickScroll() {
        scrollablelayout.setOnScrollListener(new ScrollableLayout.OnScrollListener() {
            @Override
            public void onScroll(int i, int i1) {
                float scale = (float) i1 - i;
                float alpha = (255 * scale);
                float alpha2 = scale / i1 * 150;
                float alphaTv = scale / i1 * 250;
                float alpha3 = (float) i / i1 * 130;

                float alphaTop = (float) i / i1 * 180;
                LinearLayout.LayoutParams lp = new
                        LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

                lp.setMargins(0, (int) alphaTop, 0, 0);

                tv_dagang.setLayoutParams(lp);
                if (i == i1) {
                    titleBarTitle.setText("二年级语文字词句综合班");
                    titleBarTitle.setTextColor(Color.parseColor("#50D8C0"));
                } else if (i < i1) {
                    titleBarTitle.setText("");
                    titleBarTitle.setTextColor(Color.argb((int) 255, 198, 166, 102));
                }
                if (i < i1) {
                    title.setVisibility(View.VISIBLE);
                }
                //img设置渐变
                float f = (float) i / i1; //0-1递增
                float f1 = scale / i1;   //1-0递减
//                titleBarBack.setAlpha(f1);

//                0-100递增偏移量
//                titleBarBack.scrollTo((int) alpha3, 0);
//                titleBarBack.setPadding((int) scale / i1 * 100, 12, 0, 8);
                //通过距离设置渐变效果
//                title.setBackgroundColor(Color.argb((int) alpha2, 0, 0, 0));
                titleBarTitle.setTextColor(Color.argb((int) alphaTv - 1, 45, 183, 181));
//                titleBarContent.setTextColor(Color.argb((int) alphaTv, 198, 166, 102));

            }
        });
    }


}
