package plugins;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.content.Intent;
import android.util.Log;
import android.widget.Toast;


/**
 * js����java���� 
 * 
 * ����̳�CordovaPlugin   
 * CordovaPlugin������ʵ��cordovaActivity�ķ���  �ṩstartActivityForResult();
 * 
 * ��ʹ�õ�   cordova  3.3.0�汾
 * @author Baozi
 *
 */
public class Plugin_intent extends CordovaPlugin {

	/**
	 * ע�� ���췽������Ϊ
	 * 
	 * Plugin_intent(){}
	 * 
	 * ���Բ�д���� ����Ϊ����
	 * 
	 */
	public Plugin_intent() {
	}

	CallbackContext callbackContext;

	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		this.callbackContext = callbackContext;
		Log.i("12333333333333333333", action);
        //����action�ж�js���õ����ĸ�����
		if (action.equals("intent")) {
			// ��ȡargs�ĵ�һ������
			String message = args.getString(0);
			this.function(message);
			return true;
		}
		return false;

	}

	private void function(String msg) {
		// cordova.getActivity() ��ȡ��ǰactivity��this
		//�ڴ˴����ðٶȵ�ͼ����
		Log.i("123", cordova.getActivity().toString());
		//Intent intent = new Intent(cordova.getActivity(), DemoActivity.class);
		//cordova.startActivityForResult((CordovaPlugin) this,intent, 200);
		Toast.makeText(cordova.getActivity(), "������óɹ��� "+msg, 0).show();

	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		super.onActivityResult(requestCode, resultCode, intent);
		//���ݷ���ֵ ��js����
		callbackContext.success("activity ��ת�ɹ���");
		Toast.makeText(cordova.getActivity(), "123", 0).show();

	}

}
