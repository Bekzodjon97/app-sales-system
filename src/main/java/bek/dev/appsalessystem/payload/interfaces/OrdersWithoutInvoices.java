package bek.dev.appsalessystem.payload.interfaces;

import java.util.Date;

public interface OrdersWithoutInvoices {
    Integer getOrderId();
    Integer getProductId();
    Date getOrderDate();
    double getTotalPrice();
}
