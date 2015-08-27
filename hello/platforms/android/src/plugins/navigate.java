package plugins;

import java.net.URISyntaxException;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Intent;


/**
 * js����java���� 
 * 
 * ����̳�CordovaPlugin   
 * CordovaPlugin������ʵ��cordovaActivity�ķ���  �ṩstartActivityForResult();
 * 
 * @author ��Ң
 *
 */
public class navigate extends CordovaPlugin {

	/**
	 * ע�� ���췽������Ϊ
	 * 
	 * navigate(){}
	 * 
	 * ���Բ�д���� ����Ϊ����
	 * 
	 */
	public navigate() {
	}

	CallbackContext callbackContext;

	/**
	 * ��js�ӿڵ�ʵ��
	 * */
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
        //����action�ж�js���õ����ĸ�����
		if (action.equals("intent")) {
			// ��ȡ����
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
	 * ���ðٶȵ�ͼ�ͻ��˽��е���
	 * @param route ��������յ�
	 * */
	private void callBDNavigation(String[] route) {
		routeplanToNavi(route);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);
		//���ݷ���ֵ ��js����
		callbackContext.success("����NavigateActivity�ɹ���");
	}
	
	
	
	/**
	 * �ƶ�APP����Android�ٶȵ�ͼ
	 * @param route ·����������յ㣨 ʹ�õ�GPS����(WGS84)��
	 * */
	private void routeplanToNavi(String[] route) {
	    Intent intent;
		try {
			//ͨ��uri��������ٶȵ����ͻ��ˣ�ͬʱ��·���������ݹ�ȥ
		//	intent = Intent.getIntent("intent://map/direction?origin=latlng:34.264642646862,108.95108518068|name:�Ҽ�&destination=������&mode=driving&region=����&src=hubu|BdiduNaviSDK_2_0_0_Demo#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			intent = Intent.getIntent("intent://map/direction?origin=latlng:"+route[1]+","+route[0]+"|name:���"+"&destination="+route[3]+","+route[2]+"&mode=driving&coord_type=wgs84&src=HUBU|SmartParking#Intent;scheme=bdapp;package=com.baidu.BaiduMap;end");
			cordova.startActivityForResult((CordovaPlugin) this,intent, 200);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
