package com.example.photoutils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.photoutils.uitils.APIUtils;
import com.example.photoutils.uitils.PreferenceManager;

public class StaticReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		final SharedPreferences pref = PreferenceManager.getMainPref(context);
		final long newCount = pref.getLong(PreferenceManager.NET_STATE_CHANGE_COUNT, 0) + 1;
		if (APIUtils.SUPPORT_2x3) {
			pref.edit().putLong(PreferenceManager.NET_STATE_CHANGE_COUNT, newCount).apply();
		} else {
			pref.edit().putLong(PreferenceManager.NET_STATE_CHANGE_COUNT, newCount).commit();
		}

		MainService.startMe(context);
	}

}
