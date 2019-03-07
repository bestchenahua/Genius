package cqdz.com.genius.home.wode.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.adapter.CollectionShopAdapter;
import cqdz.com.genius.home.wode.customer.SlideRecyclerView;
import cqdz.com.genius.home.wode.model.CollectionShopModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 店铺
 */
public class CollectionShopFm extends MvpBaseFragment {
    @BindView(R.id.recycler_view_list)
    SlideRecyclerView recyclerView;
    CollectionShopAdapter adapter;
    List<CollectionShopModel.Response.Data> mList;
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
        adapter = new CollectionShopAdapter(R.layout.item_coll_shop,mList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));

        adapter.setOnDeleteClickListener(new CollectionShopAdapter.OnDeleteClickLister() {
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
        CollectionShopModel.Response.Data data = new CollectionShopModel.Response.Data();
        data.setImg("http://cdn.duitang.com/uploads/item/201601/08/20160108211422_RPUaY.jpeg");
        data.setTitle("三年二班不一样的文具");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }
}
