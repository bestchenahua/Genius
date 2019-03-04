package cqdz.com.genius.home.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import cqdz.com.genius.R;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;

public class ShoppingTab extends BaseTabItem {

    private final TextView mTitle;
    private final LinearLayout mLayout;
    public ShoppingTab(Context context, String title) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.shopping_tab, this, true);
        mTitle = (TextView) findViewById(R.id.title);
        mLayout= (LinearLayout) findViewById(R.id.ll_bg);
        mTitle.setText(title);
    }

    @Override
    public void setChecked(boolean checked) {
        mTitle.setTextColor(checked ? Color.parseColor("#50D8C0") : Color.parseColor("#808080"));
//        mLayout.setBackgroundColor(checked ? 0xFFFFFFFF : 0xFFF5F5F5);
    }

    @Override
    public void setMessageNumber(int number) {}

    @Override
    public void setHasMessage(boolean hasMessage) {}

    @Override
    public String getTitle() {
        return mTitle.getText().toString();
    }
}
