# 过滤掉存放所有JavaBean（实体类)的包不进行混淆编译。
-keep class yzs.itaxi.data.module.** {*;}
#-keep class cn.com.zoenet.xjdoctor.thirdparty.** {*;}
#-keep class cn.com.zoenet.xjdoctor.event.** {*;}
#-keep class cn.com.zoenet.xjdoctor.common.database.** {*;}
# 这几个遗留的类SignedUserModel没去移动
#-keep class cn.com.zoenet.xjdoctor.view.function.addressbook.SignedUserModel {*;}
#-keep class cn.com.zoenet.xjdoctor.view.function.team.MyTeamVo {*;}
#-keep class cn.com.zoenet.xjdoctor.view.function.team.TeamBean {*;}
#-keep class cn.com.zoenet.xjdoctor.view.function.team.TeamInfo {*;}
#-keep class cn.com.zoenet.xjdoctor.view.function.team.TeamMemberBean {*;}
#-keep class cn.com.zoenet.xjdoctor.view.** {*;}
#不要混淆类的所有属性与方法
#-keepclasseswithmembers class AutoContentFrameLayout {
#    <fields>;
#    <methods>;
#}
#不要混淆类所有子类的属性与方法
#-keepclasseswithmembers class * extends AutoContentFrameLayout{
#    <fields>;
#    <methods>;
#}
-dontwarn com.zhy.**
-keep class com.zhy.** {*;}

