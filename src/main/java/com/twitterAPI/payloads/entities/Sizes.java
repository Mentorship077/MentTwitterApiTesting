
package com.twitterAPI.payloads.entities;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.twitterAPI.payloads.entities.sizes.Large;
import com.twitterAPI.payloads.entities.sizes.Medium_;
import com.twitterAPI.payloads.entities.sizes.Small;
import com.twitterAPI.payloads.entities.sizes.Thumb;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "thumb",
    "small",
    "medium",
    "large"
})
public class Sizes {

    @JsonProperty("thumb")
    private Thumb thumb;
    @JsonProperty("small")
    private Small small;
    @JsonProperty("medium")
    private Medium_ medium;
    @JsonProperty("large")
    private Large large;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("thumb")
    public Thumb getThumb() {
        return thumb;
    }

    @JsonProperty("thumb")
    public void setThumb(Thumb thumb) {
        this.thumb = thumb;
    }

    @JsonProperty("small")
    public Small getSmall() {
        return small;
    }

    @JsonProperty("small")
    public void setSmall(Small small) {
        this.small = small;
    }

    @JsonProperty("medium")
    public Medium_ getMedium() {
        return medium;
    }

    @JsonProperty("medium")
    public void setMedium(Medium_ medium) {
        this.medium = medium;
    }

    @JsonProperty("large")
    public Large getLarge() {
        return large;
    }

    @JsonProperty("large")
    public void setLarge(Large large) {
        this.large = large;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
