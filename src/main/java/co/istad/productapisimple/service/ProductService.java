package co.istad.productapisimple.service;
import co.istad.productapisimple.dto.CategoryRequest;
import co.istad.productapisimple.dto.ProductRequest;
import co.istad.productapisimple.dto.ProductResponse;
import co.istad.productapisimple.dto.UpdateProductRequest;
import jakarta.validation.Valid;


import java.util.List;

// For the loosely coupling design
// This interface will be implemented by other class

public interface ProductService {
    ProductResponse createProduct(ProductRequest product);
    List<ProductResponse> findAllProducts();
    ProductResponse findProductById(Integer id);
    ProductResponse updateProduct(Integer id, UpdateProductRequest request);
    boolean deleteProduct(Integer id);
}