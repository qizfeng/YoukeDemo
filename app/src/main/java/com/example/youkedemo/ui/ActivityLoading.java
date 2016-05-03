package com.example.youkedemo.ui;

import com.zipingfang.android.yst.YoukeApi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class ActivityLoading extends Activity {
	//5637d070318573b37935041bdf4786ba
	//770b58f3bf31b34cfc6bd13e78d7d724
	private String key ="770b58f3bf31b34cfc6bd13e78d7d724";//换成你的key
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);  
		//sdk初始化
		YoukeApi.getInstance(this).onAppStart(key); 	
		YoukeApi.getInstance(this).setDebugModel(true);
		Intent intent=new Intent(ActivityLoading.this, ActivityMain.class); 
		startActivity(intent);
	}

}
