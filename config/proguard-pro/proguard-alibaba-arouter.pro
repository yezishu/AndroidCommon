#albaba arouter
-keep public class com.alibaba.android.arouter.routes.**{*;}
-keep class * implements com.alibaba.android.arouter.facade.template.ISyringe{*;}
-keep public class javax.lang.model.element.Element{*;}
-dontwarn javax.lang.model.element.Element
