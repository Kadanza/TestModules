package taxi.nicecode.com.ftmap

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModel
import android.content.Context
import taxi.nicecode.com.base.kit.core.MLiveData
import taxi.nicecode.com.base.d
import javax.inject.Inject


open class MapVm @Inject constructor() : ViewModel() {


    init {
        d("")
    }



    @Inject  lateinit var ld: MapLd

    @SuppressLint("StaticFieldLeak")
    @Inject  lateinit var context : Context



    open var from = "MapVm"



    class MapLd @Inject constructor() : MLiveData(){
        init {
            d("")
        }

        var x = 56
    }








}

