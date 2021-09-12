package bek.dev.appsalessystem.repository;

import bek.dev.appsalessystem.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    //get category by product id
    @Query(value = "select * from category join product p on p.category_id=category.id and p.id=:productId", nativeQuery = true)
    Category getCategoryByProductId(Integer productId);
}
