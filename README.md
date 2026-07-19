# Weather Application for Android

A simple native Android weather application scaffolded with Java and the Android Gradle Plugin. The app provides an offline weather lookup experience with sample forecasts for popular cities and a default forecast for any other location.

## Features

- Native Android Activity implemented in Java.
- Search field for entering a city name.
- Weather summary card with city, temperature, condition, humidity, and wind details.
- Offline sample data so the app can run without an API key.

## Project Structure

```text
app/
  src/main/AndroidManifest.xml
  src/main/java/com/example/weatherapplication/MainActivity.java
  src/main/res/
```

## Build

Use Gradle with an Android SDK installed:

```bash
gradle :app:assembleDebug
```

The debug APK will be generated under `app/build/outputs/apk/debug/`.
