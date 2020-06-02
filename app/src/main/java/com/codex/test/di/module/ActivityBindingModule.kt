package com.codex.test.di.module

import com.codex.test.feature.splashscreen.AfterSplashScreenActivity
import com.codex.test.feature.story.TopStoryActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    internal abstract fun bindAfterSplashScreenActivity(): AfterSplashScreenActivity

    @ContributesAndroidInjector
    internal abstract fun bindTopStoryActivity(): TopStoryActivity
}