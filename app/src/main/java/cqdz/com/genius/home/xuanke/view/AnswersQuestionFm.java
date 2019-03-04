package cqdz.com.genius.home.xuanke.view;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;


import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.AnswersModel;
import cqdz.com.genius.home.xuanke.model.SubjectModel;
import cqdz.com.genius.mvpInterface.MvpPresenter;
/**
 * 问答题
 */
public class AnswersQuestionFm extends ISubJectFragment {
    @BindView(R.id.tv_serial)
    TextView tv_serial;
    @BindView(R.id.tv_subject)
    TextView tv_subject;
    @BindView(R.id.ed_answer)
    EditText ed_answer;
    SubjectModel.Response.Data subject;
    public static AnswersQuestionFm getAnswersQuestionFm(SubjectModel.Response.Data subject)
    {
        AnswersQuestionFm answersQuestionFm= new AnswersQuestionFm();
        answersQuestionFm.subject = subject;
        return  answersQuestionFm;
    }
    @Override
    protected int getLayout() {
        return R.layout.fm_answers;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
//        SoftHideKeyBoardUtil.assistActivity(mActivity);
        answer = new AnswersModel.Request.Answer();
        answer.setType("问答题");
        answer.setSerial(subject.getSerial());
        if(subject.getSerial()!=-1)
        {
            tv_serial.setText(subject.getSerial()+".");
        }
        if(!TextUtils.isEmpty(subject.getSubject()))
        {
            tv_subject.setText("            "+subject.getSubject());
        }
    }

    @Override
    public AnswersModel.Request.Answer getAnswer() {
        if(!TextUtils.isEmpty(ed_answer.getText().toString().trim()))
        {
            answer.setAnswer(ed_answer.getText().toString().trim());
        }
        return super.getAnswer();
    }
}
