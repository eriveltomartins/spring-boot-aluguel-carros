package erivelto.system.AluguelCarros.dto;

import jakarta.validation.constraints.NotBlank;

public record CarDTO(
        @NotBlank
        String model,
        @NotBlank
        String brand,
        @NotBlank
        String plate
) {
}
