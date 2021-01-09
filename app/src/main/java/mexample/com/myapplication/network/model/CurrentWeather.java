package mexample.com.myapplication.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeather {
	@SerializedName("coord")
	private Coordinates coordinates;
	@SerializedName("weather")
	private List<WeatherCondition> weatherConditions;
	@SerializedName("main")
	private MainWeatherInformation mainInformation;
	private Wind wind;
	@SerializedName("name")
	private String cityName;

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public List<WeatherCondition> getWeather() {
		return weatherConditions;
	}

	public MainWeatherInformation getMainInformation() {
		return mainInformation;
	}

	public Wind getWind() {
		return wind;
	}

	public String getCityName() {
		return cityName;
	}
}
