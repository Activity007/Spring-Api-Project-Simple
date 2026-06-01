package co.istad.productapisimple.service;

import co.istad.productapisimple.dto.ProductResponse;
import co.istad.productapisimple.entity.Product;
import co.istad.productapisimple.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(Product product) {
        return null;
    }

    @Override
    public List<ProductResponse> findAllProducts() {
        return List.of();
    }

    @Override
    public ProductResponse updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(int id) {
        return false;
    }

    @Override
    public ProductResponse findProductById(int id) {
        return null;
    }
}
