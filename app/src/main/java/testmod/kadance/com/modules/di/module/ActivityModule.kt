package testmod.kadance.com.modules.di.module

import testmod.kadance.com.modules.di.extra.AScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import taxi.nicecode.com.ftmap.MapActivity
import taxi.nicecode.com.ftreg.RegActivity

@AScope
@Module
abstract class ActivityModule {
//
    @ContributesAndroidInjector
    internal abstract fun act1(): MapActivity

    @ContributesAndroidInjector
    internal abstract fun act2(): RegActivity












}

