package testmod.kadance.com.modules.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import dagger.Binds
import dagger.Component
import dagger.Module
import dagger.Subcomponent
import dagger.android.support.AndroidSupportInjectionModule
import dagger.multibindings.IntoMap
import taxi.nicecode.com.base.d
import taxi.nicecode.com.ftmap.MapVm
import taxi.nicecode.com.ftreg.RegVm
import testmod.kadance.com.modules.di.extra.AScope
import testmod.kadance.com.modules.di.extra.ViewModelFactory
import testmod.kadance.com.modules.di.extra.ViewModelKey
import testmod.kadance.com.modules.di.module.ViewModelModule
import javax.inject.Inject


@Module(subcomponents = arrayOf())
abstract class  FxViewModelModule  {


    init {
        d("")
    }

    @Binds
    @IntoMap
    @ViewModelKey(FxMapVm::class)
    internal abstract fun vm1(presenter: FxMapVm): ViewModel



    @Binds
    @IntoMap
    @ViewModelKey(RegVm::class)
    internal abstract  fun vm2(presenter: RegVm): ViewModel



    @AScope
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory



    class  FxMapVm @Inject constructor() : MapVm(){

        init {
            d("")
        }

        override var from = "FxMapVm"

    }
//


}