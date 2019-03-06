package cqdz.com.genius.home.shangcheng.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.adapter.CommodityDetailsAdapter;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class CommodityDetailsFragment extends MvpBaseFragment implements ScrollableHelper.ScrollableContainer {
    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    CommodityDetailsAdapter adapter;
    public List<String> mList;
//
//    public static CommodityDetailsFragment getInstance(String title) {
//        CommodityDetailsFragment chooseFragment = new CommodityDetailsFragment();
//        chooseFragment.title = title;
//        return chooseFragment;
//    }

    @Override
    protected int getLayout() {
        return R.layout.smart_recyclerview;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        mList = new ArrayList<>();
        setList();
        adapter = new CommodityDetailsAdapter(R.layout.item_onepic,mList);
        recyclerView.setAdapter(adapter);//设置适配器
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
//        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linerLayoutManager);
        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.setEnableRefresh(false);
    }

    private void setList() {
        String url = "http://img0.imgtn.bdimg.com/it/u=1531711675,3243572643&fm=200&gp=0.jpg";
        mList.add(url);
        mList.add(url);
        mList.add(url);
        mList.add(url);
        mList.add(url);
        mList.add(url);
        mList.add(url);

    }

    /**
     * @return ScrollView/ListView/RecycelerView..'s instance
     */
    @Override
    public View getScrollableView() {
        return recyclerView;
    }
}
