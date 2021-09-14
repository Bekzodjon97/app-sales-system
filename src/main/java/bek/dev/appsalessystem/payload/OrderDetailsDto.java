package bek.dev.appsalessystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailsDto {
    private Integer customerId;
    private Integer productId;
    private Short quantity;

}
