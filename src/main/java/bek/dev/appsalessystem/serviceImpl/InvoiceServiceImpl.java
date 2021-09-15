package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.entity.Invoice;
import bek.dev.appsalessystem.repository.InvoiceRepository;
import bek.dev.appsalessystem.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    @Autowired
    InvoiceRepository invoiceRepository;

    // GET INVOICES ISSUED AFTER THEIR DUE DATE
    @Override
    public HttpEntity<List<Invoice>> getExpiredInvoices() {
        return ResponseEntity.ok(invoiceRepository.getExpiredInvoices());
    }


    //GET INVOICES THAT WERE ISSUED BEFORE THE DATE IN WHICH THE ORDER THEY REFER TO WAS PLACED
    @Override
    public HttpEntity<?> getWrongDateInvoices() {
        return ResponseEntity.ok(invoiceRepository.getWrongDateInvoices());
    }


    // GET INVOICES THAT HAVE BEEN OVERPAID
    @Override
    public HttpEntity<?> getOverpaidInvoices() {
        return ResponseEntity.ok(invoiceRepository.getOverpaidInvoices());
    }


    //GET ORDERS WITHOUT INVOICES
    @Override
    public HttpEntity<?> getOrdersWithoutInvoices() {
        return null;
    }
}
