package bek.dev.appsalessystem.payload.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

public interface WrongDateInvoice {
    Integer getInvoiceId();
    Integer getOrderId();
    Date getIssued();
    Date getOrderDate();
}
