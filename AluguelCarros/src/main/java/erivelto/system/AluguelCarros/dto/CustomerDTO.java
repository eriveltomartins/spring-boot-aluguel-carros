package erivelto.system.AluguelCarros.dto;

import jakarta.validation.constraints.NotBlank;

public record CustomerDTO(
        @NotBlank
        String name,
        @NotBlank
        String email
) {
}
