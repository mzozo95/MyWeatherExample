package mexample.com.myapplication.network.util;

import mexample.com.myapplication.network.model.CurrentWeather;

public class NetworkUtil {
    public static String getWeatherIconUrl(CurrentWeather currentWeather){
        String imgUrl = "";
        if (currentWeather.getWeather().size()>0){
            imgUrl = "http://openweathermap.org/img/w/"+currentWeather.getWeather().get(0).getIcon()+".png";
        }
        return imgUrl;
    }
}
