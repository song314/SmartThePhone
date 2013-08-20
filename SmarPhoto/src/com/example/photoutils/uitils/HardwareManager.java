package com.example.photoutils.uitils;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.widget.Toast;

public class HardwareManager {

	public static final String TAG = HardwareManager.class.getSimpleName();

	public HardwareManager() {
	}

	public static void enableSpeaker(Context context) {
		final TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		
		final boolean canEnableSpeaker;
		if (tm != null) {
			int callState = tm.getCallState();
			Toast.makeText(context, "call state = " + callState, Toast.LENGTH_SHORT).show();
			if (TelephonyManager.CALL_STATE_IDLE == callState) {
				canEnableSpeaker = true;
			} else {
				canEnableSpeaker = false;
			}
		} else {
			canEnableSpeaker = true;
		}
		
		if (canEnableSpeaker) {
			final AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
			
			Log.d(TAG, "ready to check the speak's state");
			// if (!audioManager.isSpeakerphoneOn()) {
			audioManager.setMicrophoneMute(false);
			audioManager.setSpeakerphoneOn(true);
			// context.setVolumeControlStream(AudioManager.STREAM_MUSIC);//
			// 控制声音的大小
			audioManager.setMode(AudioManager.STREAM_MUSIC);
			// Log.d(TAG, "The speaker is off, turn on it.");
			Log.d(TAG, "Turn on the speaker.");
			// } else {
			// Log.d(TAG, "The speaker is on, do nothing.");
			// }
		}
	}

}
