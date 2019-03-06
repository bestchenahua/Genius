package cqdz.com.genius.home.shangcheng.view;
import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.customer.ShareBottomDialog;
import cqdz.com.genius.home.shangcheng.adapter.SpecialAdapter;
import cqdz.com.genius.home.shangcheng.customer.BuyGoodsDialog;
import cqdz.com.genius.home.shangcheng.model.SpecialModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class CommodityDetailsActivity extends MvpBaseActivity implements View.OnClickListener {
    @BindView(R.id.tab)
    TabLayout tab;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.scrollablelayout)
    ScrollableLayout scrollablelayout;
    @BindView(R.id.title)
    RelativeLayout title;
    @BindView(R.id.title_bar_back)
    ImageView titleBarBack;
    @BindView(R.id.title_bar_title)
    TextView titleBarTitle;
    @BindView(R.id.title_bar_content)
    ImageView titleBarContent;
    @BindView(R.id.btn_goin)
    ImageView btn_goin;
    @BindView(R.id.ll_danDu)
    LinearLayout ll_danDu;
    @BindView(R.id.gopd)
    LinearLayout ll_gopd;
    //    @BindView(R.id.chakan)
//    TextView chakan;
    @BindView(R.id.recyclerView_pd)
    RecyclerView recyclerView_pd;
    @BindView(R.id.tv_collection)
    TextView tv_collection;
    @BindView(R.id.tv_kefu)
    TextView tv_kefu;

    private String[] titles;
    List<Fragment> fragmentList;
    List<SpecialModel.Response.Data> mList;
    SpecialAdapter adapter;

    FragmentPagerAdapter adapterVP;
    ShareBottomDialog dialog;
//    PinDanDialog dialog_pd;
    BuyGoodsDialog dialog_buy;
    BuyGoodsDialog.Data dialogData;

    @Override
    protected int getLayout() {
        return R.layout.activity_commodity2_details;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        titles = new String[]{"商品详情", "商品评价(256)"};
        fragmentList = new ArrayList<>();
        initView();
        dialog = new ShareBottomDialog();
//        dialog_pd = new PinDanDialog(mContext);

        dialogData = new BuyGoodsDialog.Data();
        setDiaLogData();
        dialog_buy = BuyGoodsDialog.getInstance(dialogData, new BuyGoodsDialog.confirmCallBack() {
            @Override
            public void callBack() {
                startActivity(new Intent(mContext, FirmOrderActivity.class));
            }
        });

        mList = new ArrayList<>();
        setList();
        adapter = new SpecialAdapter(R.layout.item_special, mList);
        recyclerView_pd.setAdapter(adapter);//设置适配器
        recyclerView_pd.setLayoutManager(new GridLayoutManager(mContext, 3));
//        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false);
//
//        recyclerView_pd.setLayoutManager(linerLayoutManager);
    }

    private void setDiaLogData() {
        dialogData.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547014067452&di=45ebebd10fb077da64e706df11673ca0&imgtype=0&src=http%3A%2F%2Fimg13.360buyimg.com%2Fn0%2Fjfs%2Ft1984%2F308%2F847009781%2F55715%2F31b8127f%2F562cd990N7ecabae8.jpg");
        dialogData.setPrice("￥998");

        BuyGoodsDialog.Data.Child child1 = new BuyGoodsDialog.Data.Child();
        child1.setName("型号");
        List<String> xinhao = new ArrayList<>();
        xinhao.add("A001");
        xinhao.add("A002");
        xinhao.add("A003");
        xinhao.add("A004");
        xinhao.add("A005");
        xinhao.add("A006");
        child1.setDetails(xinhao);

        BuyGoodsDialog.Data.Child child2 = new BuyGoodsDialog.Data.Child();
        child2.setName("颜色");
        List<String> xinhao2 = new ArrayList<>();
        xinhao2.add("白色");
        xinhao2.add("蓝色");
        xinhao2.add("黄色");
        xinhao2.add("橙色");
        xinhao2.add("绿色");
        xinhao2.add("紫色");
        child2.setDetails(xinhao2);

        dialogData.setChild1(child1);
        dialogData.setChild2(child2);
    }

    private void setList() {
        SpecialModel.Response.Data data = new SpecialModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547014067452&di=45ebebd10fb077da64e706df11673ca0&imgtype=0&src=http%3A%2F%2Fimg13.360buyimg.com%2Fn0%2Fjfs%2Ft1984%2F308%2F847009781%2F55715%2F31b8127f%2F562cd990N7ecabae8.jpg");
        data.setName("么么哒");
        mList.add(data);
        mList.add(data);
        mList.add(data);
//        mList.add(data);
    }

    private void initView() {
        titleBarBack.setOnClickListener(this);
        titleBarContent.setOnClickListener(this);
//        chakan.setOnClickListener(this);
        btn_goin.setOnClickListener(this);
        ll_danDu.setOnClickListener(this);
        ll_gopd.setOnClickListener(this);
        tv_collection.setOnClickListener(this);
        initTabLayout();
        initFragment();
        title.setBackgroundColor(Color.argb((int) 0, 0, 0, 0));
        titleBarTitle.setTextColor(Color.argb((int) 255, 198, 166, 102));
        initOnClickScroll();
    }


    /*初始化tab标签*/
    private void initTabLayout() {

        for (int i = 0; i < titles.length; i++) {
            tab.addTab(tab.newTab().setText(titles[i]));
        }

    }

    private void initFragment() {
        CommodityDetailsFragment fragment1 = new CommodityDetailsFragment();
        CommodityEvaluationFragment fragment2 = new CommodityEvaluationFragment();
        fragmentList.add(fragment1);
        fragmentList.add(fragment2);

        adapterVP = new ViewPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(adapterVP);
        tab.setupWithViewPager(vp);
        scrollablelayout.getHelper().setCurrentScrollableContainer((CommodityDetailsFragment) fragmentList.get(0));
        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == 0) {
                    scrollablelayout.getHelper().setCurrentScrollableContainer((CommodityDetailsFragment) fragmentList.get(i));
                } else if (i == 1) {
                    scrollablelayout.getHelper().setCurrentScrollableContainer((CommodityEvaluationFragment) fragmentList.get(i));
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
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

                tab.setLayoutParams(lp);
                if (i == i1) {
                    titleBarTitle.setText("蓝天豚水性硅藻泥");
                    titleBarTitle.setTextColor(Color.parseColor("#2DB7B5"));
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_bar_back:
                finish();
                break;
            case R.id.title_bar_content:
                dialog.show(getSupportFragmentManager());
                break;
//            case R.id.chakan:
//                dialog_pd.show();
//                break;
            case R.id.btn_goin:
                startActivity(new Intent(mContext, ShopActivity.class));
                break;
            case R.id.ll_danDu:
                mToast.showTextWithPic("添加成功，在购物车等您哦~");
                break;
            case R.id.gopd:
//                startActivity(new Intent(mContext, FirmOrderActivity.class));
                dialog_buy.show(getSupportFragmentManager());
                break;
            case R.id.tv_collection:
                mToast.showText("已收藏，请在个人中心查看");
                break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
