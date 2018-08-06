package taxi.nicecode.com.base

import android.app.Activity
import android.support.v4.app.Fragment
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.text.Html
import android.text.InputFilter
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.realm.Realm
import io.realm.RealmObject
import io.realm.RealmResults
import taxi.nicecode.com.base.kit.core.LogWrapper
import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Kenza on 12.04.2018.
 */


fun Any.d(msg: String, e: Exception? = null) {
    return LogWrapper.debug(msg, e)
}

fun Any.e(msg: String, e: Exception? = null) {
    return LogWrapper.error(msg, e)
}

fun Any.w(msg: String, e: Exception? = null) {
    return LogWrapper.warring(msg, e)
}

fun Any.w(e: Exception) {
    return LogWrapper.warring("", e)
}

fun Any.w(e: Throwable) {
    return LogWrapper.warring("", Exception(e))
}



fun Any.i(msg: String, e: Exception? = null) {
    return LogWrapper.info(msg, e)
}


fun Any.showToast(context: Context, msg: String) {
    Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
}


fun Fragment.showToast(msg: String) {
    Toast.makeText(this.activity, msg, Toast.LENGTH_SHORT).show()
}


fun Context.showToast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun String.parseToDouble(): Double {
    var d = 0.0

    try {
        d = toString().toDouble()
    } catch (e: Exception) {
    }

    return d
}


fun String.deleteQuotes(): String {

    var x = this.replace(")", "")
    x = x.replace("(", "")
    return x

}


fun Any.json(): String? {
    return Gson().toJson(this)
}

//fun <T : RealmObject> String.toRObject(clazz: Class<T>): T? {
//    return GsonWrapper.fromJson(this, clazz)
//}


fun <T> String.toObject(clazz: Class<T>): T? {
    return Gson().fromJson(this, clazz)
}


fun <T> Observable<T>.oneClick(): Observable<T> {
    return this.throttleFirst(1000, java.util.concurrent.TimeUnit.MILLISECONDS)
}


fun <T> Context.showActivity(clazz: Class<T>) {
    val intent = Intent(this, clazz)
    this.startActivity(intent)

}


fun EditText.setCharLimit(limit: Int) {
    val maxLength = limit
    this.filters = arrayOf<InputFilter>(InputFilter.LengthFilter(maxLength))
}

fun DialogFragment.show(activity: AppCompatActivity, tag: String? = null): DialogFragment {
    if (tag == null) {
        this.show(activity.supportFragmentManager, "${this.toString()}_${System.currentTimeMillis()}")
    } else {
        this.show(activity.supportFragmentManager, "${tag}")
    }
    return this
}


fun AppCompatActivity.dismissDialog(tag: String) {
    val x = this.supportFragmentManager.findFragmentByTag(tag)
    (x as? DialogFragment)?.dismiss()
}

fun Activity.clearIntent() {
    intent.replaceExtras(Bundle())
    intent.action = ""
    intent.data = null
    intent.flags = 0
}

fun Context.toActivity(): AppCompatActivity {
    return (this as AppCompatActivity)
}

fun Char.parseInt(): Int {
    return Integer.parseInt(this.toString())

}

fun String.toUpperCaseOnce(): String {
    try {
        return Character.toUpperCase(this[0]) + this.substring(1).toLowerCase()
    } catch (e: Exception) {
        return ""
    }
}

fun <T> Observable<T>.onNet(): Observable<T> {
    return this.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

}

fun Int.getColor(context: Context): Int {
    return ContextCompat.getColor(context, this)
}

fun <E : RealmObject> RealmResults<E>.copyFromRealm(realm: Realm): MutableList<E> {
    return realm.copyFromRealm(this)
}

fun <T : RealmObject> T.copyFromRealm(realm: Realm): T {
    return realm.copyFromRealm(this)
}


fun <E> List<E>.random(random: java.util.Random = Random()): E? = if (size > 0) get(random.nextInt(size)) else null

fun RecyclerView.notifyDataSetChanged() {
    this.adapter?.notifyDataSetChanged()
}





fun View.vis() {
    this.visibility = View.VISIBLE
}


fun View.invis() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}


fun View.setHeight(h : Int ) {

    var h = h


    if(h  == 0 || h == -1 || h == 1 ){

    }else {
       h =  Help.getPixelsByDp(h)
    }


    var lp= this.layoutParams
    if(lp is  ConstraintLayout.LayoutParams){
        lp.height = h
    }
//    lp.height = ConstraintLayout.LayoutParams.MATCH_PARENT
    this.layoutParams = lp
}



fun <E>List<E>?.toArrayList(): ArrayList<E> {
    return  ArrayList(this)
}


fun TextView.setColoredText(colored : String){

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        this.setText(Html.fromHtml(colored, Html.FROM_HTML_MODE_COMPACT), TextView.BufferType.NORMAL)
    } else {
        this.setText(Html.fromHtml(colored), TextView.BufferType.NORMAL)
    }

}


fun TextView.setColoredText(text : String, color : String){
    val colored = Help.getColoredText(text, color)
    this.setColoredText(colored)
}


