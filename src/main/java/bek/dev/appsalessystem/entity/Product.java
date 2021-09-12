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
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 10)
    private String name;

    @ManyToOne(optional = false)
    private Category category;

    @Column(length = 20)
    private String description;

    @Column(nullable = false,scale = 2,precision = 6)
    private double price;

    @ManyToOne
    private Attachment photo;

}
