package bek.dev.appsalessystem.controller;

import bek.dev.appsalessystem.entity.Order;
import bek.dev.appsalessystem.entity.enums.Status;
import bek.dev.appsalessystem.payload.OrderDetailsDto;
import bek.dev.appsalessystem.payload.Result;
import bek.dev.appsalessystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;


    @PostMapping
    public HttpEntity<Result> makeOrder(@Valid @RequestBody OrderDetailsDto orderDetailsDto){
        Result result=orderService.makeOrder(orderDetailsDto);
        return ResponseEntity.status(result.getMessage().equals(Status.SUCCESS)?200:409).body(result);
    }


    @GetMapping("/details/{order_id}")
    public HttpEntity<Order> getOrderById(@PathVariable Integer order_id){
        return orderService.getOrderById(order_id);
    }
}
