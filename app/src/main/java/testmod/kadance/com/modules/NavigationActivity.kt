package testmod.kadance.com.modules

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import taxi.nicecode.com.base.d
import taxi.nicecode.com.ftmap.MapActivity
import taxi.nicecode.com.ftmap.generated.package_0.Foo0

/**
 * Created by Kenza on 05.08.2018.
 */
class NavigationActivity : AppCompatActivity() {

    init {
        d("x2")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        showActivity(MapActivity::class.java)


        val x = Foo0().foo5()


    }

}