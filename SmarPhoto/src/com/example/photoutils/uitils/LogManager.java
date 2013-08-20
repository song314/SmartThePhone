package com.example.photoutils.uitils;

import android.util.Log;

public class LogManager {

	private static final boolean SHOW_LOG = true;
	
	private LogManager() {
	}
	
	public static void i(String tag, String msg) {
		if (SHOW_LOG) {
			Log.i(tag, msg);
		}
	}
	
	public static void d(String tag, String msg) {
		if (SHOW_LOG) {
			Log.d(tag, msg);
		}
	}
	
	public static void e(String tag, String msg) {
		if (SHOW_LOG) {
			Log.e(tag, msg);
		}
	}
	
	public static void w(String tag, String msg) {
		if (SHOW_LOG) {
			Log.w(tag, msg);
		}
	}
	
	

}
