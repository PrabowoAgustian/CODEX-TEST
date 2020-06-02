package com.codex.test.di.component

import com.codex.test.CodexTestApp
import com.codex.test.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApplicationModule::class,
        GsonModule::class,
        JsonParserModule::class,
        PreferenceModule::class,
        ActivityBindingModule::class,
        SchedulerFacadeModule::class]
)

interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: CodexTestApp): Builder

        fun build(): ApplicationComponent
    }

    fun inject(application: CodexTestApp)

}