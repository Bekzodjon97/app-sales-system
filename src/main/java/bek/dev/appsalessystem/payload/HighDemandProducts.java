package bek.dev.appsalessystem.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighDemandProducts {
    private Integer productId;
    private double count;
}
