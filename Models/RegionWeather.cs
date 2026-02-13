namespace WeatherForecastApplication.Models;

public sealed record RegionWeather(string Region, int TemperatureC)
{
    public string ColorCode { get; init; } = "#9E9E9E";
}
