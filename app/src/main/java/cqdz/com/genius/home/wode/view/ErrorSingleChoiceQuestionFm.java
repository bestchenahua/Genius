package cqdz.com.genius.home.wode.view;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.ErrorSubjectModel;
import cqdz.com.genius.mvpInterface.MvpBaseFragment;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.SizeTransform;

import static android.util.TypedValue.COMPLEX_UNIT_SP;

public class ErrorSingleChoiceQuestionFm extends MvpBaseFragment {
    @BindView(R.id.tv_serial)
    TextView tv_serial;

    @BindView(R.id.tv_subject)
    TextView tv_subject;

    @BindView(R.id.radio)
    LinearLayout radioGroup;
    ErrorSubjectModel.Response.Data subject;
    public static ErrorSingleChoiceQuestionFm getSingleChoiceQuestionFm(ErrorSubjectModel.Response.Data subject)
    {
        ErrorSingleChoiceQuestionFm singleChoiceQuestionFm= new ErrorSingleChoiceQuestionFm();
        singleChoiceQuestionFm.subject = subject;
        return  singleChoiceQuestionFm;
    }
    @Override
    protected int getLayout() {
        return R.layout.fm_error_singlechoice;
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
                    View top20 = new View(mContext);
                    View left10 = new View(mContext);
                    ViewGroup.LayoutParams   maginTop20=new ViewGroup.LayoutParams (ViewGroup.LayoutParams.MATCH_PARENT
                            ,SizeTransform.dip2px(mContext,20f));
                    top20.setLayoutParams(maginTop20);
                    ViewGroup.LayoutParams   maginTop10=new ViewGroup.LayoutParams (SizeTransform.dip2px(mContext,10f)
                            ,ViewGroup.LayoutParams.MATCH_PARENT);
                    left10.setLayoutParams(maginTop10);
                    LinearLayout linearLayout = new LinearLayout(mContext);
                    linearLayout.setGravity( Gravity.NO_GRAVITY);
                    linearLayout.setOrientation(LinearLayout.HORIZONTAL);
                    ViewGroup.LayoutParams   layoutParams=new ViewGroup.LayoutParams  (ViewGroup.LayoutParams.MATCH_PARENT
                            ,ViewGroup.LayoutParams.WRAP_CONTENT);
                    if(i>0)
                    {
                        radioGroup.addView(top20);
                    }
                    linearLayout.setLayoutParams(layoutParams);
                    linearLayout.setTag("linearLayout"+i);
                    ImageView iv = new ImageView(mContext);
                    ViewGroup.LayoutParams   iv_layoutParams=new ViewGroup.LayoutParams  (SizeTransform.dip2px(mContext,20)
                            ,SizeTransform.dip2px(mContext,20));
                    if(subject.getOptions().get(i).getIsRirht()==0)
                    {
                        iv.setImageResource(R.drawable.addr_unchecked);
                    }
                    else if(subject.getOptions().get(i).getIsRirht()==1)
                    {
                        iv.setImageResource(R.drawable.addr_checked);
                    }
                    else if(subject.getOptions().get(i).getIsRirht()==2)
                    {
                        iv.setImageResource(R.drawable.ic48);
                    }
                    linearLayout.addView(iv);
                    linearLayout.addView(left10);
                    TextView tv = new TextView(mContext);

                    ViewGroup.LayoutParams   tv_layoutParams=new ViewGroup.LayoutParams  (ViewGroup.LayoutParams.WRAP_CONTENT
                            ,ViewGroup.LayoutParams.WRAP_CONTENT);
                    tv.setLayoutParams(tv_layoutParams);
                    tv.setTextColor(Color.parseColor("#666666"));
                    tv.setTextSize(COMPLEX_UNIT_SP,14f);
                    tv.setText(subject.getOptions().get(i).getItem());
                    linearLayout.addView(tv);
                    radioGroup.addView(linearLayout);
                }
                else {
                    break;
                }
            }
        }
    }
}
