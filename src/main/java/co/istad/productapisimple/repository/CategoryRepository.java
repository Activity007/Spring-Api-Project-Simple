package co.istad.productapisimple.repository;

import co.istad.productapisimple.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Boolean existsByName(String name);

    Category findByName(String name);
}
