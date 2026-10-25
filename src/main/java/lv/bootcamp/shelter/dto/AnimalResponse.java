package lv.bootcamp.shelter.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lv.bootcamp.shelter.model.AnimalStatus;
import lv.bootcamp.shelter.model.AnimalType;

/**
 * Response body for a single animal returned by the API.
 * {@code adoptionNote} is only populated for ADMIN callers (see AnimalService#toResponse) —
 * everyone else just sees the plain {@code status}.
 */
public record AnimalResponse(
        @Schema(description = "Unique animal id", example = "1")

        Long id,
        @Schema(description = "Animal name", example = "Luna")
        String name,
        @Schema(description = "Animal type", example = "CAT")
        AnimalType type,
        @Schema(description = "Breed of the animal", example = "Bengal")
        String breed,
        @Schema(description = "Age in years", example = "2")
        Integer age,
        @Schema(description = "Short description of the animal", example = "Calm and affectionate.")
        String description,
        @Schema(description = "Adoption status", example = "AVAILABLE")
        AnimalStatus status,
        @Schema(description = "Resolved image path or URL", example = "/images/animals/Luna.jpeg")
        String imageUrl,
        @Schema(description = "Adoption date note, only set for adopted animals", example = "adopted on 2026-06-01")
        String adoptionNote
) {}
