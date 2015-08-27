
/**
 * ������ðٶȵ���
 * 
 * ˵���������������Ϊ�м�activity�����ðٶȵ�ͼ�ͻ��ˣ����ڿ�����ʵ��js�ӿڵ�����ֱ��
 * ���ðٶȵ�ͼ�ͻ��ˣ����Ը�����������Ҫʹ�ðٶ�android����SDK��������Ǳ���ġ�
 * ��Ϊʵ��SDK����̳���activity�࣬��ʵ��js�ӿڵ������̳���cordovaplugin�ࡣ
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
	private String[] route = new String[4];//·��
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//��ȡ������·������(�����յ�)
		Intent it = super.getIntent();
		route = it.getStringArrayExtra("route");
		//���õ�ͼ����
		routeplanToNavi(route);
	}
	
	//���ط��ؼ�   �ش���activity����
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			setResult(200);
			finish();
		}
		return super.onKeyDown(keyCode, event);
	}
	
	/*
	 * �ƶ�APP����Android�ٶȵ�ͼ
	 * @param route ·����������յ㣨 ʹ�õ�GPS����(WGS84)��
	 * */
	private void routeplanToNavi(String[] route) {
	    Intent intent;
		try {
			//ͨ��uri��������ٶȵ����ͻ��ˣ�ͬʱ��·���������ݹ�ȥ
		//	intent = Intent.getIntent("intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:�Ҽ�&destination=������&mode=driving&region=����&src=hubu|BdiduNaviSDK_2_0_0_Demo#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			intent = Intent.getIntent("intent://map/direction?origin=latlng:"+route[1]+","+route[0]+"|name:���"+"&destination="+route[3]+","+route[2]+"&mode=driving&coord_type=wgs84&src=HUBU|SmartParking#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			startActivity(intent); //��������
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

