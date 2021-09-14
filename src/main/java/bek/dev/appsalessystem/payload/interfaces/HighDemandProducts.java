package bek.dev.appsalessystem.payload.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public interface HighDemandProducts {
    Integer getProductId();
    double getCountOfOrdersByProduct();
}
