package cqdz.com.genius.guide;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.home.HomeActivity;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;

public class GuideActivity extends MvpBaseActivity {
    @BindView(R.id.start_btn)
    Button start_btn;
    @BindView(R.id.header)
    Banner header;
    List<Integer> img;
    @Override
    protected int getLayout() {
        return R.layout.activity_guide;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        initBanner();
        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mContext,HomeActivity.class));
                finish();
            }
        });
    }
    private void initBanner() {
        img = new ArrayList<>();
        header.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        header.setIndicatorGravity(BannerConfig.CENTER);
        img.add(R.drawable.img9_guide1);
        img.add(R.drawable.img9_guide2);
        img.add(R.drawable.img9_guide3);
        header.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object o, ImageView imageView) {
                cqdz.com.genius.utils.ImageLoader.load(mContext,imageView,(int)o);
            }
        });
        header.setImages(img);
        header.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
//                mToast.showShort("点击了一下第" + position + "个");
            }
        });
        header.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if(i==img.size()-1)
                {
                    start_btn.setVisibility(View.VISIBLE);
                }
                else {
                    start_btn.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        header.start();
    }
}
