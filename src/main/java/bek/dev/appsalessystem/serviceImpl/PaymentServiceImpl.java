package bek.dev.appsalessystem.serviceImpl;

import bek.dev.appsalessystem.entity.Invoice;
import bek.dev.appsalessystem.entity.Payment;
import bek.dev.appsalessystem.entity.enums.Status;
import bek.dev.appsalessystem.payload.Result;
import bek.dev.appsalessystem.repository.InvoiceRepository;
import bek.dev.appsalessystem.repository.PaymentRepository;
import bek.dev.appsalessystem.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;
    @Autowired
    InvoiceRepository invoiceRepository;


    //GET PAYMENT
    @Override
    public HttpEntity<?> getPaymentById(Integer payment_details_id) {
        return ResponseEntity.ok(paymentRepository.findById(payment_details_id));
    }


    //MAKE PAYMENT
    @Transactional
    @Override
    public Result makePayment(Integer invoice_id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(invoice_id);
        if (!optionalInvoice.isPresent()) {
            return new Result(Status.FAILED,null);
        }
        Invoice invoice = optionalInvoice.get();
        Payment payment=new Payment();
        payment.setAmount(invoice.getAmount());
        payment.setInvoice(invoice);
        paymentRepository.save(payment);
        return new Result(Status.SUCCESS,payment);

    }
}
