
package com.twitterAPI.payloads.entities_;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.twitterAPI.payloads.entities_.description.Url___;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "urls"
})
public class Description {

    @JsonProperty("urls")
    private List<Url___> urls = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("urls")
    public List<Url___> getUrls() {
        return urls;
    }

    @JsonProperty("urls")
    public void setUrls(List<Url___> urls) {
        this.urls = urls;
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
