package mexample.com.myapplication.network.interactor;

import javax.inject.Inject;

import io.reactivex.Observable;
import mexample.com.myapplication.network.api.WeatherApi;
import mexample.com.myapplication.network.model.CurrentWeather;

import static mexample.com.myapplication.MyWeatherApplication.injector;

public class WeatherInteractor {
    @Inject
    WeatherApi weatherApi;

    @Inject
    public WeatherInteractor() {
        injector.inject(this);
    }

    public Observable<CurrentWeather> getWeather(String city){
        return weatherApi.getCurrentWeather(WeatherApi.API_KEY, WeatherApi.UNITS, city);
    }
}
