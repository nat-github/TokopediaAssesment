package com.tokopedia.apiorder.model;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class Order {
    private long order_id;
    private String order_description;
    private String order_status;
    private long last_updated_timestamp;
    private Boolean special_order;

    public Order(long order_id,String order_description,String order_status,
                 long last_updated_timestamp,Boolean special_order)
    {
        this.order_id = order_id;
        this.order_description = order_description;
        this.order_status = order_status;
        this.last_updated_timestamp = last_updated_timestamp;
        this.special_order = special_order;
    }
}