package cqdz.com.genius.home.xuanke.view;

import cqdz.com.genius.home.xuanke.model.AnswersModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class ISubJectFragment extends MvpBaseFragment {
    AnswersModel.Request.Answer answer;
    public AnswersModel.Request.Answer getAnswer()
    {
        return answer;
    }

    @Override
    protected int getLayout() {
        return 0;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {

    }
}
