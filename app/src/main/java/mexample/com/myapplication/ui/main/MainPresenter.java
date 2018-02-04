package mexample.com.myapplication.ui.main;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import mexample.com.myapplication.R;
import mexample.com.myapplication.network.api.WeatherApi;
import mexample.com.myapplication.di.Network;
import mexample.com.myapplication.network.interactor.WeatherInteractor;
import mexample.com.myapplication.network.model.CurrentWeather;
import mexample.com.myapplication.ui.RxPresenter;

import static mexample.com.myapplication.MyWeatherApplication.injector;


public class MainPresenter extends RxPresenter<MainScreen> {
    @Inject
    Context context;

    @Inject
    WeatherInteractor weatherInteractor;

    @Inject
    Gson gson;

    @Inject
    @Network
    Scheduler networkScheduler;

    @Inject
    public MainPresenter() {injector.inject(this);}

    public void getWeather(String city) {
        attachSubscription(weatherInteractor.getWeather(city)
                .subscribeOn(networkScheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrentWeather>() {
                    @Override
                    public void accept(CurrentWeather currentWeather) throws Exception {
                        Log.d("down",""+ currentWeather.getMain().getTemp());
                        if (screen!=null){
                            screen.showWeather(currentWeather);
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        throwable.printStackTrace();
                        if (screen!=null){
                            screen.showError(context.getString(R.string.network_error));
                        }
                    }
                }));
    }
}
