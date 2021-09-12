package bek.dev.appsalessystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NumberOfProductsInYear {
    private Integer count;
    private String country;

}
