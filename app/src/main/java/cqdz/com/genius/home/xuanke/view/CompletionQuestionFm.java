package cqdz.com.genius.home.xuanke.view;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.xuanke.customer.UnderlineEditText;
import cqdz.com.genius.home.xuanke.model.AnswersModel;
import cqdz.com.genius.home.xuanke.model.SubjectModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SizeTransform;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

/**
 * 填空题
 */
public class CompletionQuestionFm extends ISubJectFragment {
    @BindView(R.id.tv_serial)
    TextView tv_serial;
    @BindView(R.id.tv_subject)
    TextView tv_subject;
    @BindView(R.id.radio)
    LinearLayout radioGroup;
    SubjectModel.Response.Data subject;
    List<AnswersModel.Request.Answer.Item> options;
    public static CompletionQuestionFm getCompletionQuestionFm(SubjectModel.Response.Data subject)
    {
        CompletionQuestionFm completionQuestionFm= new CompletionQuestionFm();
        completionQuestionFm.subject = subject;
        return  completionQuestionFm;
    }
    @Override
    protected int getLayout() {
        return R.layout.fm_completion;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        answer = new AnswersModel.Request.Answer();
        answer.setType("填空题");
        answer.setSerial(subject.getSerial());
        options = new ArrayList<>();
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

                    LinearLayout linearLayout = new LinearLayout(mContext);
                    ViewGroup.LayoutParams   layoutParams=new ViewGroup.LayoutParams  (RadioGroup.LayoutParams.MATCH_PARENT
                            ,RadioGroup.LayoutParams.WRAP_CONTENT);
                    if(i>0)
                    {
                        radioGroup.addView(top);
                    }
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);

                    TextView title = new TextView(mContext);
                    ViewGroup.LayoutParams   titleParams=new ViewGroup.LayoutParams  (RadioGroup.LayoutParams.WRAP_CONTENT
                            ,RadioGroup.LayoutParams.MATCH_PARENT);
                    title.setLayoutParams(titleParams);
                    title.setTextSize(COMPLEX_UNIT_SP,14f);
                    title.setGravity(Gravity.CENTER);
                    title.setTextColor(Color.parseColor("#50D8C0"));
                    title.setText(subject.getOptions().get(i)+"");

                    UnderlineEditText input = new UnderlineEditText(mContext);
                    ViewGroup.MarginLayoutParams   inputParams=new ViewGroup.MarginLayoutParams  (RadioGroup.LayoutParams.MATCH_PARENT
                            ,RadioGroup.LayoutParams.MATCH_PARENT);
                    int padding = SizeTransform.dip2px(mContext,5f);
                    inputParams.setMargins(padding,0,0,0);
                    input.setTextSize(COMPLEX_UNIT_SP,14f);
                    input.setTextColor(Color.parseColor("#333333"));
                    input.setPadding(padding,padding,padding,padding);
                    input.setMaxLines(5);
                    input.setLayoutParams(inputParams);
                    input.setBackground(null);
                    input.setSingleLine(true);
                    input.setMaxLines(1);
                    AnswersModel.Request.Answer.Item item= new AnswersModel.Request.Answer.Item();
                    item.setOption(subject.getOptions().get(i));
                    options.add(item);
                    int finalI = i;
                    input.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {

                        }

                        @Override
                        public void afterTextChanged(Editable s) {
                            options.get(finalI).setAnswer(input.getText().toString() + "");
                        }
                    });
                    linearLayout.addView(title);
                    linearLayout.addView(input);

                    radioGroup.addView(linearLayout);
                }
                else {
                    break;
                }
            }
        }
    }

    @Override
    public AnswersModel.Request.Answer getAnswer() {
        answer.setAnswers(options);
        return super.getAnswer();
    }
}
