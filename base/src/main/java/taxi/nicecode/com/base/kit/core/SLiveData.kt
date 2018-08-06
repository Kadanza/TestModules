package taxi.nicecode.com.base.kit.core

import me.henrytao.livedataktx.SingleLiveData

/**
 * Created by Kenza on 6/13/18
 */
abstract  class SLiveData <T > : SingleLiveData<T>() {



        open fun update(){
            postValue(value)
        }

        var v : T? = value
            set(value) {
                this.value = value
                field = value
            }



    }