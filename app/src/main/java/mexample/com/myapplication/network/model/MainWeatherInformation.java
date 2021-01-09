package mexample.com.myapplication.network.model;

import com.google.gson.annotations.SerializedName;

public class MainWeatherInformation {
    @SerializedName("temp")
    private double temperature;
    private double humidity;
    private double pressure;
    @SerializedName("temp_min")
    private double tempMinInCity; //doc: https://openweathermap.org/current
    @SerializedName("temp_max")
    private double tempMaxInCity;

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getPressure() {
        return pressure;
    }

    public double getTempMinInCity() {
        return tempMinInCity;
    }

    public double getTempMaxInCity() {
        return tempMaxInCity;
    }
}
