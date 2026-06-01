package co.istad.productapisimple.repository;

import co.istad.productapisimple.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {
    private final List<Product> productsList = new ArrayList<>(){{
        add(new Product(001,"coca","good for health",2.5f,1));
        add(new Product(002,"pepsi","Nice when u drink during eating hotpot",1.5f,2));
        add(new Product(003,"sting","No need to reapply lipstick",1.0f,3));
    }};

    public List<Product> getProducts() {
        return productsList;
    }
}
