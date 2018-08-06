package taxi.nicecode.com.base.kit.core

import android.view.View

/**
 * Created by Kenza on 01.07.2018.
 */

object Rx {
    fun click(view: View, act : ((it: Unit) -> Unit)) {
        view.setOnClickListener {
            act.invoke(Unit)
        }
    }
}