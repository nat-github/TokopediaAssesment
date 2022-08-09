package com.tokopedia.apiorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderRequest {
    @JsonProperty("order_id")
    private long order_id;
    @JsonProperty("order_description")
    private String order_description;
    @JsonProperty("order_status")
    private String order_status;
    @JsonProperty("last_updated_timestamp")
    private long last_updated_timestamp;
    @JsonProperty("special_order")
    private Boolean special_order;
}
