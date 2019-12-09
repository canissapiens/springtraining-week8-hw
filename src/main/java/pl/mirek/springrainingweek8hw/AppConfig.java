package pl.mirek.springrainingweek8hw;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import pl.mirek.springrainingweek8hw.model.WeatherState;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Configuration
@EnableScheduling
public class AppConfig {





/*    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        System.out.println(getForecast().toString());
        WeatherState weahterState = new WeatherState();
    }*/
}
