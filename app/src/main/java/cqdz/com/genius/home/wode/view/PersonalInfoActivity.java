package cqdz.com.genius.home.wode.view;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.guoqi.actionsheet.ActionSheet;
import com.linchaolong.android.imagepicker.ImagePicker;
import com.linchaolong.android.imagepicker.cropper.CropImage;
import com.linchaolong.android.imagepicker.cropper.CropImageView;

import butterknife.BindView;
import cqdz.com.genius.R;
import cqdz.com.genius.mvpInterface.MvpBaseActivity;
import cqdz.com.genius.mvpInterface.MvpPresenter;
import cqdz.com.genius.utils.ImageLoader;

public class PersonalInfoActivity extends MvpBaseActivity implements View.OnClickListener, ActionSheet.OnActionSheetSelected {

    @BindView(R.id.iv_touxiang)
    ImageView iv_touxiang;
    @BindView(R.id.ll_touxiang)
    LinearLayout ll_touxiang;

    ImagePicker imagePicker;
    ImagePicker.Callback callback;
    Uri mImageUri;
    @Override
    protected int getLayout() {
        return R.layout.activity_personal_information;
    }

    @Override
    protected MvpPresenter getPresenter() {
        return null;
    }

    @Override
    protected void initMonitorAndData() {
        action_bar_title.setText("个人信息");

        ll_touxiang.setOnClickListener(this);

        imagePicker = new ImagePicker();
        // 设置标题
        imagePicker.setTitle("设置头像");
        // 设置是否裁剪图片
        imagePicker.setCropImage(true);
        callback= new ImagePicker.Callback() {
            // 选择图片回调
            @Override public void onPickImage(Uri imageUri) {

            }

            // 裁剪图片回调
            @Override public void onCropImage(Uri imageUri) {
                mImageUri = imageUri;
                ImageLoader.load(mContext,iv_touxiang,mImageUri,25);
            }

            // 自定义裁剪配置
            @Override public void cropConfig(CropImage.ActivityBuilder builder) {
                builder
                        // 是否启动多点触摸
                        .setMultiTouchEnabled(false)
                        // 设置网格显示模式
                        .setGuidelines(CropImageView.Guidelines.OFF)
                        // 圆形/矩形
                        .setCropShape(CropImageView.CropShape.OVAL)
                        // 调整裁剪后的图片最终大小
//                        .setRequestedSize(960, 540)
                        // 宽高比
                        .setAspectRatio(16, 16);
            }

            // 用户拒绝授权回调
            @Override public void onPermissionDenied(int requestCode, String[] permissions,
                                                     int[] grantResults) {
                mToast.showText("请打开相关权限");
            }
        };
    }
    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ll_touxiang:
                ActionSheet.showSheet(mContext, this, null);
                break;
//            case R.id.tv_position:
//                popupWindow1.showAtLocation(v.getRootView(), Gravity.BOTTOM, 0, 0);
//                //显示pupouwindow时传入0.5f
//                darkenBackground(0.5f);
//                break;
        }
    }
    @Override
    public void onClick(int whichButton) {
        switch (whichButton) {
            case ActionSheet.CHOOSE_PICTURE:
                //相册
//                choosePic();
                imagePicker.startGallery(mActivity, callback);
                break;
            case ActionSheet.TAKE_PICTURE:
                //拍照
//                takePic();
                imagePicker.startCamera(mActivity, callback);
                break;
            case ActionSheet.CANCEL:
                //取消
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        imagePicker.onActivityResult(mActivity, requestCode, resultCode, data);
    }
    @Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                                     @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        imagePicker.onRequestPermissionsResult(mActivity, requestCode, permissions, grantResults);
    }
}
