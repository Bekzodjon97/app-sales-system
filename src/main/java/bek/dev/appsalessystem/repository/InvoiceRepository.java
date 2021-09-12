package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Invoice;
import bek.dev.appsalessystem.payload.WrongDateInvoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    //get invoices issued after their due date
    @Query(value = "select * from invoice  where issued > due", nativeQuery = true)
    List<Invoice> getExpiredInvoices();


    //get invoices that were issued before the date in which the order they refer to was placed
    @Query(value = "select i.id,o.id,i.issued,o.date  from invoice i join orders o on o.id=i.order_id and o.date<i.issued", nativeQuery = true)
    List<WrongDateInvoice> getWrongDateInvoices();


    //get invoices that have been overpaid
    @Query(value = "select  i.id, ((select sum(amount) from payment group by invoice_id)-i.amount) as overpayment from invoice i where (select sum(amount) from payment group by invoice_id)>i.amount ", nativeQuery = true)
    Object getOverpaidInvoices();
}
