package co.istad.productapisimple.dto;

import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record CategoryRequest(
        @NotBlank(message = "name is require")
        String name,
        @NotBlank(message = "description is required")
        @Size(min = 1, max = 100)
        String description,
        @AssertFalse(message = "IsActive is required")
        Boolean isActive
) {
}
