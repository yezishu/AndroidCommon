package yzs.commonlibrary.data.net;

import com.zhy.http.okhttp.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import yzs.commonlibrary.util.LogUtil;

/**
 * by Andy.Wu on 2016/7/4.
 */
public class RetrofitUtils {
    private Retrofit retrofit; //retrofit对象
    private OkHttpClient okHttpClient; //okhttp客户端

    //在访问HttpMethods时创建单例
    private static class SingletonHolder {
        private static final RetrofitUtils INSTANCE = new RetrofitUtils();
    }

    //获取单例
    public static RetrofitUtils getInstance() {
        return SingletonHolder.INSTANCE;
    }

    //构造方法私有
    private RetrofitUtils() {
        okHttpClient = OkHttpUtils.getInstance().getOkHttpClient();
    }

    /**
     * 获取retrofit对象
     * @param baseUrl
     * @return
     */
    public Retrofit getRetrofit(String baseUrl) {
        if (okHttpClient == null) getInstance();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(ScalarsConverterFactory.create()) // 返回值为String的支持
                .addConverterFactory(GsonConverterFactory.create()) // 返回值为Gson的支持(以实体类返回)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(baseUrl)
                .build();
        return retrofit;
    }

    public Retrofit getRetrofit() {
        return retrofit;
    }

    /**
     * 快捷取得请求map
     * @return
     */
    public static Map<String,Object> getRequestMap(){
        Map<String, Object> parameterMap = new HashMap<>();
//        parameterMap.put(HttpParameter.REQUEST_KEY_TOKEN, ApplicationUtil.getToken());
        return parameterMap;
    }

    public static Interceptor getOkHttpLogInterceptor() {
        // Log信息拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                LogUtil.d(message);
            }
        });
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return loggingInterceptor;
    }
}
