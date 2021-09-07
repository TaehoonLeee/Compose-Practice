package com.example.composepractice.di

import com.example.data.di.DataModule
import com.example.domain.repository.UnsplashRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import kotlinx.coroutines.flow.flow
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataModule::class]
)
object FakeDataModule {

    @Provides
    @Singleton
    fun provideUnsplashRepository(): UnsplashRepository {
        return object : UnsplashRepository {
            override fun <T> getSearchResult(query: String) = flow<T> {
                TODO()
            }
        }
    }
}