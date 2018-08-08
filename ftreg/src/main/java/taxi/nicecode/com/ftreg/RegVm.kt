package taxi.nicecode.com.ftreg

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import android.content.Context
import taxi.nicecode.com.base.d
import taxi.nicecode.com.base.kit.core.MLiveData
import javax.inject.Inject

class RegVm  @Inject constructor() : ViewModel() {




    @Inject lateinit var ld: RegLd

    @SuppressLint("StaticFieldLeak")
    @Inject lateinit var context : Context




    class RegLd @Inject constructor() : MLiveData(){
        init {
            d("")
        }

        var x = 34
    }






}

