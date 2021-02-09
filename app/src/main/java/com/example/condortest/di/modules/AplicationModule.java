package com.example.condortest.di.modules;

import com.example.condortest.data.rest.endpoint.LeagueEndPoint;
import com.example.condortest.data.rest.endpoint.TeamEndPoint;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AplicationModule {

    public static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/1/";

    @Singleton
    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor(){
        return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
    }

    @Singleton
    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder().addInterceptor(loggingInterceptor).build();
    }

    @Singleton
    @Provides
    RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Singleton
    @Provides
    //Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory, RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //.addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(client)
                .build();
    }

    @Singleton
    @Provides
    LeagueEndPoint provideLeagueService(Retrofit retrofit) {
        return retrofit.create(LeagueEndPoint.class);
    }

    @Singleton
    @Provides
    TeamEndPoint provideTeamService(Retrofit retrofit) {
        return retrofit.create(TeamEndPoint.class);
    }
}