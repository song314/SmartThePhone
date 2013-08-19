package com.example.photoutils;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

		if (!audioManager.isSpeakerphoneOn()) {
			audioManager.setMicrophoneMute(false);
			audioManager.setSpeakerphoneOn(true);// 使用扬声器外放，即使已经插入耳机
			setVolumeControlStream(AudioManager.STREAM_MUSIC);// 控制声音的大小
			audioManager.setMode(AudioManager.STREAM_MUSIC);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
