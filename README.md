# Weather Forecast Application (.NET)

This is a .NET weather forecast application that color-codes regions based on temperature.

## Color Coding Rules

- **Blue** (`#1E88E5`) for `<= 10°C`
- **Green** (`#43A047`) for `11-20°C`
- **Orange** (`#FB8C00`) for `21-30°C`
- **Red** (`#E53935`) for `> 30°C`

Example requested: **New Delhi at 8°C appears Blue**.

## Run locally

```bash
dotnet restore
dotnet run
```

Then open `http://localhost:5000` (or the port shown in terminal).
