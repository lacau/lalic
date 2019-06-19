package com.lalic.mananger.external.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductResponse {

    @JsonProperty("id")
    private String xTechId;

    @JsonProperty("sku")
    private String reference;

    @JsonProperty("name")
    private String name;
}
