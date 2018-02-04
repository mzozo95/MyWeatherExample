package mexample.com.myapplication;

import javax.inject.Singleton;

import dagger.Component;
import mexample.com.myapplication.network.NetworkModule;
import mexample.com.myapplication.network.interactor.WeatherInteractor;
import mexample.com.myapplication.ui.UIModule;
import mexample.com.myapplication.ui.main.MainActivity;
import mexample.com.myapplication.ui.main.MainPresenter;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainPresenter mainPresenter);

    void inject(MainActivity mainActivity);

    void inject(WeatherInteractor weatherInteractor);
}
