package bek.dev.appsalessystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
public class OrderDetailsDto {
    @NotNull(message = "CustomerId should not be empty")
    private Integer customerId;
    @NotNull(message = "ProductId should not be empty")
    private Integer productId;
    @NotNull(message = "Quantity should not be empty")
    private Short quantity;

}
