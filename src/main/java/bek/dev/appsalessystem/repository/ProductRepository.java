package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Category;
import bek.dev.appsalessystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
