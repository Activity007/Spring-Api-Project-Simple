package co.istad.productapisimple.dto;

public record CategoryResponse(
        Integer id,
        String name,
        String description,
        Boolean isActive
) {
}
