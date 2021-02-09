package com.example.condortest.di;

import android.app.Application;

import com.example.condortest.di.component.AplicationComponent;
import com.example.condortest.di.component.DaggerAplicationComponent;
import com.example.condortest.di.modules.AplicationModule;

public class BaseApplication extends Application {

    private AplicationComponent aplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        aplicationComponent = DaggerAplicationComponent
                .builder()
                .aplicationModule(new AplicationModule())
                .build();
    }

    public AplicationComponent getAplicationComponent(){
        return aplicationComponent;
    }
}
