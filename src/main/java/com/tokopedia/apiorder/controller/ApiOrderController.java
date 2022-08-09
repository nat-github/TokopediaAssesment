package com.tokopedia.apiorder.controller;

import com.tokopedia.apiorder.model.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping
public class ApiOrderController {
    @PostMapping(value = "/api/processOrder",consumes = "application/json",produces = "application/json")
    public Order processOrder(@RequestBody Order order){
        order.setOrder_status("Processed");
        order.setLast_updated_timestamp(Instant.now().toEpochMilli());
        return order;
    }
}
