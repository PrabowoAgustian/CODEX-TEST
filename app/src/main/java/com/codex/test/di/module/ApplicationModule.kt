package com.codex.test.di.module

import android.content.Context
import com.codex.test.CodexTestApp
import com.codex.test.base.restapi.RestApi
import com.codex.test.base.restapi.RestApiAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Named("ApplicationContext")
    @Provides
    @Singleton
    fun provideContext(application: CodexTestApp): Context {
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideRestApi(): RestApi {
        return RestApiAdapter.createRestApi()
    }
}