package com.example.data.di

import com.example.data.network.UnsplashService
import com.example.data.repository.UnsplashRepositoryImpl
import com.example.domain.interactor.GetSearchResultUseCase
import com.example.domain.repository.UnsplashRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.okhttp.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideHttpClient(): HttpClient {
        return HttpClient(OkHttp) {
            defaultRequest {
                headers {
                    append("Accept-Version", "v1")
                    append(HttpHeaders.Authorization, "Client-ID ti90oMOJyxTN-gKrvE39bi6LM2tbMAdOvey4QMKES0k")
                }
                url {
                    protocol = URLProtocol.HTTPS
                    host = "api.unsplash.com"
                }
            }
            install(JsonFeature) {
                GsonSerializer()
            }
        }
    }

    @Provides
    @Singleton
    fun provideUnsplashService(httpClient: HttpClient): UnsplashService {
        return UnsplashService(httpClient)
    }

    @Provides
    @Singleton
    fun provideUnsplashRepository(unsplashService: UnsplashService): UnsplashRepository {
        return UnsplashRepositoryImpl(unsplashService)
    }
}