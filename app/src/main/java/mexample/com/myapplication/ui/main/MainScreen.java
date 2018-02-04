package mexample.com.myapplication.ui.main;

import mexample.com.myapplication.network.model.CurrentWeather;

public interface MainScreen {
    void showWeather(CurrentWeather currentWeather);

    void showError(String errorMsg);
}
