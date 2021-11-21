package org.techtown.hilteexample.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.techtown.hilteexample.di.qualifier.ActivityHash

@Module
@InstallIn(SingletonComponent::class)
object ActivityModule {

    @ActivityHash
    @Provides
    fun provideHash() = hashCode().toString()
}