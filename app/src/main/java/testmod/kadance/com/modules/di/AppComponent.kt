package testmod.kadance.com.modules.di

import android.content.Context
import android.speech.tts.TextToSpeech
import testmod.kadance.com.modules.di.extra.AScope
import testmod.kadance.com.modules.di.module.ActivityModule
import testmod.kadance.com.modules.di.module.AppModule
import testmod.kadance.com.modules.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication

@AScope
//@Singleton
@Component(
        modules = arrayOf(
                AndroidSupportInjectionModule::class,
                ActivityModule::class,
                AppModule::class
                , ViewModelModule::class
        )
)
interface AppComponent : AndroidInjector<DaggerApplication> {

        fun getContext(): Context


    //    fun getMainPresenter(): MapPresenter
//    fun getDetailPresenter(): DetailPresenter

}


