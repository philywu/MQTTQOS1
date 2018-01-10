package com.acob.booking.mqttqos1.di


import com.acob.booking.mqttqos1.MyApplication
import com.acob.booking.mqttqos1.di.ActivityModule
import dagger.Component
import javax.inject.Singleton




/**
 * Created by wugang00 on 5/12/2017.
 */
@Singleton
@Component(modules =arrayOf ( AppModule::class,
                                ActivityModule::class ))
interface AppComponent  {

    fun inject(application: MyApplication)

    //fun inject(mqttCallback : MqttCallbackBus)

   // fun localStorage(): LocalStorage
}