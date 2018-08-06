package taxi.nicecode.com.ftreg

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import kotlinx.android.synthetic.main.act_reg.*
import taxi.nicecode.com.base.BaseActivity
import taxi.nicecode.com.base.IAppNavigator
import taxi.nicecode.com.base.d

class RegActivity: BaseActivity() {


    private lateinit var vm: RegVm

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_reg)
        vm = ViewModelProviders.of(this)[RegVm::class.java]




        bt_reg.setOnClickListener {

            d("xc")
            (application as IAppNavigator).openMap()
        }



        //HideSoftKeyboard.softHide(root, this)

    }

}