/*
��һ����"org.apache.cordova.intent":��cordova_plugins.js�ж���Ĳ��id
*/
cordova.define("org.apache.cordova.intent", function(require, exports, module) { 
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
    demo: function(mills) {
        cordova.exec(function(winParam){
        	alert(winParam);
        }, null, "Demo", "intent", [mills]);
    },
};

});
