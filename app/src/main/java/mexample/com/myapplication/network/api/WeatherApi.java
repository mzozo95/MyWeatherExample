package mexample.com.myapplication.network.api;

import io.reactivex.Observable;
import mexample.com.myapplication.network.util.NetworkConfig;
import mexample.com.myapplication.network.model.CurrentWeather;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface WeatherApi {
    String ENDPOINT_URL = NetworkConfig.WEATHER_URL;
    String appid = "USE_YOUR_KEY_HERE"; //https://openweathermap.org/api
    String units = "metric";

    @POST("/data/2.5/weather")
    Observable<CurrentWeather> getCurrentWeather(@Query("appid") String APP_ID,
                                                 @Query("units") String unit,
                                                 @Query("q") String city);
}
