package testmod.kadance.com.modules

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.InstrumentationRegistry
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule;
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