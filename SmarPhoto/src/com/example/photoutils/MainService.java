package com.example.photoutils;

import java.util.concurrent.atomic.AtomicBoolean;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.util.Log;

import com.example.photoutils.uitils.HardwareManager;

public class MainService extends Service {

	private static final String TAG = MainService.class.getSimpleName();

	private ScreenStateReceiver mScreenStateReceiver = new ScreenStateReceiver();

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mScreenStateReceiver.register(this);
	}

	@Override
	public void onDestroy() {
		mScreenStateReceiver.unRegister(this);
		super.onDestroy();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		HardwareManager.enableSpeaker(this);
		return START_REDELIVER_INTENT;
	}

	public static void startMe(Context context) {
		Log.v(TAG, " start main serivce.");
		context.startService(new Intent(context, MainService.class));
	}

	private class ScreenStateReceiver extends BroadcastReceiver {

		private AtomicBoolean mEable = new AtomicBoolean(false);

		@Override
		public void onReceive(Context context, Intent intent) {
			HardwareManager.enableSpeaker(MainService.this);
		}

		void register(Context context) {
			if (!mEable.get()) {
				mEable.set(true);
				final IntentFilter filter = new IntentFilter();
				filter.addAction(Intent.ACTION_SCREEN_ON);
				context.registerReceiver(ScreenStateReceiver.this, filter);
			}
		}

		void unRegister(Context context) {
			if (mEable.get()) {
				context.unregisterReceiver(ScreenStateReceiver.this);
				mEable.set(false);
			}
		}

	}
}
