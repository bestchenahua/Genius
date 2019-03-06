package cqdz.com.genius.home.shangcheng.view;

import android.support.design.widget.TabLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.cpoopc.scrollablelayoutlib.ScrollableLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.adapter.CommodityAdapter;
import cqdz.com.genius.home.shangcheng.customer.GoodsTypeDialog;
import cqdz.com.genius.home.shangcheng.customer.TabSortView;
import cqdz.com.genius.home.shangcheng.model.CommodityModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class ShopActivity extends MvpBaseActivity implements ScrollableHelper.ScrollableContainer,TabSortView.Callback {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.scrollablelayout)
    ScrollableLayout scrollablelayout;
    @BindView(R.id.tab)
    TabLayout tabLayout;
    CommodityAdapter adapter;
    ScrollableHelper.ScrollableContainer scrollableContainer;
    List<CommodityModel.Response.Data> mList;
    List<String> titles;
    TabLayout.Tab price;
    TabSortView tabSortView;
    @BindView(R.id.ll_type)
    LinearLayout ll_type;
    GoodsTypeDialog dialog;
//    @BindView(R.id.actionbar_title)
//    TextView actionbar_title;
    @Override
    protected int getLayout() {
        return R.layout.activity_store;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("店铺商品");
        mList = new ArrayList<>();
        setData();
        adapter = new CommodityAdapter(R.layout.item_commodity,mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                mToast.showTextWithPic("已收藏，请在个人中心查看");
//                startActivity(new Intent(mContext,CommodityDetailsActivity.class));
            }
        });
        recyclerView.setAdapter(adapter);//设置适配器
        //设置布局管理器 , 将布局设置成纵向
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        scrollableContainer= this;
        scrollablelayout.getHelper().setCurrentScrollableContainer(scrollableContainer);
        titles = new ArrayList<>();
        titles.add("默认");
        titles.add("新品");
        titles.add("销量");
        titles.add("价格");
        dialog = GoodsTypeDialog.getInstance(titles);
        ll_type.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show(getSupportFragmentManager());
            }
        });
        initTabLayout();
    }
    private void initTabLayout() {

        for (int i = 0; i < titles.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(titles.get(i)));
        }

        tabSortView = new TabSortView(mContext);
        tabSortView.setText("价格");
        tabSortView.setCallback(this);
        price = tabLayout.getTabAt(3);
        price.setCustomView(tabSortView);
        View priceView = (View)price.getCustomView().getParent();
        priceView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tabSortView.onSelection();
            }
        });
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition()==3)
                {
//                    tabSortView.onSelection();
                }
                else {
                    tabSortView.unSelection();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    public void setData()
    {
        CommodityModel.Response.Data data = new CommodityModel.Response.Data();
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1546925144295&di=41d82b0e0f808bb01701c3226b4cd65c&imgtype=0&src=http%3A%2F%2Fimg1.ph.126.net%2Fq4wuNQbI0cmo6ELFSwRJAg%3D%3D%2F3335759949098114047.jpg");
        data.setIntroduction("欧式 水晶玻璃石材马赛克 厨房淋浴室装修材料 15*15");
        data.setNum("已拼4201件");
        data.setPrice("￥28.8");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }
    @Override
    public View getScrollableView() {
        return recyclerView;
    }

    @Override
    public void getStatus(boolean isUp) {
        mToast.showShort(isUp ? "上" : "下");
    }
}
