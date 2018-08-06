package testmod.kadance.com.modules.module

import android.content.Context
import testmod.kadance.com.modules.di.module.AppModule

/**
 * Created by Kenza on 16.04.2018.
 */


open class  FAppModule(override val context: Context) : AppModule(context){

//    override fun pointsLD(repo: IDataRepo): PointsLD { return FakePointsLD(repo) }


}