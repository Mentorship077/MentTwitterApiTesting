
package com.twitterAPI.payloads.tweets.extendedEntities.medium;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.twitterAPI.payloads.tweets.extendedEntities.medium.videoInfo.Variant;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "aspect_ratio",
    "duration_millis",
    "variants"
})
public class VideoInfo {

    @JsonProperty("aspect_ratio")
    private List<Integer> aspectRatio = null;
    @JsonProperty("duration_millis")
    private Integer durationMillis;
    @JsonProperty("variants")
    private List<Variant> variants = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("aspect_ratio")
    public List<Integer> getAspectRatio() {
        return aspectRatio;
    }

    @JsonProperty("aspect_ratio")
    public void setAspectRatio(List<Integer> aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    @JsonProperty("duration_millis")
    public Integer getDurationMillis() {
        return durationMillis;
    }

    @JsonProperty("duration_millis")
    public void setDurationMillis(Integer durationMillis) {
        this.durationMillis = durationMillis;
    }

    @JsonProperty("variants")
    public List<Variant> getVariants() {
        return variants;
    }

    @JsonProperty("variants")
    public void setVariants(List<Variant> variants) {
        this.variants = variants;
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
