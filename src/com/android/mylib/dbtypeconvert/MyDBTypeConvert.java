package com.android.mylib.dbtypeconvert;

import android.content.Context;

public class MyDBTypeConvert {

	public static int dip2px(Context context, float dipValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dipValue * scale + 0.5f);
	}

	public static int px2dip(Context context, float pxValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);

	}

	// 4 byte[] convert 1 int
	public static int Str4Bytes2Int(byte[] bytes4) throws Exception {
		return (int) (((int) (bytes4[0] > 0 ? bytes4[0] : (bytes4[0] & 0x00FF)))
				| (((int) (bytes4[1] > 0 ? bytes4[1] : (bytes4[1] & 0x00FF))) << 8)
				| (((int) (bytes4[2] > 0 ? bytes4[2] : (bytes4[2] & 0x00FF))) << 16) | (((int) (bytes4[3] > 0 ? bytes4[3]
				: (bytes4[3] & 0x00FF))) << 24));
	}

	// byte[n] convert (wchar_t) string
	public static String nBytes2Str(byte[] buffer) throws Exception {
		String ret = new String("");
		int oneCharCount = 0;
		char[] oneChar = new char[1];

		for (oneCharCount = 0; oneCharCount < buffer.length; oneCharCount += 2) {
			oneChar[0] = (char) ((buffer[oneCharCount] > 0 ? buffer[oneCharCount]
					: (buffer[oneCharCount] & 0x00FF)) | (((buffer[oneCharCount + 1] > 0 ? buffer[oneCharCount + 1]
					: (buffer[oneCharCount + 1] & 0x00FF))) << 8));
			ret = ret + oneChar[0];
		}
		return ret;
	}
}
