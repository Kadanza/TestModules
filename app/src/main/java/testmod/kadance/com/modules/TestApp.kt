package testmod.kadance.com.modules


import com.arranlomas.daggerviewmodelhelper.AppInjector
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import taxi.nicecode.com.base.IAppNavigator
import taxi.nicecode.com.base.showActivity
import taxi.nicecode.com.ftmap.MapActivity
import taxi.nicecode.com.ftreg.RegActivity
import testmod.kadance.com.modules.di.AppComponent
import testmod.kadance.com.modules.di.DaggerAppComponent
import testmod.kadance.com.modules.di.module.AppModule

/**
 * Created by Kenza on 05.08.2018.
 */

class TestApp : DaggerApplication(), IAppNavigator {


    override fun openReg() {
        showActivity(RegActivity::class.java)
    }

    override fun openMap() {
        showActivity(MapActivity::class.java)
    }


    companion object {
        var appComponent: AppComponent? = null
    }

    fun setComponent(component: AppComponent) {
        TestApp.appComponent = component
        appComponent?.inject(this)

    }

    public override fun applicationInjector(): AndroidInjector<DaggerApplication> {
        val module = AppModule(this)
        appComponent = DaggerAppComponent.builder().appModule(module).build()!!
        appComponent?.inject(this)
        return appComponent!!
    }


    override fun onCreate() {
        AppInjector.init(this)

        RxJavaPlugins.setErrorHandler { e ->
            if (e is UndeliverableException) {
                // w("Undeliverable exception received, not sure what to do", e)
            }
//            if (e is IOException || e is SocketException) {
//                // fine, irrelevant network problem or API that throws on cancellation
//                return@RxJavaPlugins.setErrorHandler
//            }
            if (e is InterruptedException) {
                // fine, some blocking code was interrupted by a dispose call
                return@setErrorHandler
            }
//            if (e is NullPointerException || e is IllegalArgumentException) {
//                // that's likely a bug in the application
//                Thread.currentThread().uncaughtExceptionHandler
//                        .handleException(Thread.currentThread(), e)
//                return@RxJavaPlugins.setErrorHandler
//            }
//            if (e is IllegalStateException) {
//                // that's a bug in RxJava or in a custom operator
//                Thread.currentThread().uncaughtExceptionHandler
//                        .handleException(Thread.currentThread(), e)
//                return@RxJavaPlugins.setErrorHandler
//            }
        }

        super.onCreate()
    }
}