package cqdz.com.genius.home.shangcheng.customer;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import cqdz.com.genius.R;
import cqdz.com.genius.utils.SizeTransform;


public class TabSortView extends LinearLayout implements View.OnClickListener{
    private TextView tab;
    private boolean isUp;
    private boolean isSelect;
    private Callback callback;
    Context mContext;

    public TabSortView(Context context) {
        super(context);
        mContext=context;
        initView(mContext);
    }
    private void initView(Context context) {
        LayoutInflater.from(context).inflate(R.layout.view_up_down, this).setId(R.id.tab_sort_view);
        tab = (TextView) findViewById(R.id.price_id);
//        tab.setOnClickListener(this);
//        this.setOnClickListener(this);
        setDrawable();
        isSelect = false;
    }

    @Override
    public void onClick(View v) {
        if(isSelect)
        {
            setDrawable();
            callback.getStatus(isUp);
        }
        else {
            onSelection();
        }
    }

    private void setDrawable() {
        Drawable drawable = null;
        if(isSelect)
        {
            if (isUp) {
                isUp = false;
                drawable = getResources().getDrawable(R.drawable.ic_sort2);

            }
            else {
                isUp = true;
                drawable = getResources().getDrawable(R.drawable.ic_sort3);
            }
        }
        else
        {
            drawable = getResources().getDrawable(R.drawable.ic_sort1);
        }
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tab.setCompoundDrawables(null, null, drawable, null);
        tab.setCompoundDrawablePadding(SizeTransform.dip2px(mContext,6));
//        priceView.setTextColor(Color.parseColor("#2DB7B5"));
    }
    public  interface Callback {
        void getStatus(boolean isUp);
    }
    public void setCallback(Callback callback) {
        this.callback = callback;
    }
    public void setText(String text)
    {
        tab.setText(text);
    }
    public void onSelection()
    {
        tab.setTextColor(getResources().getColor(R.color.colorPrimary));
        isSelect=true;
        setDrawable();
        callback.getStatus(isUp);
    }
    public void unSelection()
    {
        tab.setTextColor(Color.parseColor("#515151"));
        isSelect = false;
        setDrawable();
    }
}
