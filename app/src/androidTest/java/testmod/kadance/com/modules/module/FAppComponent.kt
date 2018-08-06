package testmod.kadance.com.modules.module

import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import testmod.kadance.com.modules.di.AppComponent
import testmod.kadance.com.modules.di.extra.AScope
import testmod.kadance.com.modules.di.module.ActivityModule
import testmod.kadance.com.modules.di.module.AppModule

@AScope
@Component(
        modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityModule::class,
        AppModule::class,
                FxViewModelModule::class
))//dependencies =  arrayOf( AppComponent::class ))
interface FAppComponent  : AppComponent {


}