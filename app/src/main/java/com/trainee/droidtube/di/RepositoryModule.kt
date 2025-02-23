package com.trainee.droidtube.di

import com.trainee.droidtube.data.repository.VideoRepositoryImpl
import com.trainee.droidtube.domain.VideoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindVideoRepository(
        videoRepository: VideoRepositoryImpl
    ) : VideoRepository
}