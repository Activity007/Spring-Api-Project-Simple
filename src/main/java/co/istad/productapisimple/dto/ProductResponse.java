package co.istad.productapisimple.dto;

public record ProductResponse(
        Integer id ,
        String name,
        String description,
        Float price,
        CategoryResponse category
) {
}
