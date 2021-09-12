package bek.dev.appsalessystem.service;

import org.springframework.http.HttpEntity;


public interface InvoiceService {
    HttpEntity<?> getExpiredInvoices();

    HttpEntity<?> getWrongDateInvoices();

    HttpEntity<?> getOverpaidInvoices();

    //10
    HttpEntity<?> getOrdersWithoutInvoices();
}
