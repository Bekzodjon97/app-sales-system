package bek.dev.appsalessystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    private Order order;

    @Column(nullable = false,scale = 2,precision = 8)
    private double amount;

    @Column(nullable = false)
    private Date issued;

    @Column(nullable = false)
    private Date due;
}
