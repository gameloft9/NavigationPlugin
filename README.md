# NavigationPlugin
This is a navigation plugin for Cordova / PhoneGap based on BaiDu LBS.

Supported Platforms

Android


Note: The plugin is based on BaiDu LBS,which means it uses BaiDu's URI service to start navigation with BaiDu map client.You have to register BaiDu's relevant service(Android SDK) to get the key so that you can use its URI service.
You may find useful information in this url:http://developer.baidu.com/map/index.php?title=%E9%A6%96%E9%A1%B5
  Once you get the key,then you can replace the key in AndroidManifest.xml，like this:
    <meta-data android:name="com.baidu.lbsapi.API_KEY"
		    android:value="your key" />

Using the plugin

The plugin creates the object navigator.HUBUNavigate with the method startNavigating(longtOrig,latOrig,longtDes,latDes);

A full example could be:


    function navigate() {  
           var longtOrig = 114.324775;
           var latOrig = 30.580747;
           var longtDes = 114.390421;
           var latDes = 30.501860;
           
           navigator.HUBUNavigate.startNavigating(longtOrig,latOrig,longtDes,latDes);
             }    

Thanks on Github

Licence

The MIT License

Copyright (c) 2010 Matt Kane

Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
