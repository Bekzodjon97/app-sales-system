package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Detail;
import bek.dev.appsalessystem.entity.Order;
import bek.dev.appsalessystem.payload.BulkProducts;
import bek.dev.appsalessystem.payload.HighDemandProducts;
import bek.dev.appsalessystem.payload.NumberOfProductsInYear;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, Integer> {

}
