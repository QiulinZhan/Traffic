package com.example.qiulin.traffic.layout;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * @author lvgg
 * @date 2014-5-16 下午2:32:42
 * @Description: 自定义Toast
 */
public class CustomToast {
	/**
	 * 短时间显示
	 * 
	 * @author lvgg
	 * @date 2014-5-16
	 * @param cxt
	 * @param content
	 */
	public static void newToastShort(Context cxt, String content) {
		Toast.makeText(cxt, content, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 
	 * @param cxt
	 * @param resource
	 *            资源
	 */
	public static void newToastShort(Context cxt, int resource) {
		Toast.makeText(cxt, resource, Toast.LENGTH_SHORT).show();
	}

	/**
	 * 位于屏幕顶端
	 * 
	 * @param cxt
	 * @param content
	 */
	public static void newToastTop(Context cxt, String content) {
		Toast toast = Toast.makeText(cxt, content, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
	}

	/**
	 * 位于屏幕顶端
	 * 
	 * @param cxt
	 * @param content
	 */
	public static void newToastTop(Context cxt, int content) {
		Toast toast = Toast.makeText(cxt, content, Toast.LENGTH_SHORT);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
	}

	/**
	 * 长时间显示
	 * 
	 * @author lvgg
	 * @date 2014-5-16
	 * @param cxt
	 * @param content
	 */
	public static void newToastLong(Context cxt, String content) {
		Toast.makeText(cxt, content, Toast.LENGTH_LONG).show();
	}

	/**
	 * 利用string 中的资源文件
	 * 
	 * @author lvgg
	 * @date 2014-5-16
	 * @param cxt
	 * @param resource
	 */
	public static void newToastLong(Context cxt, int resource) {
		Toast.makeText(cxt, resource, Toast.LENGTH_LONG).show();
	}

	/**
	 * 位于屏幕中央
	 * 
	 * @author lvgg
	 * @date 2014-5-16
	 * @param cxt
	 * @param content
	 */
	public static void newToastCenter(Context cxt, String content) {
		Toast toast = Toast.makeText(cxt, content, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
	
	public static void newToastCenter(Context cxt, int content) {
		Toast toast = Toast.makeText(cxt, content, Toast.LENGTH_LONG);
		toast.setGravity(Gravity.CENTER, 0, 0);
		toast.show();
	}
}
