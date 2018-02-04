package mexample.com.myapplication.ui;

import android.content.Context;

import java.util.concurrent.Executors;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import mexample.com.myapplication.di.Network;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    @Network
    public Scheduler provideNetworkScheduler() {
        return Schedulers.from(Executors.newFixedThreadPool(1));
    }
}
