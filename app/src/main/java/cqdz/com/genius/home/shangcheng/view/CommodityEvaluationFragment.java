package cqdz.com.genius.home.shangcheng.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.adapter.CommodityEvaluationAdapter;
import cqdz.com.genius.home.shangcheng.model.CommodityEvaluationModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class CommodityEvaluationFragment extends MvpBaseFragment implements ScrollableHelper.ScrollableContainer{
    @BindView(R.id.recyclerView3)
    RecyclerView recyclerView;

    CommodityEvaluationAdapter adapter;

    List<CommodityEvaluationModel.Response.Data> mList;
    @Override
    protected int getLayout() {
        return R.layout.fragment_commodity_evaluation;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        mList = new ArrayList<>();
        setList();
        adapter = new CommodityEvaluationAdapter(R.layout.item_commodity_evaluation,mList);
        recyclerView.setAdapter(adapter);//设置适配器
        LinearLayoutManager linerLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false);
//        recyclerView.addItemDecoration(new DividerItemDecoration(mContext, LinearLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(linerLayoutManager);
    }

    private void setList() {
        CommodityEvaluationModel.Response.Data data = new CommodityEvaluationModel.Response.Data();
        data.setContent("商家态度很好，商品质量没的说，很满意！");
        data.setImg("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1547009455702&di=e8fdd9e4ad58657adcb774358321bf5d&imgtype=0&src=http%3A%2F%2Fwww.pptok.com%2Fwp-content%2Fuploads%2F2012%2F08%2Fxunguang-4.jpg");
        data.setName("么么哒");
        mList.add(data);
    }

    /**
     * @return ScrollView/ListView/RecycelerView..'s instance
     */
    @Override
    public View getScrollableView() {
        return recyclerView;
    }
}
