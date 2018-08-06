package taxi.nicecode.com.base

import android.annotation.SuppressLint
import android.arch.lifecycle.ViewModelProvider
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import com.arranlomas.daggerviewmodelhelper.Injectable
import taxi.nicecode.com.base.kit.core.MLiveData
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@SuppressLint("Registered")
open class BaseActivity : AppCompatActivity() , Injectable {

    val pattern = "blulurbl"
    var actions = ""

    @Inject
    open lateinit var modelFactory: ViewModelProvider.Factory
    val dbag = CompositeDisposable()

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        val metrics = getResources().getDisplayMetrics()
        val h = metrics.heightPixels
        val w = metrics.widthPixels
        val x = event?.x
        val y = event?.y
        if(event?.action == MotionEvent.ACTION_DOWN){

            val isBottom = y!! > h/2
            val isRight = x!! > w/2

            if(isBottom){
                actions += "b"
            }else{
                actions += "u"
            }

            if(isRight){
                actions += "r"
            }else{
                actions += "l"
            }

            if(actions.length > pattern.length) { actions = actions.substring(2,pattern.length + 2) }

            if(actions.equals(pattern)){
                Toast.makeText(this, "touch done!", Toast.LENGTH_SHORT).show()
            }


        }
        Log.i("tag", " $x $y $h $w")
        Log.i("tag", " actions $actions ")
        return super.onTouchEvent(event)
    }



    open fun getLifeData() : MLiveData? {
        return null
    }


    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

//    override fun setTitle(title: CharSequence) {
//        getSupportActionBar()?.setDisplayShowTitleEnabled(false)
//        toolbar_title.text =  title
//    }

    override fun onDestroy() {
        super.onDestroy()
        dbag.clear()
    }



}