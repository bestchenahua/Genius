package cqdz.com.genius.home.xuanke.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.adapter.DaGangAdapter;
import cqdz.com.genius.home.xuanke.model.DaGangModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

/**
 * 去上课
 */
public class AttendClassActivity extends MvpBaseActivity {

    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    DaGangAdapter adapter;

    List<DaGangModel.Response.Data> daGangs;
    @Override
    protected int getLayout() {
        return R.layout.activity_attendclass;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        daGangs = new ArrayList<>();
        setDaGang();
        adapter = new DaGangAdapter(R.layout.item_suc_details_dagang,daGangs);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
    }
    public void setDaGang()
    {
        DaGangModel.Response.Data data = new DaGangModel.Response.Data();
        data.setDate("2月13日·周三·10:00-10:45");
        data.setDay("第1天");
        data.setName("【快乐阅读】《小猪唏哩呼噜》");
        data.setBtn("进入教室");
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
        daGangs.add(data);
    }
}
