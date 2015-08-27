cordova.define('cordova/plugin_list', function(require, exports, module) {
module.exports = [
    //edit by leiyao 2015.8.25
    //1、手动添加插件模块。    
    //  file：接口所在js文件.
    //    id：插件Id.
    //merges: 在 javascript中调用该插件的名称
    {  
        "file": "plugins/intent.js",  
        "id": "org.apache.cordova.intent",  
        "merges": [  
            "navigator.intent"  
        ]  
    },  
     {  
        "file": "plugins/HUBUNavigationPlugin/navigate.js",  
        "id": "cn.edu.hubu.navigation",  
        "merges": [  
            "navigator.HUBUNavigate"  
        ]  
    },  
    {
        "file": "plugins/cordova-plugin-whitelist/whitelist.js",
        "id": "cordova-plugin-whitelist.whitelist",
        "runs": true
    }
];
module.exports.metadata = 
//edit by leiyao 2015.8.25
//2、还要添加元数据
//设定插件版本号
// TOP OF METADATA
{
    "org.apache.cordova.intent" :"0.0.1",  
    "cn.edu.hubu.navigation" :"0.0.1",  
    "cordova-plugin-whitelist": "1.0.0"
}
// BOTTOM OF METADATA
});