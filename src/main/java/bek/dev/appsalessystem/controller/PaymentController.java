package bek.dev.appsalessystem.controller;

import bek.dev.appsalessystem.entity.enums.Status;
import bek.dev.appsalessystem.payload.Result;
import bek.dev.appsalessystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;


    @PostMapping("/{invoice_id}")
    public HttpEntity<?> makePayment(@PathVariable Integer invoice_id){
      Result result=paymentService.makePayment(invoice_id);
      return ResponseEntity.status(result.getMessage().equals(Status.SUCCESS)?200:409).body(result);
    }


    @GetMapping("/{payment_details_id}")
    public HttpEntity<?> getPaymentById(@PathVariable Integer payment_details_id){
        return paymentService.getPaymentById(payment_details_id);
    }
}
