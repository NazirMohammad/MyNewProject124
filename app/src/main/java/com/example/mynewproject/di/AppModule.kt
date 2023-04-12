package com.example.mynewproject.di

import com.example.mynewproject.data.remote.ApiDetails
import com.example.mynewproject.data.remote.ApiRequests
import com.example.mynewproject.data.repository.Repository
import com.example.mynewproject.data.repository.RepositoryImp
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
@Module
@InstallIn(SingletonComponent::class)
class AppModule {

        @Provides
        fun ProvideGson(): Gson {
            return Gson()

        }

        @Provides
        fun ProvideOkhttp(): OkHttpClient {
            return OkHttpClient.Builder()
                .addInterceptor(
                    HttpLoggingInterceptor().apply {
                        level = HttpLoggingInterceptor.Level.BODY
                    }

                )
                .build()

        }

        @Provides
        @Singleton
        fun ProvidesRetrofit(
            gson: Gson,
            client: OkHttpClient
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(ApiDetails.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build()

        }


        @Provides
        fun provideAPI(
            retrofit: Retrofit
        ): ApiRequests {
            return retrofit.create(ApiRequests::class.java)
        }


        @Provides
        fun ProvideRepository(apiRequest: ApiRequests): Repository {
            return RepositoryImp(apiRequest)

        }
    }
