package mexample.com.myapplication.ui.main;

import android.content.Context;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import mexample.com.myapplication.R;
import mexample.com.myapplication.network.interactor.WeatherInteractor;
import mexample.com.myapplication.network.model.CurrentWeather;
import mexample.com.myapplication.ui.RxPresenter;


public class MainPresenter extends RxPresenter<MainScreen> {
    private final Context context;
    private final WeatherInteractor weatherInteractor;

    @Inject
    public MainPresenter(WeatherInteractor weatherInteractor, Context context) {
        this.context = context;
        this.weatherInteractor = weatherInteractor;
    }

    public void getWeather(String city) {
        attachSubscription(weatherInteractor.getWeather(city)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CurrentWeather>() {
                    @Override
                    public void accept(CurrentWeather currentWeather) {
                        screen.showWeather(currentWeather);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        throwable.printStackTrace();
                        screen.showError(context.getString(R.string.network_error));
                    }
                }));
    }
}
