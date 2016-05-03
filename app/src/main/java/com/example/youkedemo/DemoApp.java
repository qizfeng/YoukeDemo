package com.example.youkedemo;

import android.app.Application;

/**
 * <application android:name=".DemoApp"
 *
 */
public class DemoApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		// new YstApiReg(this).initYstApp();//move to loading actvity
	}

}
