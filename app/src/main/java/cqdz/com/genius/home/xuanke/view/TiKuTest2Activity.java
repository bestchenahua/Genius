package cqdz.com.genius.home.xuanke.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.HomeActivity;
import cqdz.com.genius.home.view.TabXuanKeFm;
import cqdz.com.genius.home.xuanke.customer.AnswerCardDialog;
import cqdz.com.genius.home.xuanke.customer.TestResult1Dialog;
import cqdz.com.genius.home.xuanke.customer.TestResult2Dialog;
import cqdz.com.genius.home.xuanke.model.AnswersModel;
import cqdz.com.genius.home.xuanke.model.SubjectModel;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SoftHideKeyBoardUtil;

public class TiKuTest2Activity extends MvpBaseActivity implements View.OnClickListener {

    List<ISubJectFragment> fragments;


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
    List<SubjectModel.Response.Data> mList;
    AnswerCardDialog answerCardDialog;
    TestResult2Dialog getResultDialog;

    TestResult1Dialog getResultDialog2;
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
        action_bar_title.setText("测试");
        action_bar_right.setText("答题卡");
        tv_last.setOnClickListener(this);
        tv_next.setOnClickListener(this);
        action_bar_right.setOnClickListener(this);
        Drawable dwLeft = getResources().getDrawable(R.drawable.ic17);
        dwLeft.setBounds(0, 0, dwLeft.getMinimumWidth(), dwLeft.getMinimumHeight());
        action_bar_right.setCompoundDrawables(dwLeft, null, null, null);
        action_bar_right.setCompoundDrawablePadding(3);

        fragments = new ArrayList<>();
        mList = new ArrayList<>();
        setData();
        tv_num.setText(showPosition + 1 + "/" + mList.size());
        tv_last.setVisibility(View.GONE);

        for (int j = 0; j < mList.size(); j++) {

            if (mList.get(j).getType().equals("单选题")) {
                fragments.add(SingleChoiceQuestionFm.getSingleChoiceQuestionFm(mList.get(j)));
            } else if (mList.get(j).getType().equals("多选题")) {
                fragments.add(MultipleChoiceQuestionFm.getMultipleChoiceQuestionFm(mList.get(j)));
            } else if (mList.get(j).getType().equals("问答题")) {
                fragments.add(AnswersQuestionFm.getAnswersQuestionFm(mList.get(j)));
            } else if (mList.get(j).getType().equals("填空题")) {
                fragments.add(CompletionQuestionFm.getCompletionQuestionFm(mList.get(j)));
            }

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
            SubjectModel.Response.Data data = new SubjectModel.Response.Data();
            data.setSubject("这个果实看起来红红的，看起来好像很好吃，尝一个，( )甜滋滋的！（5分）");
            data.setType("单选题");
            data.setSerial(i);
            List<String> options = new ArrayList<>();
            options.add("   A   突然");
            options.add("   B   果然");
            options.add("   C   居然");
            data.setOptions(options);
            mList.add(data);
        }
        for (; i < 6; i++) {
            SubjectModel.Response.Data data2 = new SubjectModel.Response.Data();
            data2.setSubject("请选出下面有错别字的词语（10分）");
            data2.setType("多选题");
            data2.setSerial(i);
            List<String> options2 = new ArrayList<>();
            options2.add("   A   天真无邪");
            options2.add("   B   最炫的民族风");
            options2.add("   C   正能量");
            options2.add("   D   哆啦A梦");
            data2.setOptions(options2);
            mList.add(data2);
        }
        for (; i < 9; i++) {
            SubjectModel.Response.Data data3 = new SubjectModel.Response.Data();
            data3.setSubject("下面两个句子各是用什么方法修饰的？这样修饰后各有什么好的表达效果？" +
                    "\n" +
                    "（1）高粱涨红了脸，稻子笑弯了腰。  \n" +
                    "（2）茉莉花开，香飘万里。");
            data3.setType("问答题");
            data3.setSerial(i);
            mList.add(data3);
        }

        for (; i < 11; i++) {
            SubjectModel.Response.Data data4 = new SubjectModel.Response.Data();
            data4.setSubject("李白《早发白帝城》：朝辞白帝彩云间，______A____。 两岸猿声啼不住，，______B____。");
            data4.setType("填空题");
            data4.setSerial(i);
            List<String> options4 = new ArrayList<>();
            options4.add("A");
            options4.add("B");
            data4.setOptions(options4);
            mList.add(data4);
        }
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
            tv_next.setText("交卷");
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
                if(tv_next.getText().toString().trim().equals("交卷"))
                {
                    //交卷
//                    subTest();

                    getResultDialog2 = new TestResult1Dialog(mContext,103);
                    getResultDialog2.show();
                    getResultDialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            mToast.showText("这个时候应该跳转到错题页面");
                        }
                    });
                }
                else {
                    if (showPosition < mList.size() - 1) {
                        showPosition++;
                        switchFragment();
                    }
                }
                break;
            case R.id.action_bar_right:
                List<AnswerCardDialog.Data> cardData = new ArrayList<>();
                for (int i = 0; i <getAnswers().size(); i++) {
                    AnswersModel.Request.Answer answer = getAnswers().get(i);
                    AnswerCardDialog.Data data = new AnswerCardDialog.Data();
                    data.setSerial(answer.getSerial());
                    if (answer.getType().equals("单选题")||answer.getType().equals("问答题")) {
                        if (!TextUtils.isEmpty(answer.getAnswer())) {
                            data.setDone(true);
                            Logger.d("题目:"+answer.getSerial()+",答案:"+answer.getAnswer());
                        } else {
                            data.setDone(false);
                        }

                    } else if (answer.getType().equals("多选题")||answer.getType().equals("填空题")) {
                        boolean isChoose = false;
                        for (int j = 0; j < answer.getAnswers().size(); j++) {
                            if (!answer.getAnswers().get(j).getAnswer().equals("false")) {
                                isChoose = true;
                                Logger.d("题目:"+answer.getSerial()+",选项:"+answer.getAnswers().get(j).getOption()+"答案"+answer.getAnswers().get(j).getAnswer());
                            }
                        }
                        data.setDone(isChoose);
                    }
                    cardData.add(data);
                }

                answerCardDialog = new AnswerCardDialog(mContext, 101, cardData, new AnswerCardDialog.OnDialogButtonClickListener() {
                    @Override
                    public void onDialogButtonClick(int requestCode, int num) {
                        if(num!=-1)
                        {
                            showPosition = num-1;
                            switchFragment();
                            answerCardDialog.dismiss();
                        }
                        else {
                            subTest();
                        }

                    }
                });
                answerCardDialog.show();
                break;

        }
    }
    public void subTest()
    {
        getResultDialog = new TestResult2Dialog(mContext, 102, new TestResult2Dialog.OnDialogButtonClickListener() {
            @Override
            public void onDialogButtonClick(int requestCode, boolean isLeft) {
//                            mToast.showText(isLeft+"");
                if(isLeft)
                {
                    startActivity(new Intent(mContext,HomeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                }
                else {
                    startActivity(new Intent(mContext,TestEvaluateActivity.class));
                }
                getResultDialog.dismiss();
            }
        });
        getResultDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                finish();
            }
        });
        getResultDialog.show();
    }
    public List<AnswersModel.Request.Answer> getAnswers()
    {
        List<AnswersModel.Request.Answer> answers = new ArrayList<>();
        for (int i = 0; i < fragments.size(); i++) {
            AnswersModel.Request.Answer answer = (AnswersModel.Request.Answer) fragments.get(i).getAnswer();
            answers.add(answer);
        }
        return answers;
    }
}
