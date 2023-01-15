


# PersianMaterialToast
Android Java Persian Beatiful Toast With Animations and Fonts

>Created By @Mehrdadhbs in 2023/01/14
more info 
https://www.mehrdadhbs.ir

#

![screenshot1](https://s2.uupload.ir/files/screenshot_2023-01-14-13-14-03_kcsm.png)
>Step 1. Add the JitPack repository to your build file
```Gradle Settings
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
 > Step 2. Add the dependency
 ``` Gradle
 dependencies {
	        implementation 'com.github.Mehrdadhbs78:PersianMaterialToast:1.0.0'
	}
```

How To Use (Java Code)

> Toast Make Java File (Updated)
```
new MaterialToast(context).setTitleText(titleText).setMainText(subText).show(MaterialToast.TOAST_SUCCESS);
```       



 > Info Type
 
```
materialToast.show(MaterialToast.TOAST_INFO);
```


 > Warning Type
 ```
materialToast.show(MaterialToast.TOAST_WARNING);
```


 > Error Type
 ```
materialToast.show(MaterialToast.TOAST_WARNING);
```

Thanks To 
https://github.com/airbnb/lottie-android

And Material ProgressBar
https://github.com/MackHartley/RoundedProgressBar


More info
This Library has used IRANSanse Font for get beatiful in the design form
