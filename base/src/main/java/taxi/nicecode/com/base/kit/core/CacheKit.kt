package taxi.nicecode.com.base.kit.core

import android.content.SharedPreferences
import com.google.gson.Gson
import taxi.nicecode.com.base.w
import java.util.*
import javax.inject.Inject

/**
 *
 * For holding cached  data
 *
 * Created by DmitryGribkov on 12.10.2017.
 */
class CacheKit  constructor ( var mPrefs: SharedPreferences , var gson: Gson)  {




    /**
     *  save any object to shared preferences
     */

    fun <T> saveToLocale(x : T, tag : String, timeExists: Long = -1 ){

        val time = if( timeExists != -1L ){ Date().time + timeExists } else{ -1L }


        val prefsEditor = mPrefs.edit()
        val json = gson.toJson(x)


        prefsEditor.putString(tag, json)
        prefsEditor.putLong(tag + "deltaTime", time)

        prefsEditor.apply()
    }

    fun <T> loadFromLocale(clazz: Class<T>,  tag : String): T? {
        try {
            val json = mPrefs.getString(tag, " ")
            val time = mPrefs.getLong(tag+ "deltaTime", -1)
            val x = gson.fromJson(json, clazz)
            if(time  == -1L ){ return  x }
            if(time <= Date().time){ return  null }
            return x
        }catch (e :Exception){
            w("", e)
        }

        return  null
    }

}
