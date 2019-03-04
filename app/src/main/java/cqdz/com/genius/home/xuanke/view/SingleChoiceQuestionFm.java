package cqdz.com.genius.home.xuanke.view;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.model.AnswersModel;
import cqdz.com.genius.home.xuanke.model.SubjectModel;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SizeTransform;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

public class SingleChoiceQuestionFm extends ISubJectFragment {
    @BindView(R.id.tv_serial)
    TextView tv_serial;

    @BindView(R.id.tv_subject)
    TextView tv_subject;

    @BindView(R.id.radio)
    RadioGroup radioGroup;
    SubjectModel.Response.Data subject;


    public static SingleChoiceQuestionFm getSingleChoiceQuestionFm(SubjectModel.Response.Data subject)
    {
        SingleChoiceQuestionFm  singleChoiceQuestionFm= new SingleChoiceQuestionFm();
        singleChoiceQuestionFm.subject = subject;
        return  singleChoiceQuestionFm;
    }
    @Override
    protected int getLayout() {
        return R.layout.fm_singlechoice;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    public AnswersModel.Request.Answer getAnswer() {
        return super.getAnswer();
    }

    @Override
    protected void initMonitorAndData() {
        answer = new AnswersModel.Request.Answer();
        answer.setType("单选题");
        answer.setSerial(subject.getSerial());


        if(subject.getSerial()!=-1)
        {
            tv_serial.setText(subject.getSerial()+".");
        }
        if(!TextUtils.isEmpty(subject.getSubject()))
        {
            tv_subject.setText("            "+subject.getSubject());
        }

        if(subject.getOptions().size()>0)
        {
            for(int i = 0 ;i<subject.getOptions().size();i++)
            {

                if(!TextUtils.isEmpty(subject.getOptions().get(i)))
                {
                    View top = new View(mContext);
                    ViewGroup.LayoutParams   maginTop=new ViewGroup.LayoutParams (RadioGroup.LayoutParams.MATCH_PARENT
                            ,SizeTransform.dip2px(mContext,20f));
                    top.setLayoutParams(maginTop);

                    RadioButton radioButton = new RadioButton(mContext);
                    radioButton.setGravity( Gravity.NO_GRAVITY);
                    ViewGroup.LayoutParams   layoutParams=new ViewGroup.LayoutParams  (RadioGroup.LayoutParams.MATCH_PARENT
                            ,RadioGroup.LayoutParams.WRAP_CONTENT);
                    if(i>0)
                    {
                        radioGroup.addView(top);
                    }
                    radioButton.setLayoutParams(layoutParams);
                    radioButton.setTag("radioButton"+i);
                    radioButton.setTextColor(Color.parseColor("#666666"));
                    radioButton.setTextSize(COMPLEX_UNIT_SP,14f);
                    radioButton.setButtonDrawable(R.drawable.checkbox_style3);
                    radioButton.setText(subject.getOptions().get(i));

                    int finalI = i;
                    radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            if(isChecked)
                            {
                                answer.setAnswer(subject.getOptions().get(finalI));
                            }
                        }
                    });
                    radioGroup.addView(radioButton);
                }
                else {
                    break;
                }
            }
        }
    }
}
