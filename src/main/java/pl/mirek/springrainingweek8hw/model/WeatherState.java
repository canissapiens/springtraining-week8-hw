package pl.mirek.springrainingweek8hw.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "entities")
public class WeatherState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Long id;

    @Column(name = "time")
    private Date time;

    @Column(name = "temperature")
    private Double temperature;

    @Column(name = "summary")
    private String summary;

    @Column(name = "windspeed")
    private Double windSpeed;

    public WeatherState() {
    }

    public WeatherState(Long time, Double temperature, String summary, Double windSpeed) {
        this.time = linuxTimeStampToDate(time);
        this.temperature = temperature;
        this.summary = summary;
        this.windSpeed = windSpeed;
    }

    public Long getId() {
        return id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = linuxTimeStampToDate(time);
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    private Date linuxTimeStampToDate(Long timestamp) {
        long input = timestamp.longValue() * 1000;
        return new Date(input);
    }

    @Override
    public String toString() {
        return "\nWeatherState{" +
                "id=" + id +
                ", time=" + time +
                ", temperature=" + temperature +
                ", summary='" + summary + '\'' +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
