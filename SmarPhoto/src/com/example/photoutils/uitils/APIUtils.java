package com.example.photoutils.uitils;

import android.os.Build;

public class APIUtils {

	public static interface VERSION_CODES {
		// These value are copied from Build.VERSION_CODES
		int GINGERBREAD = 9;
		int GINGERBREAD_MR1 = 10;
		int HONEYCOMB = 11;
		int HONEYCOMB_MR1 = 12;
		int HONEYCOMB_MR2 = 13;
		int ICE_CREAM_SANDWICH = 14;
		int ICE_CREAM_SANDWICH_MR1 = 15;
		int JELLY_BEAN = 16;
		int JELLY_BEAN_MR1 = 17;
	}

	private APIUtils() {
	}

	public static final boolean SUPPORT_2x3;

	static {
		SUPPORT_2x3 = Build.VERSION.SDK_INT >= VERSION_CODES.GINGERBREAD;
	}

}
