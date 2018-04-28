package com.hyf.frame.androidframe.dagger;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class ApplicationModule {
    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);
}
