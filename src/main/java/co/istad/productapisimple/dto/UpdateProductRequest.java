package co.istad.productapisimple.dto;

public record UpdateProductRequest(
        String name,
        String description ,
        Float price
) {
}