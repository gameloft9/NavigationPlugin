/*
第一行中"cn.edu.hubu.navigation":在cordova_plugins.js中定义的插件id
*/
cordova.define("cn.edu.hubu.navigation", function(require, exports, module) { 
var exec = require('cordova/exec');
module.exports = {

    /**
     * 
   exec一共5个参数:
       第一个 :成功回调
       第二个 :失败回调
       第三个 :将要调用的类名(在config.xml中配置,对应于feature的name属性，value就是本地实现的java类)
       第四个 :调用的方法名(java类中通过action识别方法名)
       第五个 :传递的参数  以json的格式
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
