package cqdz.com.genius.home.view;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ScrollView;

import com.cpoopc.scrollablelayoutlib.ScrollableHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.adapter.TeachCurrAdapter;
import cqdz.com.genius.home.adapter.TeachExpAdapter;
import cqdz.com.genius.home.model.TeachCurrModel;
import cqdz.com.genius.home.model.TeachExpModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class TeacherCurriculumFm extends MvpBaseFragment implements ScrollableHelper.ScrollableContainer {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.smartRefreshLayout)
    SmartRefreshLayout smartRefreshLayout;
    List<TeachCurrModel.Response.Data> mList;
    TeachCurrAdapter adapter;
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
        smartRefreshLayout.setEnableLoadMore(false);
        smartRefreshLayout.setEnableRefresh(false);
        mList = new ArrayList<>();
        adapter = new TeachCurrAdapter(R.layout.item_teach_curriculum,mList);
        setData();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext,LinearLayoutManager.VERTICAL,false));
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.onDraw(c, parent, state);
            }
        });
    }
    public void setData()
    {
        TeachCurrModel.Response.Data data = new TeachCurrModel.Response.Data();
        data.setImg("http://img4.imgtn.bdimg.com/it/u=3590849871,3724521821&fm=26&gp=0.jpg");
        data.setFollow("1234");
        data.setName("张么么");
        data.setState("20元/每小时");
        data.setTitle("唱歌也能记单词？一起趣学英语！");
        mList.add(data);
        mList.add(data);
        mList.add(data);
        mList.add(data);
    }
    @Override
    public View getScrollableView() {
        return recyclerView;
    }
}
