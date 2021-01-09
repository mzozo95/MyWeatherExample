package mexample.com.myapplication.ui.main;

import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import mexample.com.myapplication.R;
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
	public MainPresenter() {
		injector.inject(this);
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
