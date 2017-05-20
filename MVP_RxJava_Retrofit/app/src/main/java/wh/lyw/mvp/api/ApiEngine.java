package wh.lyw.mvp.api;

import java.io.File;
import java.util.concurrent.TimeUnit;

import wh.lyw.mvp.MyApplication;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Nicholas on 2016/10/30.
 */

public class ApiEngine {

    private volatile static ApiEngine apiEngine;
    private Retrofit retrofit;
    private static OkHttpClient mClient;
    private ApiService mApiService;

    private ApiEngine() {
    }

    public static ApiEngine getInstance() {
        if (apiEngine == null) {
            synchronized (ApiEngine.class) {
                if (apiEngine == null) {
                    apiEngine = new ApiEngine();
                }
            }
        }
        //日志拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //缓存
        int size = 1024 * 1024 * 100;
        File cacheFile = new File(MyApplication.getContext().getCacheDir(), "OkHttpCache");
        Cache cache = new Cache(cacheFile, size);

        mClient = new OkHttpClient.Builder()
                .connectTimeout(12, TimeUnit.SECONDS)
                .writeTimeout(12, TimeUnit.SECONDS)
                .writeTimeout(12, TimeUnit.SECONDS)
                .addNetworkInterceptor(new NetworkInterceptor())
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();
        return apiEngine;
    }

    public ApiService getApiService() {
        if (mApiService == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.BASE_URL)
                    .client(mClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mApiService = retrofit.create(ApiService.class);
        }
        return mApiService;
    }
    public ApiService getWeather() {
        if (mApiService == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiService.WEATHER_URL)
                    .client(mClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            mApiService = retrofit.create(ApiService.class);
        }
        return mApiService;
    }


}
