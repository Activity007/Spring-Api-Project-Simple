package co.istad.productapisimple.dto;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;


public record CategoryRequest(
        @NotBlank(message = "name is require")
        String name,
        @NotBlank(message = "description is required")
        String description,
        @AssertFalse(message = "IsActive is required")
        Boolean isActive
) {
}
