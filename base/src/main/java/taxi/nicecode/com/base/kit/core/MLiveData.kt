package taxi.nicecode.com.base.kit.core

import android.arch.lifecycle.*
import android.content.Context
import android.view.View
import taxi.nicecode.com.base.showToast
import taxi.nicecode.com.base.w
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import me.henrytao.livedataktx.SingleLiveData
import me.henrytao.livedataktx.debounce
import me.henrytao.livedataktx.observe
import javax.inject.Inject


/**
 *  Created by Kenza on 10.05.18
 */
abstract class MLiveData : MutableLiveData<Any>(), LifecycleObserver {


    init {
        //LingApp.appComponent?.inject(this)
        this.postValue(Any())
    }

   // @Inject lateinit var dataRepo : DataRepo
   // @Inject lateinit var context : Context


    val single = SingleLiveData<Any>()
   // val updater = UpdateMaster(this)
    val map = HashMap<String, UpdateMaster>()

    class Action(
            val comparison: ((it: MLiveData) -> Boolean)? = null,
            val views: Array<out Any> = arrayOf(),
            val force: Boolean = false,
            val callback: ((it: MLiveData) -> Unit)? = null)


    open fun updateUi() {
        postValue(value)
    }



    fun observes(owner: LifecycleOwner,
                 initUi: ((it: UpdateMaster) -> Unit)? = null,
                 singleUpdateUi: ((it: Any) -> Unit)? = null,
                 updateUi: ( (it: MLiveData) -> Unit)? = null) {

        //  if (acts != null) {

        val key = owner.toString()

        var updater = map.get(key)

        if(updater == null){
            updater = UpdateMaster(this)
            map.put(key, updater)
        }



        updater.acts = ArrayList()
        initUi?.invoke(updater)

        owner.lifecycle.addObserver(object  : LifecycleObserver {

            @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
            fun onLifeDestroy() {
                map.remove(key)
            }

        })


        //  }
        this.debounce(10).observe(owner) {
            val  updater = map.get(key)
            updater?.updateUi()
            updateUi?.invoke(this)
        }


        single.debounce(10).observe(owner) {
            async (UI) {
                singleUpdateUi?.invoke(it)
            }

        }

        updater.updateUi()
        updateUi()
    }

    fun isStateChanged(): Boolean {
        return true
    }


    class UpdateMaster(val data: MLiveData) {


        var acts = ArrayList<Action>()
        val pub = PublishSubject.create<Any>()

        private var dis: Disposable? = null


        fun with(
                comparison: ((it: MLiveData) -> Boolean)? = null,
                vararg views: Any = arrayOf(),
                force: Boolean = false,
                callback: ((it: MLiveData) -> Unit)? = null) {

            val act = Action(comparison, views, force, callback)
            acts.add(act)
        }

        fun just(vararg views: Any = arrayOf(),
                 force: Boolean = false,
                 callback: ((it: MLiveData) -> Unit)? = null) {

            val act = Action(null, views, force, callback)
            acts.add(act)
        }


        fun updateUi() {

            if (dis == null) {
                dis = pub.observeOn(AndroidSchedulers.mainThread()).subscribe({


                    for (y in acts) {

                        var cursor = "0"
                        if (y.comparison?.invoke(data) != false) {

                            for (x in y.views) {

                                if (x is String) {
                                    cursor = x
                                }

                                if (x is View) {
                                    if (y.force || data.isStateChanged()) {
                                        when (cursor.trim()) {
                                            "2" -> x.visibility = View.INVISIBLE
                                            "1" -> x.visibility = View.VISIBLE
                                            "0" -> x.visibility = View.GONE

                                            else -> {
                                                throw Exception("cant updateUi Ui with cursor = $cursor")
                                            }
                                        }
                                    }
                                }
                            }

                            y.callback?.invoke(data)
                        }


                    }


                }, {
                    w(it)

//                    if (com.kadance.ling.BuildConfig.DEBUG) {
//                        showToast(LingApp.appComponent?.getContext()!!, "Debug : Error in updateUI!")
//                    }
                })
            }
            pub.onNext(Any())
        }

    }
}

