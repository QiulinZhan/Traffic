package com.example.qiulin.traffic;


import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.afollestad.materialdialogs.MaterialDialog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectPicPopupWindow extends Activity implements OnClickListener{
    private static final int CAMERA_WITH_DATA = 3023;

    /*用来标识请求gallery的activity*/
    private static final int PHOTO_PICKED_WITH_DATA = 3021;

    /*拍照的照片存储位置*/
    private static final File PHOTO_DIR = new File(Environment.getExternalStorageDirectory() + "/DCIM/Camera");
    private File mCurrentPhotoFile;//照相机拍照得到的图片
	private Button btn_take_photo, btn_pick_photo, btn_cancel;
	private LinearLayout layout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alert_dialog);
		btn_take_photo = (Button) this.findViewById(R.id.btn_take_photo);
		btn_pick_photo = (Button) this.findViewById(R.id.btn_pick_photo);
		btn_cancel = (Button) this.findViewById(R.id.btn_cancel);
		
		layout=(LinearLayout)findViewById(R.id.pop_layout);
		
		layout.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "ds",
						Toast.LENGTH_SHORT).show();	
			}
		});
		btn_cancel.setOnClickListener(this);
		btn_pick_photo.setOnClickListener(this);
		btn_take_photo.setOnClickListener(this);
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event){
		finish();
		return true;
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_take_photo:
            String status = Environment.getExternalStorageState();
            if(status.equals(Environment.MEDIA_MOUNTED)){//判断是否有SD卡
                doTakePhoto();// 用户点击了从照相机获取
            }else{
                new MaterialDialog.Builder(SelectPicPopupWindow.this)
                        .title("提示")
                        .content("没有sd卡")
                        .negativeText("确定")
                        .show();
            }
            break;
		case R.id.btn_pick_photo:
            doPickPhotoFromGallery();// 从相册中去获取
            break;
		case R.id.btn_cancel:				
			break;
		default:
			break;
		}
		finish();
	}
    protected void doTakePhoto() {
        try {
            // Launch camera to take photo for selected contact
            PHOTO_DIR.mkdirs();// 创建照片的存储目录
            mCurrentPhotoFile = new File(PHOTO_DIR, getPhotoFileName());// 给新照的照片文件命名
            final Intent intent = getTakePickIntent(mCurrentPhotoFile);
            startActivityForResult(intent, CAMERA_WITH_DATA);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "无",
                    Toast.LENGTH_LONG).show();
        }
    }
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date) + ".jpg";
    }
    public static Intent getTakePickIntent(File f) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE, null);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
        return intent;
    }
    // 请求Gallery程序
    protected void doPickPhotoFromGallery() {
        try {
            // Launch picker to choose photo for selected contact
            final Intent intent = getPhotoPickIntent();
            startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, "无",
                    Toast.LENGTH_LONG).show();
        }
    }

    // 封装请求Gallery的intent
    public static Intent getPhotoPickIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
        intent.setType("image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 80);
        intent.putExtra("outputY", 80);
        intent.putExtra("return-data", true);
        return intent;
    }

    // 因为调用了Camera和Gally所以要判断他们各自的返回情况,他们启动时是这样的startActivityForResult
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != RESULT_OK)
            return;
        switch (requestCode) {
            case PHOTO_PICKED_WITH_DATA: {// 调用Gallery返回的
                final Bitmap photo = data.getParcelableExtra("data");
                // 下面就是显示照片了
                System.out.println(photo);
                //缓存用户选择的图片
//                img = getBitmapByte(photo);
//                mEditor.setPhotoBitmap(photo);
                System.out.println("set new photo");
                break;
            }
            case CAMERA_WITH_DATA: {// 照相机程序返回的,再次调用图片剪辑程序去修剪图片
                doCropPhoto(mCurrentPhotoFile);
                break;
            }
        }
    }

    protected void doCropPhoto(File f) {
        try {
            // 启动gallery去剪辑这个照片
            final Intent intent = getCropImageIntent(Uri.fromFile(f));
            startActivityForResult(intent, PHOTO_PICKED_WITH_DATA);
        } catch (Exception e) {
            Toast.makeText(this, "无",
                    Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Constructs an intent for image cropping. 调用图片剪辑程序
     */
    public static Intent getCropImageIntent(Uri photoUri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(photoUri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", 80);
        intent.putExtra("outputY", 80);
        intent.putExtra("return-data", true);
        return intent;
    }
    public static void launch(Activity activity) {
        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeCustomAnimation(activity,
                        R.anim.push_bottom_in, R.anim.push_bottom_out);
        Intent intent = new Intent(activity, SelectPicPopupWindow.class);
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }
}
