package com.tokopedia.apiorder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class OrderResponse {
    @JsonProperty("order_status")
    private String order_status;
    @JsonProperty("last_updated_timestamp")
    private Object last_updated_timestamp;
}
