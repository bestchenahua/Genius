package cqdz.com.genius.home.wode.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.ErrorSubjectModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SoftHideKeyBoardUtil;

public class ViewErrorSubjectActivity extends MvpBaseActivity implements View.OnClickListener {
    List<Fragment> fragments;
    @BindView(R.id.tv_last)
    TextView tv_last;
    @BindView(R.id.tv_next)
    TextView tv_next;

    @BindView(R.id.tv_num)
    TextView tv_num;

    @BindView(R.id.tv_type)
    TextView tv_type;

    @BindView(R.id.frame)
    FrameLayout frameLayout;
    int showPosition = 0;
    List<ErrorSubjectModel.Response.Data> mList;
//    TestResult2Dialog getResultDialog;
//    TestResult1Dialog getResultDialog2;
    @Override
    protected int getLayout() {
        return R.layout.activity_tiku_test2;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        SoftHideKeyBoardUtil.assistActivity(mActivity);
        action_bar_title.setText("我的错题本");
        tv_last.setOnClickListener(this);
        tv_next.setOnClickListener(this);

        fragments = new ArrayList<>();
        mList = new ArrayList<>();
        setData();
        tv_num.setText(showPosition + 1 + "/" + mList.size());
        tv_last.setVisibility(View.GONE);

        for (int j = 0; j < mList.size(); j++) {

            if (mList.get(j).getType().equals("单选题")) {
                fragments.add(ErrorSingleChoiceQuestionFm.getSingleChoiceQuestionFm(mList.get(j)));
            }
//            else if (mList.get(j).getType().equals("多选题")) {
//                fragments.add(MultipleChoiceQuestionFm.getMultipleChoiceQuestionFm(mList.get(j)));
//            } else if (mList.get(j).getType().equals("问答题")) {
//                fragments.add(AnswersQuestionFm.getAnswersQuestionFm(mList.get(j)));
//            } else if (mList.get(j).getType().equals("填空题")) {
//                fragments.add(CompletionQuestionFm.getCompletionQuestionFm(mList.get(j)));
//            }

        }

        FragmentManager manager;
        FragmentTransaction transaction;
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        for (int i = 0; i < fragments.size(); i++) {
            transaction.add(R.id.frame, fragments.get(i));
            if (showPosition != i) {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }

    public void setData() {

        int i = 1;
        for (; i < 3; i++) {
            ErrorSubjectModel.Response.Data data = new ErrorSubjectModel.Response.Data();
            data.setSubject("这个果实看起来红红的，看起来好像很好吃，尝一个，( )甜滋滋的！（5分）");
            data.setType("单选题");
            data.setSerial(i);
            List<ErrorSubjectModel.Response.Data.Options> options = new ArrayList<>();
            ErrorSubjectModel.Response.Data.Options item = new ErrorSubjectModel.Response.Data.Options();
            item.setItem("A   突然");
            item.setIsRirht(0);

            ErrorSubjectModel.Response.Data.Options item2 = new ErrorSubjectModel.Response.Data.Options();
            item2.setItem("B   果然");
            item2.setIsRirht(1);
            ErrorSubjectModel.Response.Data.Options item3 = new ErrorSubjectModel.Response.Data.Options();
            item3.setItem("C   居然");
            item3.setIsRirht(2);
            options.add(item);
            options.add(item2);
            options.add(item3);
            data.setOptions(options);
            mList.add(data);
        }
//        for (; i < 6; i++) {
//            SubjectModel.Response.Data data2 = new SubjectModel.Response.Data();
//            data2.setSubject("请选出下面有错别字的词语（10分）");
//            data2.setType("多选题");
//            data2.setSerial(i);
//            List<String> options2 = new ArrayList<>();
//            options2.add("   A   天真无邪");
//            options2.add("   B   最炫的民族风");
//            options2.add("   C   正能量");
//            options2.add("   D   哆啦A梦");
//            data2.setOptions(options2);
//            mList.add(data2);
//        }
//        for (; i < 9; i++) {
//            SubjectModel.Response.Data data3 = new SubjectModel.Response.Data();
//            data3.setSubject("下面两个句子各是用什么方法修饰的？这样修饰后各有什么好的表达效果？" +
//                    "\n" +
//                    "（1）高粱涨红了脸，稻子笑弯了腰。  \n" +
//                    "（2）茉莉花开，香飘万里。");
//            data3.setType("问答题");
//            data3.setSerial(i);
//            mList.add(data3);
//        }
//
//        for (; i < 11; i++) {
//            SubjectModel.Response.Data data4 = new SubjectModel.Response.Data();
//            data4.setSubject("李白《早发白帝城》：朝辞白帝彩云间，______A____。 两岸猿声啼不住，，______B____。");
//            data4.setType("填空题");
//            data4.setSerial(i);
//            List<String> options4 = new ArrayList<>();
//            options4.add("A");
//            options4.add("B");
//            data4.setOptions(options4);
//            mList.add(data4);
//        }
    }

    public void switchFragment() {
        FragmentManager manager;
        FragmentTransaction transaction;
        manager = getSupportFragmentManager();
        transaction = manager.beginTransaction();
        if (showPosition == 0) {
            tv_last.setVisibility(View.GONE);
        } else {
            tv_last.setVisibility(View.VISIBLE);
        }
        if (showPosition == mList.size() - 1) {
//            tv_next.setVisibility(View.GONE);
            tv_next.setText("再看一遍");
        } else {
//            tv_next.setVisibility(View.VISIBLE);
            tv_next.setText("下一题");
        }
        tv_num.setText(showPosition + 1 + "/" + mList.size());
        for (int i = 0; i < fragments.size(); i++) {
            if (showPosition == i) {
                tv_type.setText(mList.get(i).getType() + "");
                transaction.show(fragments.get(i));
            } else {
                transaction.hide(fragments.get(i));
            }
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_last:
                //上一题
                if (showPosition > 0) {
                    showPosition--;
                    switchFragment();
                }
                break;
            case R.id.tv_next:
                //下一题
                if(tv_next.getText().toString().trim().equals("再看一遍"))
                {
                    showPosition=0;
                    switchFragment();
                }
                else {
                    if (showPosition < mList.size() - 1) {
                        showPosition++;
                        switchFragment();
                    }
                }
                break;

        }
    }
}
