package mexample.com.myapplication;

import android.support.multidex.MultiDexApplication;

import com.facebook.stetho.Stetho;

import mexample.com.myapplication.network.NetworkModule;
import mexample.com.myapplication.ui.UIModule;

public class MyWeatherApplication  extends MultiDexApplication {
    public static AppComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);

        injector = DaggerAppComponent.builder().uIModule(new UIModule(this)).networkModule(new NetworkModule(this)).build();
    }
}
