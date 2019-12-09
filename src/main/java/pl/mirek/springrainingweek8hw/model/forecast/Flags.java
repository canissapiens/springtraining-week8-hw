package pl.mirek.springrainingweek8hw.model.forecast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "sources",
        "nearest-station",
        "units"
})
public class Flags {

    @JsonProperty("sources")
    private List<String> sources = null;
    @JsonProperty("nearest-station")
    private Double nearestStation;
    @JsonProperty("units")
    private String units;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<>();

    /**
     * No args constructor for use in serialization
     *
     */
    public Flags() {
    }

    /**
     *
     * @param sources
     * @param units
     * @param nearestStation
     */
    public Flags(List<String> sources, Double nearestStation, String units) {
        super();
        this.sources = sources;
        this.nearestStation = nearestStation;
        this.units = units;
    }

    @JsonProperty("sources")
    public List<String> getSources() {
        return sources;
    }

    @JsonProperty("sources")
    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    @JsonProperty("nearest-station")
    public Double getNearestStation() {
        return nearestStation;
    }

    @JsonProperty("nearest-station")
    public void setNearestStation(Double nearestStation) {
        this.nearestStation = nearestStation;
    }

    @JsonProperty("units")
    public String getUnits() {
        return units;
    }

    @JsonProperty("units")
    public void setUnits(String units) {
        this.units = units;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return "\nFlags{" +
                "sources=" + sources +
                ", nearestStation=" + nearestStation +
                ", units='" + units + '\'' +
                ", additionalProperties=" + additionalProperties +
                '}';
    }
}
