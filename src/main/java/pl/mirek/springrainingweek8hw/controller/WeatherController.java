package pl.mirek.springrainingweek8hw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;
import pl.mirek.springrainingweek8hw.model.WeatherState;
import pl.mirek.springrainingweek8hw.model.WeatherStateRepo;
import pl.mirek.springrainingweek8hw.model.forecast.Forecast;

import java.math.BigDecimal;

@Controller
public class WeatherController {

    private WeatherStateRepo weatherStateRepo;

    @Autowired
    public WeatherController(WeatherStateRepo weatherStateRepo) {
        this.weatherStateRepo = weatherStateRepo;
    }

    @Scheduled(initialDelay = 1800000L, fixedDelay = 3600000L)
    public void getCurrentForecast() {
        Forecast forecast = getForecast();
        WeatherState weatherState = new WeatherState();
        weatherState.setSummary(forecast.getCurrently().getSummary());
        weatherState.setTemperature(convertTempFromFahrenheitToCelsius(forecast.getCurrently().getTemperature()));
        weatherState.setTime(forecast.getCurrently().getTime().longValue());
        weatherState.setWindSpeed(convertMilesPerHourToMetersPerSecond(forecast.getCurrently().getWindSpeed()));
        weatherStateRepo.save(weatherState);
    }

    private Forecast getForecast() {
        RestTemplate restTemplate = new RestTemplate();
        String url;
        url = "https://api.darksky.net/forecast/0b0f516376e6a5c6a49dbe88d6d6f7b8/50.06143,19.93658?lang=pl";
        return restTemplate.getForObject(
                url,
                Forecast.class);
    }

    private Double convertTempFromFahrenheitToCelsius(Double f) {
        BigDecimal fahrenheit = new BigDecimal(f);
        BigDecimal celsius = fahrenheit.subtract(new BigDecimal(32)).multiply(new BigDecimal(5)).divide(new BigDecimal(9), 4);
        celsius = celsius.setScale(1, BigDecimal.ROUND_HALF_UP);
        return Double.valueOf(celsius.toString());
    }

    private Double convertMilesPerHourToMetersPerSecond(Double speed) {
        Double speedInMeters = speed * 1609.344D;
        Double finalSpeed = speedInMeters / 3600.0D;
        BigDecimal output = BigDecimal.valueOf(finalSpeed);
        output = output.setScale(1, BigDecimal.ROUND_HALF_UP);
        return Double.valueOf(output.toString());
    }


}
