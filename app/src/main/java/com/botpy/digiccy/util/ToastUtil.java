package com.botpy.digiccy.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

/**
 * @author liuxuhui
 * @date 2018/11/18
 */
public class ToastUtil {

	public static Toast mToast;

	private static Handler mHandler = new Handler();
	private static Runnable r = new Runnable() {

		@Override
		public void run() {
			mToast.cancel();
		}
	};
	
	public static void show(Context context, int resId) {
		show(context, context.getResources().getText(resId), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, int resId, int duration) {
		show(context, context.getResources().getText(resId), duration);
	}

	public static void show(Context context, CharSequence text) {
		show(context, text, Toast.LENGTH_SHORT);
	}

	public static void show(Context context, CharSequence text, int duration) {
		if (context == null) {
			return;
		}

		mHandler.removeCallbacks(r);
		if (mToast != null) {
			mToast.setText(text);
		} else {
			mToast = Toast.makeText(context, text, duration);
			mHandler.postDelayed(r, 1000);
		}
		mToast.show();
	}

	public static void show(Context context, int resId, Object... args) {
		show(context, String.format(context.getResources().getString(resId), args), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, String format, Object... args) {
		show(context, String.format(format, args), Toast.LENGTH_SHORT);
	}

	public static void show(Context context, int resId, int duration, Object... args) {
		show(context, String.format(context.getResources().getString(resId), args), duration);
	}

	public static void show(Context context, String format, int duration, Object... args) {
		show(context, String.format(format, args), duration);
	}
}
