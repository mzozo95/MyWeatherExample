package mexample.com.myapplication.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import mexample.com.myapplication.R;
import mexample.com.myapplication.network.model.CurrentWeather;
import mexample.com.myapplication.network.util.NetworkUtil;

import static mexample.com.myapplication.MyWeatherApplication.injector;

public class MainActivity extends AppCompatActivity implements MainScreen {
	@BindView(R.id.tvMain)
	TextView tvMain;
	@BindView(R.id.ivIcon)
	ImageView ivIcon;

	@Inject
	MainPresenter presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ButterKnife.bind(this);
		injector.inject(this);

		tvMain.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				presenter.getWeather("Budapest");
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		presenter.attachScreen(this);
		presenter.getWeather("Budapest");
	}

	@Override
	protected void onStop() {
		presenter.detachScreen();
		super.onStop();
	}

	@Override
	public void showWeather(CurrentWeather currentWeather) {
		//Todo removeLoading
		tvMain.setText(String.format("%s\n%s", currentWeather.getCityName(), currentWeather.getMainInformation().getTemperature()));
		Glide.with(this).load(NetworkUtil.generateWeatherIconUrl(currentWeather)).into(ivIcon);
		Toast.makeText(this, R.string.data_refreshed, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void showError(String errorMsg) {
		//Todo show ErrorDialog
		tvMain.setText(errorMsg);
		Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
	}
}
