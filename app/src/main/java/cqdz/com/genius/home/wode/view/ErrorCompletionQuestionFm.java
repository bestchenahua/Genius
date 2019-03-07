package cqdz.com.genius.home.wode.view;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.ErrorSubjectModel;
import cqdz.com.genius.home.xuanke.customer.UnderlineEditText;
import cqdz.com.genius.home.xuanke.model.AnswersModel;
import cqdz.com.genius.home.xuanke.model.SubjectModel;
import cqdz.com.genius.home.xuanke.view.ISubJectFragment;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SizeTransform;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

/**
 * 填空题
 */
public class ErrorCompletionQuestionFm extends MvpBaseFragment {
    @BindView(R.id.tv_serial)
    TextView tv_serial;
    @BindView(R.id.tv_subject)
    TextView tv_subject;
    @BindView(R.id.radio)
    LinearLayout radioGroup;
    ErrorSubjectModel.Response.Data subject;
    public static ErrorCompletionQuestionFm getCompletionQuestionFm(ErrorSubjectModel.Response.Data subject)
    {
        ErrorCompletionQuestionFm completionQuestionFm= new ErrorCompletionQuestionFm();
        completionQuestionFm.subject = subject;
        return  completionQuestionFm;
    }
    @Override
    protected int getLayout() {
        return R.layout.fm_errcompletion;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
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

                if(subject.getOptions().get(i)!=null)
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
                    title.setText(subject.getOptions().get(i).getOption()+"");

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
                    input.setText(subject.getOptions().get(i).getItem()+"");
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
}
