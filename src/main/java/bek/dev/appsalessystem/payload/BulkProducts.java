package bek.dev.appsalessystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BulkProducts {
    private Integer productId;
    private double price;
}
