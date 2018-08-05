package testmod.kadance.com.modules.di.module

import dagger.Module
import android.arch.lifecycle.ViewModel
import dagger.multibindings.IntoMap
import dagger.Binds
import android.arch.lifecycle.ViewModelProvider
import testmod.kadance.com.modules.di.extra.AScope
import testmod.kadance.com.modules.di.extra.ViewModelFactory
import testmod.kadance.com.modules.di.extra.ViewModelKey

@Module(subcomponents = arrayOf())


abstract class ViewModelModule {
//
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(MainVm::class)
//    internal abstract fun vm1(presenter: MainVm): ViewModel
//
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(LangsVm::class)
//    internal abstract fun vm2(presenter: LangsVm): ViewModel
//
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(YtbResultVm::class)
//    internal abstract fun vm3(presenter: YtbResultVm): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(TransDialogVm::class)
//    internal abstract fun vm4(presenter: TransDialogVm): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(TrainingVm::class)
//    internal abstract fun vm5(presenter: TrainingVm): ViewModel
//
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(WebVm::class)
//    internal abstract fun vm6(presenter: WebVm): ViewModel
//
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(DictWordsVm::class)
//    internal abstract fun vm7(presenter: DictWordsVm): ViewModel
//
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(LevelVm::class)
//    internal abstract fun vm8(presenter: LevelVm): ViewModel
//
//    @Binds
//    @IntoMap
//    @ViewModelKey(VideoVm::class)
//    internal abstract fun vm9(presenter: VideoVm): ViewModel


    @AScope
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory




}