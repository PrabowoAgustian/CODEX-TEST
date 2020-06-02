package com.codex.test.di.module

import com.codex.test.utils.BaseSchedulerProvider
import com.codex.test.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SchedulerFacadeModule {
    @Provides
    @Singleton
    fun provideSchedule(): BaseSchedulerProvider {
        return SchedulerProvider()
    }
}