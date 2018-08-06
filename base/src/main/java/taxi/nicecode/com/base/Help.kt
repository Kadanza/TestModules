package taxi.nicecode.com.base

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.support.v4.content.ContextCompat
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import taxi.nicecode.com.base.kit.core.HideSoftKeyboard

@SuppressLint("StaticFieldLeak")
object Help {


    var context : Context? = null


    val scale: Float
        get() {
            return context?.getResources()?.getDisplayMetrics()?.density ?: 0f
        }


    fun getPixelsByDp(dp: Int): Int {
        return (dp * scale + 0.5f).toInt()
    }




    fun getColorByResId(context : Context, resId : Int): Int {
         return  ContextCompat.getColor(context, resId)
    }



    fun hideKeyBoard( context : Context){
        val act = (context as Activity)
        HideSoftKeyboard.hideKeyboard(act)
        act.getWindow().getDecorView().clearFocus()
    }



    fun showKeyBoard(context: Context, edit : EditText){
        val keyboard = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        keyboard.showSoftInput( edit , 0)
    }

    // val success = context.getString(R.color.black)

    fun getColoredText(text : String, color : String ): String {
        val sb = StringBuilder()
        val cl1 = "#" + color.substring(3, color.length  )
        sb.append(" <font color='${cl1}'> ${text}</font>  ")
        return sb.toString()
    }




}