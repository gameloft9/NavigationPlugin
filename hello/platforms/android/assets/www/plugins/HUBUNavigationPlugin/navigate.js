/*
��һ����"cn.edu.hubu.navigation":��cordova_plugins.js�ж���Ĳ��id
*/
cordova.define("cn.edu.hubu.navigation", function(require, exports, module) { 
var exec = require('cordova/exec');
module.exports = {

    /**
     * 
   execһ��5������:
       ��һ�� :�ɹ��ص�
       �ڶ��� :ʧ�ܻص�
       ������ :��Ҫ���õ�����(��config.xml������,��Ӧ��feature��name���ԣ�value���Ǳ���ʵ�ֵ�java��)
       ���ĸ� :���õķ�����(java����ͨ��actionʶ�𷽷���)
       ����� :���ݵĲ���  ��json�ĸ�ʽ
     */
    startNavigating: function(longtOrig,latOrig,longtDes,latDes) {
        cordova.exec(
        function(winParam){
        	alert(winParam);
        }, 
        function(err) {
           alert('fail'+err);
        }, 
        "HUBUNavigation", "intent", [longtOrig,latOrig,longtDes,latDes]);
    },
};

});
