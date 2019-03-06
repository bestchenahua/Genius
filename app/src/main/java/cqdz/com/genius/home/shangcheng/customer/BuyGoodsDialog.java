package cqdz.com.genius.home.shangcheng.customer;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.List;

import cqdz.com.genius.R;
import cqdz.com.genius.home.shangcheng.adapter.GoodsDialogAdapter;
import cqdz.com.genius.utils.ImageLoader;
import cqdz.com.genius.utils.SizeTransform;
import me.shaohui.bottomdialog.BaseBottomDialog;

public class BuyGoodsDialog extends BaseBottomDialog implements View.OnClickListener {
    public static class Data {
        String img;
        String price;
        Child child1;
        Child child2;

        public Child getChild1() {
            return child1;
        }

        public void setChild1(Child child1) {
            this.child1 = child1;
        }

        public Child getChild2() {
            return child2;
        }

        public void setChild2(Child child2) {
            this.child2 = child2;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public static class Child {
            String name;
            List<String> details;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<String> getDetails() {
                return details;
            }

            public void setDetails(List<String> details) {
                this.details = details;
            }
        }
    }
    public interface confirmCallBack
    {
        void callBack();
    }
    public static BuyGoodsDialog getInstance(Data data,confirmCallBack callBack) {
        BuyGoodsDialog dialog = new BuyGoodsDialog();
        dialog.data = data;
        dialog.callBack = callBack;
        return dialog;
    }
    confirmCallBack callBack;
    TextView num;
    private Data data;
    GoodsDialogAdapter adapter1;
    GoodsDialogAdapter adapter2;

    @Override
    public int getLayoutRes() {
        return R.layout.dialog_goods_details;
    }

    @Override
    public int getHeight() {
//        return getView().getHeight();
        return SizeTransform.dip2px(getContext(), 506);
    }

    @Override
    public void bindView(View v) {
        ImageView img = v.findViewById(R.id.imageView60);
        TextView price = v.findViewById(R.id.textView66);
        TextView childName1 = v.findViewById(R.id.textView68);
        TextView childName2 = v.findViewById(R.id.textView69);
        num = v.findViewById(R.id.textView71);
        ImageView close = v.findViewById(R.id.imageView61);

        Button confirm = v.findViewById(R.id.button7);
        Button reduce = v.findViewById(R.id.imageView62);
        Button add = v.findViewById(R.id.imageView63);

        RecyclerView recyclerView1 = v.findViewById(R.id.recyclerView2);
        RecyclerView recyclerView2 = v.findViewById(R.id.recyclerView4);
        if (data.getChild1().getDetails() != null) {
            adapter1 = new GoodsDialogAdapter(R.layout.item_goods_details, data.getChild1().getDetails());
            adapter1.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    GoodsDialogAdapter goodsDialogAdapter = (GoodsDialogAdapter) adapter;
                    goodsDialogAdapter.setCheckItem(position);
                }
            });
            recyclerView1.setAdapter(adapter1);//设置适配器
            //设置布局管理器 , 将布局设置成纵向
            recyclerView1.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }
        if (data.getChild2().getDetails() != null) {
            adapter2 = new GoodsDialogAdapter(R.layout.item_goods_details, data.getChild2().getDetails());
            adapter2.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                    GoodsDialogAdapter goodsDialogAdapter = (GoodsDialogAdapter) adapter;
                    goodsDialogAdapter.setCheckItem(position);
                }
            });
            recyclerView2.setAdapter(adapter2);//设置适配器
            //设置布局管理器 , 将布局设置成纵向
            recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 3));
        }

        ImageLoader.load(getContext(), img, data.getImg());
        price.setText(data.getPrice() + "");
        childName1.setText(data.getChild1().getName() + "");
        childName2.setText(data.getChild2().getName() + "");

        reduce.setOnClickListener(this);
        confirm.setOnClickListener(this);
        add.setOnClickListener(this);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView62:
                if (!TextUtils.isEmpty(num.getText())) {
                    int shuliang = Integer.parseInt(num.getText().toString());
                    if (shuliang > 1) {
                        num.setText(shuliang - 1 + "");
                    } else {
                        Toast.makeText(getContext(), "无法再减少了哦~", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.imageView63:
                if (!TextUtils.isEmpty(num.getText())) {
                    int shuliang = Integer.parseInt(num.getText().toString());
                    num.setText(shuliang + 1 + "");
                }
                break;
            case R.id.button7:
//                Toast.makeText(getContext(), "点了一下确定", Toast.LENGTH_SHORT).show();
                callBack.callBack();
                break;
            case R.id.imageView61:
                dismiss();
                break;
        }
    }
}
