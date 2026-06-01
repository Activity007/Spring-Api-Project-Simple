package co.istad.productapisimple.service;

import co.istad.productapisimple.dto.ProductResponse;
import co.istad.productapisimple.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    ProductResponse createProduct(Product product);
    List<ProductResponse> findAllProducts();
    ProductResponse updateProduct(Product product);
    boolean deleteProduct(int id);
    ProductResponse findProductById(int id);
}
