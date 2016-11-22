package jfuentesa.swapi_sample.di.module;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.jfuentes.swapi_sample.net.RestApiService;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jfuentesa on 17/11/2016.
 */

@Module
public class NetModule {

    private static final String BASE_URL = "http://swapi.co/api/";

    public NetModule() { }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(){
        return  new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15,TimeUnit.SECONDS)
                .addNetworkInterceptor(new StethoInterceptor())
                .build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    RestApiService provideApiService(Retrofit retrofit){
        return retrofit.create(RestApiService.class);
    }
}
