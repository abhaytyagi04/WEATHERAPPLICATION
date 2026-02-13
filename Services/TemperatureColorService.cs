namespace WeatherForecastApplication.Services;

public static class TemperatureColorService
{
    public static string GetColorForTemperature(int temperatureC) => temperatureC switch
    {
        <= 10 => "#1E88E5",  // Cool (Blue)
        <= 20 => "#43A047",  // Mild (Green)
        <= 30 => "#FB8C00",  // Warm (Orange)
        _ => "#E53935"       // Hot (Red)
    };
}
