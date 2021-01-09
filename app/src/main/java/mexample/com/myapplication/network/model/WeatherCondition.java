package mexample.com.myapplication.network.model;

public class WeatherCondition {
	private int id;
	private String main;//"Group of weather parameters (Rain, Snow, Extreme etc.)" src: https://openweathermap.org/current
	private String description;
	private String icon;

	public int getId() {
		return id;
	}

	public String getMain() {
		return main;
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}
}
