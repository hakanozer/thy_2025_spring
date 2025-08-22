package com.works.entities.dto;

import jakarta.validation.constraints.*;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.works.entities.Product}
 */
@Value
public class ProductUpdateDto implements Serializable {
    @NotNull
    @Min(1)
    Long pid;
    @NotNull
    @Size(min = 2, max = 100)
    @NotEmpty
    String title;
    @NotNull
    @Size(min = 3, max = 300)
    @NotEmpty
    String description;
    @NotNull
    @Min(1)
    @Max(1000000)
    Double price;
}