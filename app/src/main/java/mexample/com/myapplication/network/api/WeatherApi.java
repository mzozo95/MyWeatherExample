package mexample.com.myapplication.network.api;

import io.reactivex.Observable;
import mexample.com.myapplication.BuildConfig;
import mexample.com.myapplication.network.model.CurrentWeather;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WeatherApi {
	String BASE_URL = "http://api.openweathermap.org";
	String API_KEY = BuildConfig.API_KEY; //Request one here: https://openweathermap.org/api
	String UNITS = "metric";

	@POST("/data/2.5/weather")
	Observable<CurrentWeather> getCurrentWeather(@Query("appid") String apiKey,
												 @Query("units") String unit,
												 @Query("q") String city);
}
