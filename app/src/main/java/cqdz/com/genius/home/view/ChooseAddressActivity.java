package cqdz.com.genius.home.view;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.adapter.AddressAdapter;
import cqdz.com.genius.home.model.AddressModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class ChooseAddressActivity extends MvpBaseActivity {

    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    AddressAdapter adapter;
    List<AddressModel.Response.Data> mList;
    @Override
    protected int getLayout() {
        return R.layout.activity_chooseaddr;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("选择地址");
        action_bar_right.setText("新建地址");
        action_bar_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,AddNewAddressActivity.class));
            }
        });
        mList = new ArrayList<>();
        setMethods();
        adapter = new AddressAdapter(R.layout.item_chooseaddr,mList);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AddressAdapter adapter1 = (AddressAdapter)adapter;
                adapter1.setCheckedPosition(position);
            }
        });
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case  R.id.textView119:
                        Intent intent = new Intent(mContext, EditAddressActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
        recyclerView.setAdapter(adapter);//设置适配器
        LinearLayoutManager linerLayoutManager2 = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linerLayoutManager2);
    }
    private void setMethods() {
        AddressModel.Response.Data data = new AddressModel.Response.Data();
        data.setName("微信支付");
        data.setIsDefault("0");
        data.setAddr("重庆市渝中区冉家坝扬子江小区2栋25-5");
        data.setTel("13883859879");
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }
}
