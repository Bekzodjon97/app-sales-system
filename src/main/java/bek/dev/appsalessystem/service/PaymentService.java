package bek.dev.appsalessystem.service;

import bek.dev.appsalessystem.payload.Result;
import org.springframework.http.HttpEntity;

public interface PaymentService {
    HttpEntity<?> getPaymentById(Integer payment_details_id);

    Result makePayment(Integer invoice_id);
}
