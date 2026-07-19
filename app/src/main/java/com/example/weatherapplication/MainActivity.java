package com.example.weatherapplication;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class MainActivity extends Activity {
    private TextView cityName;
    private TextView temperature;
    private TextView condition;
    private TextView details;
    private EditText searchInput;

    private final Map<String, WeatherReport> sampleWeather = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        seedWeatherData();
        setContentView(buildContentView());
        showWeather("New York");
    }

    private ScrollView buildContentView() {
        ScrollView scrollView = new ScrollView(this);
        scrollView.setBackgroundColor(Color.rgb(227, 242, 253));

        LinearLayout container = new LinearLayout(this);
        container.setOrientation(LinearLayout.VERTICAL);
        container.setPadding(48, 64, 48, 48);
        scrollView.addView(container);

        TextView title = new TextView(this);
        title.setText("Weather Application");
        title.setTextColor(Color.rgb(16, 42, 67));
        title.setTextSize(30);
        title.setTypeface(Typeface.DEFAULT_BOLD);
        title.setGravity(Gravity.CENTER);
        container.addView(title, fullWidthLayout());

        searchInput = new EditText(this);
        searchInput.setHint("Enter city name");
        searchInput.setSingleLine(true);
        searchInput.setImeOptions(EditorInfo.IME_ACTION_SEARCH);
        searchInput.setText("New York");
        container.addView(searchInput, spacedLayout());

        Button searchButton = new Button(this);
        searchButton.setText("Get Weather");
        searchButton.setOnClickListener(view -> showWeather(searchInput.getText().toString()));
        container.addView(searchButton, fullWidthLayout());

        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setGravity(Gravity.CENTER);
        card.setPadding(36, 48, 36, 48);
        card.setBackgroundColor(Color.WHITE);
        container.addView(card, cardLayout());

        cityName = cardText(26, true);
        temperature = cardText(54, true);
        condition = cardText(22, false);
        details = cardText(17, false);

        card.addView(cityName, fullWidthLayout());
        card.addView(temperature, fullWidthLayout());
        card.addView(condition, fullWidthLayout());
        card.addView(details, fullWidthLayout());

        TextView help = new TextView(this);
        help.setText("Try New York, London, Tokyo, Sydney, or Mumbai. Unknown cities show a default forecast so the app works offline.");
        help.setTextColor(Color.rgb(72, 101, 129));
        help.setGravity(Gravity.CENTER);
        help.setTextSize(15);
        container.addView(help, spacedLayout());

        return scrollView;
    }

    private TextView cardText(int size, boolean bold) {
        TextView textView = new TextView(this);
        textView.setTextColor(Color.rgb(16, 42, 67));
        textView.setTextSize(size);
        textView.setGravity(Gravity.CENTER);
        if (bold) {
            textView.setTypeface(Typeface.DEFAULT_BOLD);
        }
        return textView;
    }

    private void showWeather(String rawCity) {
        String city = rawCity.trim().isEmpty() ? "New York" : rawCity.trim();
        WeatherReport report = sampleWeather.getOrDefault(
                city.toLowerCase(Locale.US),
                new WeatherReport(city, "24°C", "Partly cloudy", "Humidity 58% • Wind 12 km/h")
        );

        cityName.setText(report.city);
        temperature.setText(report.temperature);
        condition.setText(report.condition);
        details.setText(report.details);
    }

    private void seedWeatherData() {
        addWeather("New York", "22°C", "Sunny", "Humidity 45% • Wind 10 km/h");
        addWeather("London", "16°C", "Light rain", "Humidity 72% • Wind 18 km/h");
        addWeather("Tokyo", "28°C", "Cloudy", "Humidity 64% • Wind 9 km/h");
        addWeather("Sydney", "19°C", "Clear", "Humidity 51% • Wind 14 km/h");
        addWeather("Mumbai", "30°C", "Humid", "Humidity 80% • Wind 11 km/h");
    }

    private void addWeather(String city, String temp, String summary, String detail) {
        sampleWeather.put(city.toLowerCase(Locale.US), new WeatherReport(city, temp, summary, detail));
    }

    private LinearLayout.LayoutParams fullWidthLayout() {
        return new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
    }

    private LinearLayout.LayoutParams spacedLayout() {
        LinearLayout.LayoutParams params = fullWidthLayout();
        params.setMargins(0, 32, 0, 0);
        return params;
    }

    private LinearLayout.LayoutParams cardLayout() {
        LinearLayout.LayoutParams params = fullWidthLayout();
        params.setMargins(0, 40, 0, 0);
        return params;
    }

    private static class WeatherReport {
        private final String city;
        private final String temperature;
        private final String condition;
        private final String details;

        private WeatherReport(String city, String temperature, String condition, String details) {
            this.city = city;
            this.temperature = temperature;
            this.condition = condition;
            this.details = details;
        }
    }
}
