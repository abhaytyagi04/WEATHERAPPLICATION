using WeatherForecastApplication.Models;
using WeatherForecastApplication.Services;

var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

app.UseDefaultFiles();
app.UseStaticFiles();

app.MapGet("/api/regions", () =>
{
    var regions = new[]
    {
        new RegionWeather("New Delhi", 8),
        new RegionWeather("Mumbai", 32),
        new RegionWeather("Bengaluru", 22),
        new RegionWeather("Kolkata", 28),
        new RegionWeather("Shimla", 6),
        new RegionWeather("Chennai", 35)
    };

    var response = regions
        .Select(region => region with
        {
            ColorCode = TemperatureColorService.GetColorForTemperature(region.TemperatureC)
        });

    return Results.Ok(response);
});

app.Run();
