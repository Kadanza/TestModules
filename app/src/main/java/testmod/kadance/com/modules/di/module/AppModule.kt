package testmod.kadance.com.modules.di.module

import android.content.Context
import android.speech.tts.TextToSpeech
import com.google.gson.Gson
import testmod.kadance.com.modules.di.extra.AScope
import dagger.Module
import dagger.Provides

@Module
open class AppModule(open val context: Context) {


    @Provides
    fun context(): Context {
        return context
    }
//
//    private var mConfig: RealmConfiguration? = null
//
//    //    @Singletons
//    @Provides
//    fun realm(): Realm {
//        Realm.init(context)
//        val bdName = "realm7s265j86529996.bd"
//        val migration = Migration()
//
//
//        if (mConfig == null) {
//            mConfig = RealmConfiguration.Builder()
//                    .schemaVersion(1)
//                    .name(bdName)
//                    .migration(migration)
//                    .initialData {
//                        migration.initBD(it)
//                    }
//                    .build()
//        }
//
//
//        return Realm.getInstance(mConfig!!)
//    }
//
//
//    @AScope
//    @Provides
//    fun logKit(): LogKit {
//        return LogKit()
//    }
//
//    var googleTtsPackage = "com.google.android.tts"
//    var picoPackage = "com.svox.pico"
//
//    @AScope
//    @Provides
//    fun tts(): TextToSpeech {
//        return  TextToSpeech( LingApp.appComponent?.getContext(), TextToSpeech.OnInitListener {
//
//
//        } , picoPackage)
//    }
//
//
//
//    @AScope
//    @Provides
//    fun systemRepo(): SystemRepo {
//        return SystemRepo()
//    }
//
//    @AScope
//    @Provides
//    fun cacheKit(context: Context): CacheKit {
//        return CacheKit(context.getSharedPreferences("CacheKit", Context.MODE_PRIVATE), Gson())
//    }


}