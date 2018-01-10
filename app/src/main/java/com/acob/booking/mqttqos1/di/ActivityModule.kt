package com.acob.booking.mqttqos1.di

import android.app.Activity

import com.acob.booking.mqttqos1.MainActivity
import com.acob.booking.mqttqos1.MqttMainActivity
import dagger.Module

import dagger.android.ContributesAndroidInjector



/**
 * Created by wugang00 on 13/12/2017.
 */
@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    internal abstract fun contributeMainActivity(): MainActivity

    @ContributesAndroidInjector
    internal abstract fun contributeMqttMainActivity(): MqttMainActivity
}

