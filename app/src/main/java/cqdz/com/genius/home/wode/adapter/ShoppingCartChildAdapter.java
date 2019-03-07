package cqdz.com.genius.home.wode.adapter;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.orhanobut.logger.Logger;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.wode.model.ShoppingCartModel;
import cqdz.com.genius.utils.ImageLoader;

public class ShoppingCartChildAdapter extends BaseQuickAdapter<ShoppingCartModel.Response.Data.Child, BaseViewHolder> {
    public ShoppingCartChildAdapter(int layoutResId, @Nullable List<ShoppingCartModel.Response.Data.Child> data) {
        super(layoutResId, data);
    }
    @Override
    protected void convert(BaseViewHolder helper, ShoppingCartModel.Response.Data.Child item) {
        if (!TextUtils.isEmpty(item.getImg())) {
            ImageView iv = helper.getView(R.id.imageView83);
            ImageLoader.load(mContext, iv, item.getImg());
        }
        if (!TextUtils.isEmpty(item.getName())) {
            helper.setText(R.id.textView105, item.getName());
        }

        if (!TextUtils.isEmpty(item.getIntroduction())) {
            helper.setText(R.id.textView106, item.getIntroduction());
        }

        if (!TextUtils.isEmpty(item.getPrice())) {
            helper.setText(R.id.textView107, item.getPrice());
        }

        if (!TextUtils.isEmpty(item.getNum() + "")) {
            helper.setText(R.id.num, item.getNum() + "");
        }
        View line = helper.getView(R.id.view36);
        if (helper.getAdapterPosition() == getData().size() - 1) {
            line.setVisibility(View.GONE);
        }
        CheckBox checkBox = helper.getView(R.id.checkBox3);
        checkBox.setChecked(item.isCheck());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                item.setCheck(isChecked);
            }
        });
        helper.addOnClickListener(R.id.checkBox3);
        TextView reduce = helper.getView(R.id.reduce);
        TextView add = helper.getView(R.id.add);
        TextView num = helper.getView(R.id.num);
        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldNum = num.getText().toString();
                if (!TextUtils.isEmpty(oldNum)) {
                    if (Integer.parseInt(oldNum) > 0) {
                        num.setText(Integer.parseInt(oldNum) - 1 + "");

                    } else {
                        Toast.makeText(mContext, "无法再减少了哦~", Toast.LENGTH_SHORT).show();
                    }
                }
                item.setNum(Integer.parseInt(num.getText().toString()));
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String oldNum = num.getText().toString();
                Logger.d(oldNum + "---------------");
                if (!TextUtils.isEmpty(oldNum)) {
                    num.setText(Integer.parseInt(oldNum) + 1 + "");
                }
                item.setNum(Integer.parseInt(num.getText().toString()));
            }
        });
    }
}
