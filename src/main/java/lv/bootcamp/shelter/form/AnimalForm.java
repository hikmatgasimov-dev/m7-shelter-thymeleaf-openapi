package lv.bootcamp.shelter.form;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lv.bootcamp.shelter.model.AnimalType;

/**
 * Form-backing object for server-rendered Thymeleaf pages.
 * Kept separate from API DTOs so form changes do not silently change the JSON contract.
 */
public record AnimalForm(

        @NotBlank(message = "Name is required")
        @Size(max = 50, message = "Name must be at most 50 characters")
        String name,

        @NotNull(message = "Type is required")
        AnimalType type,

        @Size(max = 50, message = "Breed must be at most 50 characters")
        String breed,

        @NotNull(message = "Age is required")
        @Min(value = 0, message = "Age cannot be negative")
        @Max(value = 40, message = "Age must be 40 or less")
        Integer age,

        @Size(max = 300, message = "Description must be at most 300 characters")
        String description,

        String imageUrl
) {}