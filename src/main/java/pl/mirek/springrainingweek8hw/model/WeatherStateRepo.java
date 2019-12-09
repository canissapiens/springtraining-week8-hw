package pl.mirek.springrainingweek8hw.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherStateRepo extends JpaRepository<WeatherState, Long> {
}
