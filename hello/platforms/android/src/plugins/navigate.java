package plugins;

import java.net.URISyntaxException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;


/**
 * js调用java方法 
 * 
 * 必须继承CordovaPlugin   
 * CordovaPlugin里面有实现cordovaActivity的方法  提供startActivityForResult();
 * 
 * @author 雷尧
 *
 */
public class navigate extends CordovaPlugin {

	/**
	 * 注意 构造方法不能为
	 * 
	 * navigate(){}
	 * 
	 * 可以不写或者 定义为如下
	 * 
	 */
	public navigate() {
	}

	CallbackContext callbackContext;

	/**
	 * 对js接口的实现
	 * */
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
        //根据action判断js调用的是哪个方法
		if (action.equals("intent")) {
			// 获取参数
			String longtOrig = args.getString(0);
			String latOrig = args.getString(1);
			String longtDes = args.getString(2);
			String latDes = args.getString(3);
			
			String[] route = {longtOrig,latOrig,longtDes,latDes};
			this.callBDNavigation(route);
			return true;
		}
		return false;

	}

	/**
	 * 调用百度地图客户端进行导航
	 * @param route 导航起点终点
	 * */
	private void callBDNavigation(String[] route) {
		routeplanToNavi(route);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		//传递返回值 给js方法
		callbackContext.success("调用NavigateActivity成功！");
	}
	
	
	
	/**
	 * 移动APP调起Android百度地图
	 * @param route 路径包括起点终点（ 使用的GPS坐标(WGS84)）
	 * */
	private void routeplanToNavi(String[] route) {
	    Intent intent;
		try {
			//通过uri服务调启百度导航客户端，同时将路径参数传递过去
		//	intent = Intent.getIntent("intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:我家&destination=大雁塔&mode=driving&region=西安&src=hubu|BdiduNaviSDK_2_0_0_Demo#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			intent = Intent.getIntent("intent://map/direction?origin=latlng:"+route[1]+","+route[0]+"|name:起点"+"&destination="+route[3]+","+route[2]+"&mode=driving&coord_type=wgs84&src=HUBU|SmartParking#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			cordova.startActivityForResult((CordovaPlugin) this,intent, 200);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
