package testmod.kadance.com.modules

import android.arch.core.executor.testing.InstantTaskExecutorRule
import android.support.test.InstrumentationRegistry
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import testmod.kadance.com.modules.di.DaggerAppComponent
import android.support.test.rule.ActivityTestRule;
import taxi.nicecode.com.base.showActivity
import taxi.nicecode.com.ftmap.MapActivity
import testmod.kadance.com.modules.module.DaggerFAppComponent
import testmod.kadance.com.modules.module.FAppModule

/**
 * Created by Kenza on 15.06.2018.
 */

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainUi {

    private lateinit var app: TestApp

    @Rule
    @JvmField
    var mActivityRule = object : ActivityTestRule<NavigationActivity>(NavigationActivity::class.java) {
        override fun beforeActivityLaunched() {

            app = (InstrumentationRegistry.getInstrumentation().targetContext.applicationContext as TestApp)
            val module = FAppModule(app)

            val appComponent = DaggerFAppComponent.builder().appModule(module).build()!!
            app.setComponent(appComponent)
            super.beforeActivityLaunched()


        }
    }


    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()


    @Before
    fun before() {

    }


    @Test
    fun mainOpen() {
        Thread.sleep(1200)
       // mActivityRule.activity.showActivity(MapActivity::class.java)
    }


    @After
    fun after() {
        Thread.sleep(600000)
    }
}