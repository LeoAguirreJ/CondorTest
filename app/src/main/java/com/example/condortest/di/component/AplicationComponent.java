package com.example.condortest.di.component;

import com.example.condortest.di.modules.AplicationModule;
import com.example.condortest.ui.activities.detail.DetailActivity;
import com.example.condortest.ui.activities.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AplicationModule.class)
public interface AplicationComponent {
    void inject(MainActivity mainActivity);
    void inject(DetailActivity detailActivity);
}
