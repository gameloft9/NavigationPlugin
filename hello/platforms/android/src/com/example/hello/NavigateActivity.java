
/**
 * 本类调用百度导航
 * 
 * 说明：起初该类是作为中间activity来调用百度地图客户端，由于可以在实现js接口的类中直接
 * 调用百度地图客户端，所以该类废弃。如果要使用百度android导航SDK，则该类是必须的。
 * 因为实现SDK必须继承自activity类，而实现js接口的类必须继承自cordovaplugin类。
 * */
package com.example.hello;

import java.io.File;
import java.net.URISyntaxException;

import com.baidu.navisdk.adapter.BNOuterTTSPlayerCallback;
import com.baidu.navisdk.adapter.BaiduNaviManager;
import com.baidu.navisdk.adapter.BNRoutePlanNode.CoordinateType;
import com.baidu.navisdk.adapter.BaiduNaviManager.NaviInitListener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class NavigateActivity extends Activity 
{
	public static final String TAG = "NaviSDkDemo";
	public static final String ROUTE_PLAN_NODE = "routePlanNode";
	private String[] route = new String[4];//路径
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//获取传来的路径参数(起点和终点)
		Intent it = super.getIntent();
		route = it.getStringArrayExtra("route");
		//调用地图导航
		routeplanToNavi(route);
	}
	
	//拦截返回键   回传本activity参数
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			setResult(200);
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/*
	 * 移动APP调起Android百度地图
	 * @param route 路径包括起点终点（ 使用的GPS坐标(WGS84)）
	 * */
	private void routeplanToNavi(String[] route) {
	    Intent intent;
		try {
			//通过uri服务调启百度导航客户端，同时将路径参数传递过去
		//	intent = Intent.getIntent("intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:我家&destination=大雁塔&mode=driving&region=西安&src=hubu|BdiduNaviSDK_2_0_0_Demo#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			intent = Intent.getIntent("intent://map/direction?origin=latlng:"+route[1]+","+route[0]+"|name:起点"+"&destination="+route[3]+","+route[2]+"&mode=driving&coord_type=wgs84&src=HUBU|SmartParking#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			startActivity(intent); //启动调用
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

