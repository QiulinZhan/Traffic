package com.example.qiulin.traffic.layout;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

import com.example.qiulin.traffic.R;
import com.example.qiulin.traffic.utils.DateUtil;

/**
 * 日期时间选择控件 使用方法： private EditText inputDate;//需要设置的日期时间文本编辑框 private String
 * initDateTime="2012年9月3日 14:44",//初始日期时间值 在点击事件中使用：
 * inputDate.setOnClickListener(new OnClickListener() {
 *
 * @Override public void onClick(View v) { DateTimePickDialogUtil
 *           dateTimePicKDialog=new
 *           DateTimePickDialogUtil(SinvestigateActivity.this,initDateTime);
 *           dateTimePicKDialog.dateTimePicKDialog(inputDate);
 *
 *           } });
 *
 * @author
 */
public class DateTimePickDialogUtil implements OnDateChangedListener, OnTimeChangedListener {
	private DatePicker datePicker;
	private TimePicker timePicker;
	private AlertDialog ad;
	private String dateTime;
	private String initDateTime;
	private Activity activity;
	private Field field = null;

	/**
	 * 日期时间弹出选择框构造函数
	 *
	 * @param activity
	 *            ：调用的父activity
	 * @param initDateTime
	 *            初始日期时间值，作为弹出窗口的标题和日期时间初始值
	 */
	public DateTimePickDialogUtil(Activity activity, String initDateTime) {
		this.activity = activity;
		activity.setTheme(android.R.style.Theme_Holo_Light_Dialog_NoActionBar);
		this.initDateTime = initDateTime;

	}

	public void init(DatePicker datePicker, TimePicker timePicker) {
		Calendar calendar = Calendar.getInstance();
		if (!(null == initDateTime || "".equals(initDateTime))) {
			calendar = this.getCalendarByInintData(initDateTime);
		} else {
			initDateTime = calendar.get(Calendar.YEAR) + activity.getResources().getString(R.string.year) + calendar.get(Calendar.MONTH) + activity.getResources().getString(R.string.month)
					+ calendar.get(Calendar.DAY_OF_MONTH) + activity.getResources().getString(R.string.date) + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE);
		}

		datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);
		timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
		timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
	}

	/**
	 * 弹出日期时间选择框方法
	 *
	 * @param inputDate
	 *            :为需要设置的日期时间文本编辑框
	 * @return
	 */
	public void dateTimePicKDialog(final EditText inputDate) {
		LinearLayout dateTimeLayout = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.common_datetime, null);
		datePicker = (DatePicker) dateTimeLayout.findViewById(R.id.datepicker);
		timePicker = (TimePicker) dateTimeLayout.findViewById(R.id.timepicker);
		timePicker.setIs24HourView(true);
		init(datePicker, timePicker);
		timePicker.setOnTimeChangedListener(this);

		ad = new AlertDialog.Builder(activity).setTitle(initDateTime).setView(dateTimeLayout)
				.setPositiveButton(activity.getResources().getString(R.string.setting), new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int whichButton) {
						try {
							field = dialog.getClass().getSuperclass().getDeclaredField("mShowing");// 反射
							field.setAccessible(true);

							long currentTime = System.currentTimeMillis();
							SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");// 标准日期格式
							Date date = new Date(currentTime);
							String currentTimes = formatter.format(date);
							final String currentDate = currentTimes.replace("-", "").replace(" ", "").replace(":", "");

							final String newDate = dateTime.replace(activity.getResources().getString(R.string.year), "-").replace(activity.getResources().getString(R.string.month), "-")
									.replace(activity.getResources().getString(R.string.date), "");
							final String selectDate = newDate.replace("-", "").replace(" ", "").replace(":", "");
							inputDate.setText(newDate);
							field.set(dialog, true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}).setNegativeButton(activity.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						if (field != null) {
							try {
								field.set(dialog, true);
							} catch (IllegalAccessException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IllegalArgumentException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							ad.cancel();
						}
					}
				}).show();
		onDateChanged(null, 0, 0, 0);
	}

	public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
		onDateChanged(null, 0, 0, 0);
	}

	public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
		// 获得日历实例
		Calendar calendar = Calendar.getInstance();

		calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), timePicker.getCurrentHour(), timePicker.getCurrentMinute());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy" + activity.getResources().getString(R.string.year) + "MM" + activity.getResources().getString(R.string.month) + "dd"
				+ activity.getResources().getString(R.string.date) + " HH:mm");

		dateTime = sdf.format(calendar.getTime());
		ad.setTitle(dateTime);
	}

	/**
	 * 实现将初始日期时间2012年07月02日 16:45 拆分成年 月 日 时 分 秒,并赋值给calendar
	 *
	 * @param initDateTime
	 *            初始日期时间值 字符串型
	 * @return Calendar
	 */
	private Calendar getCalendarByInintData(String initDateTime) {
		Calendar calendar = Calendar.getInstance();
		initDateTime += ":00";
		Date date = null;
		try {
			date = DateUtil.parse(initDateTime);
		} catch (ParseException e) {
			date = new Date();
		}
		calendar.setTime(date);

		return calendar;
	}

	/**
	 * 截取子串
	 *
	 * @param srcStr
	 *            源串
	 * @param pattern
	 *            匹配模式
	 * @param indexOrLast
	 * @param frontOrBack
	 * @return
	 */
	public static String spliteString(String srcStr, String pattern, String indexOrLast, String frontOrBack) {
		String result = "";
		int loc = -1;
		if (indexOrLast.equalsIgnoreCase("index")) {
			loc = srcStr.indexOf(pattern); // 取得字符串第一次出现的位置
		} else {
			loc = srcStr.lastIndexOf(pattern); // 最后一个匹配串的位置
		}
		if (frontOrBack.equalsIgnoreCase("front")) {
			if (loc != -1)
				result = srcStr.substring(0, loc); // 截取子串
		} else {
			if (loc != -1)
				result = srcStr.substring(loc + 1, srcStr.length()); // 截取子串
		}
		return result;
	}

}
