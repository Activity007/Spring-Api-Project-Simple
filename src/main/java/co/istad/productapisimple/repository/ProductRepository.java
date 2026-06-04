package co.istad.productapisimple.repository;

import co.istad.productapisimple.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@Repository
@Slf4j
public class ProductRepository {
    private final List<Product> productsList = new ArrayList<>(){{
        add(new Product(001,"coca","good for health",2.5f,1));
        add(new Product(002,"pepsi","Nice when u drink during eating hotpot",1.5f,2));
        add(new Product(003,"sting","No need to reapply lipstick",1.0f,3));
    }};

    public List<Product> getAllProducts() {
        return productsList;
    }
    public Product createProduct(Product product){
        productsList.add(product);
        return product;
    }
    public Product updateProduct(Product product ) {
        Product oldProduct = productsList.stream()
                .filter(p -> p.getId() == product.getId())
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product not found"));
        oldProduct.setName(product.getName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setDescription(product.getDescription());

        return oldProduct;
    }
    public Product findProductById(Integer id){
        log.info(productsList.toString());
        return productsList.stream()
                .filter(u-> Objects.equals(u.getId(), id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Product With Id "+ id +" not found"));
    }

    public boolean deleteProductById(Integer id){
        return productsList.removeIf(u->u.getId()==id);
    }
}
