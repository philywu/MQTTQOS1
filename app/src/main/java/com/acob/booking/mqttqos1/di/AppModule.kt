package com.acob.booking.mqttqos1.di

import android.app.Application
import android.content.Context
import com.acob.booking.mqttqos1.data.LocalStorage
import com.acob.booking.mqttqos1.data.SharedPrefStorage
import com.acob.booking.mqttqos1.message.MessageProcessor
import com.acob.booking.mqttqos1.message.MqttManager
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder

import dagger.Module
import dagger.Provides

import javax.inject.Singleton



/**
 * Created by wugang00 on 13/12/2017.
 */
@Module
class AppModule(private val context: Context) {

    var mApplication: Application? = null



    @Provides
    fun providesAppContext() = context

    fun AppModule(application: Application) {
        mApplication = application

/*        var db = providesAppDatabase(context)
        eventDao = db.obEventDao()
        registerDao = db.obRegisterDao()*/
    }

    @Provides
    @Singleton
    fun providesApplication(): Application? {
        return mApplication
    }


    @Provides
    @Singleton
    fun providesMessageProcessor(
            gson : Gson,
            localStorage: LocalStorage,
            mqttManager: MqttManager
    ) = MessageProcessor(context,gson,localStorage,mqttManager)

    @Provides
    fun providesMqttManager() = MqttManager()


    @Provides
    @Singleton
    fun provideGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setDateFormat("yyyyMMddHHmmss")
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    fun provideLocalStorage(): LocalStorage {
        return SharedPrefStorage(context);
    }


}