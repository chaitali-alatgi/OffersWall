package com.ca.offerswall.app.di.application;

import com.ca.offerswall.data.source.network.INetworkEndpoint;
import com.ca.offerswall.ui.BaseApplication;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import static com.ca.offerswall.utils.Constants.BASE_URL;

@Module
public class NetworkModule {
    BaseApplication baseApplication;

    public NetworkModule(BaseApplication application) {
        baseApplication = application;
    }

    @Provides
    @Singleton
    Cache provideCache() {
        int cacheSize = 15 * 1024 * 1024;   // 15 MB
        return new Cache(baseApplication.getCacheDir(), cacheSize);
    }

    @Provides
    @Singleton
    Gson provideGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.setFieldNamingStrategy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return builder.create();
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(Cache cache) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.cache(cache);
        builder.readTimeout(2, TimeUnit.MINUTES);
        builder.connectTimeout(2, TimeUnit.MINUTES);
        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                return response;
            }
        });
        return builder.build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(Gson gson, Cache cache, OkHttpClient okHttpClient) {
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl(BASE_URL);
        builder.addCallAdapterFactory(RxJava2CallAdapterFactory.create());
        builder.addConverterFactory(GsonConverterFactory.create());
        builder.client(okHttpClient);
        return builder.build();
    }

    @Provides
    @Singleton
    INetworkEndpoint provideApi(Retrofit retrofit) {
        return retrofit.create(INetworkEndpoint.class);
    }
}
