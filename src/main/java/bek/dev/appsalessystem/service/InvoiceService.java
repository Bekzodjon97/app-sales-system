package bek.dev.appsalessystem.service;

import bek.dev.appsalessystem.entity.Invoice;
import org.springframework.http.HttpEntity;

import java.util.List;


public interface InvoiceService {
    HttpEntity<List<Invoice>> getExpiredInvoices();

    HttpEntity<?> getWrongDateInvoices();

    HttpEntity<?> getOverpaidInvoices();

    //10
    HttpEntity<?> getOrdersWithoutInvoices();
}
