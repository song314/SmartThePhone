package com.example.photoutils.uitils;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

public class HardwareManager {

	public static final String TAG = HardwareManager.class.getSimpleName();

	public HardwareManager() {
	}

	public static void enableSpeaker(Context context) {
		final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

		Log.d(TAG, "ready to check the speak's state");
		// if (!audioManager.isSpeakerphoneOn()) {
		audioManager.setMicrophoneMute(false);
		audioManager.setSpeakerphoneOn(true);
		// context.setVolumeControlStream(AudioManager.STREAM_MUSIC);//
		// 控制声音的大小
		audioManager.setMode(AudioManager.STREAM_MUSIC);
		Log.d(TAG, "The speaker is off, turn on it.");
		// } else {
		// Log.d(TAG, "The speaker is on, do nothing.");
		// }
	}

}
