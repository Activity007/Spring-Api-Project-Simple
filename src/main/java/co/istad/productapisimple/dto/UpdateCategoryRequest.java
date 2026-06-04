package co.istad.productapisimple.dto;

public record UpdateCategoryRequest(
        String name,
        String description,
        String isActive
) {
}
