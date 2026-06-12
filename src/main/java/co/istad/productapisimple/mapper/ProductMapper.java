package co.istad.productapisimple.mapper;


import co.istad.productapisimple.dto.ProductRequest;
import co.istad.productapisimple.dto.ProductResponse;
import co.istad.productapisimple.entity.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring" , uses = {CategoryMapper.class})
public interface ProductMapper {

    ProductResponse mapToResponse(Product request);
    Product mapToProduct(ProductRequest request);
}
