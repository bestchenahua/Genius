package cqdz.com.genius.home.wode.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.CollectionCommodityAdapter;
import cqdz.com.genius.home.wode.adapter.CollectionShopAdapter;
import cqdz.com.genius.home.wode.customer.SlideRecyclerView;
import cqdz.com.genius.home.wode.model.CollectionCommodityModel;
import cqdz.com.genius.home.wode.model.CollectionShopModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 店铺
 */
public class CollectionCommodityFm extends MvpBaseFragment {
    @BindView(R.id.recycler_view_list)
    SlideRecyclerView recyclerView;
    CollectionCommodityAdapter adapter;
    List<CollectionCommodityModel.Response.Data> mList;
    @Override
    protected int getLayout() {
        return R.layout.fm_collectionshop;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        mList = new ArrayList<>();
        setData();
        adapter = new CollectionCommodityAdapter(R.layout.item_coll_commodity,mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

        adapter.setOnDeleteClickListener(new CollectionCommodityAdapter.OnDeleteClickLister() {
            @Override
            public void onDeleteClick(View view, int position) {
                mList.remove(position);
                adapter.notifyDataSetChanged();
                mToast.showText("删除"+position);
                recyclerView.closeMenu();
            }
        });
    }
    public void setData()
    {
        CollectionCommodityModel.Response.Data data = new CollectionCommodityModel.Response.Data();
        data.setImg("http://cdn.duitang.com/uploads/item/201601/08/20160108211422_RPUaY.jpeg");
        data.setTitle("迪士尼儿童学习用具功能大容量文具盒男孩女孩文具盒可爱卡通");
        data.setColloction("73人收藏");
        data.setPrice("￥798");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }
}
