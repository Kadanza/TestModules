package taxi.nicecode.com.ftmap

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import taxi.nicecode.com.base.BaseActivity
import taxi.nicecode.com.base.IAppNavigator
import taxi.nicecode.com.base.d
import taxi.nicecode.com.ftmap.generated.package_0.Foo149

class MapActivity : BaseActivity() {


    private lateinit var vm: MapVm
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_map)
        vm = ViewModelProviders.of(this, modelFactory)[MapVm::class.java]


        bt_map.setOnClickListener {
            (application as IAppNavigator).openReg()
            Foo149().foo4()


            val x = Foo149().foo3()

            if(x != null){
                Foo149().foo3()
            }
            d("")

        }


        bt_map.text = "map2 " + vm.from

        //HideSoftKeyboard.softHide(root, this)

    }

}