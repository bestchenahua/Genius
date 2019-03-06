package cqdz.com.genius.home.customer;

import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import cqdz.com.genius.R;
import cqdz.com.genius.utils.SizeTransform;
import me.shaohui.bottomdialog.BaseBottomDialog;

public class ShareBottomDialog extends BaseBottomDialog implements View.OnClickListener {
    @Override
    public int getLayoutRes() {
        return R.layout.share_bottom;
    }

    @Override
    public int getHeight() {
        return SizeTransform.dip2px(getContext(),190);
    }

    @Override
    public void bindView(View v) {
        ImageView wx = v.findViewById(R.id.imageView17);
        ImageView pyq = v.findViewById(R.id.imageView18);
        ImageView qq = v.findViewById(R.id.imageView19);
        ImageView qzone = v.findViewById(R.id.imageView20);
        ImageView close = v.findViewById(R.id.close);
        wx.setOnClickListener(this);
        pyq.setOnClickListener(this);
        qq.setOnClickListener(this);
        qzone.setOnClickListener(this);
        close.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.imageView17:
                Toast.makeText(getContext(),"点击了一下微信",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView18:
                Toast.makeText(getContext(),"点击了一下朋友圈",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView19:
                Toast.makeText(getContext(),"点击了一下QQ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView20:
                Toast.makeText(getContext(),"点击了一下QQ空间",Toast.LENGTH_SHORT).show();
                break;
            case R.id.close:
                dismiss();
                break;
        }
    }
}
