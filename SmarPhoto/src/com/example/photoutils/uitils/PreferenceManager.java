package com.example.photoutils.uitils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * The function is as her name.
 * 
 * @author song
 * 
 */
public class PreferenceManager {

	public static final String NET_STATE_CHANGE_COUNT = "net_state_change_count";

	private PreferenceManager() {
	}

	private static SharedPreferences sMainPref;

	public static SharedPreferences getMainPref(Context context) {
		if (sMainPref == null) {
			synchronized (PreferenceManager.class) {
				if (sMainPref == null) {
					sMainPref = context.getSharedPreferences("main_pref", Context.MODE_PRIVATE);
				}
			}
		}

		return sMainPref;
	}

}
