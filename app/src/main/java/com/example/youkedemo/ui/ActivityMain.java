package com.example.youkedemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.youkedemo.R;
import com.zipingfang.android.yst.YoukeApi;
import com.zipingfang.android.yst.ui.utils.GoodsUtils;
import com.zipingfang.yst.api.BaseApi.IDot2DotNewMessageListener;

/**
 * 商品主页
 * 
 */
public class ActivityMain extends Activity implements View.OnClickListener {
	private ImageView iv_image;
	private String key = "ad9279a0ee9f801491c2ff6ce2b3a0d0";// 换成你的key

	// 10003:5637d070318573b37935041bdf4786ba
	// 1000248:770b58f3bf31b34cfc6bd13e78d7d724
	// 借贷宝 ad9279a0ee9f801491c2ff6ce2b3a0d0
	@Override 
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv_image = (ImageView) findViewById(R.id.iv_image);
		iv_image.setImageResource(R.mipmap.descbg);
		YoukeApi.getInstance(this).onAppStart(key);
		YoukeApi.getInstance(this).setDebugModel(true);

		/**
		 * 消息监听器， 可以在不同地方调用， noReadCont是总数 小技巧：
		 * 每次收到消息，都会执行此方法，开发者可以在这刷新消息列表界面，或做其他事情
		 * 
		 * private IDot2DotNewMessageListener mDot2DotNewMessageListener;
		 * 请在onDestroy()中移除监听比较好，否则重新进入此activity，会再建立一个新对象
		 * YoukeApi.getInstance(this
		 * ).removeDot2DotNewMessageListener(mDot2DotNewMessageListener);
		 **/
		YoukeApi.getInstance(this).addDot2DotNewMessageListener(
				new IDot2DotNewMessageListener() {
					@Override
					public void setNoReadCount(int noReadCount) {
						// 此处自行处理消息未读数
						System.out.println("未读数:" + noReadCount);
					}
				});

		// 使用推送，也是默认模式，关闭app后，也能运行在后台接收消息
		YoukeApi.getInstance(this).setRunInBackGround(true);
		// 不推送，关闭app就收不到消息了
		// YoukeApi.getInstance(this).setRunInBackGround(false);
		initViews(); // view init
	}

	public void onDestroy() {
		YoukeApi.getInstance(this).onAppDestroy();
		System.exit(0);
		super.onDestroy();
	}

	/**
	 * 初始化控件
	 */
	private void initViews() {
		findViewById(R.id.ll_start_youke).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.ll_start_youke) {
			GoodsUtils.showChatActivity(this, null);
		}
	}

}
