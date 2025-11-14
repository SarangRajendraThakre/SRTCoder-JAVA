package com.srt.request;

import jakarta.validation.constraints.DecimalMin; // Import for numeric validation
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductDetail {

    // 1. pid (Integer): Use @NotNull. @NotBlank is only for Strings.
    @NotNull(message = "Product ID cannot be null")
    private Integer pid;

    // 2. prodname (String): @NotBlank is sufficient and implies @NotNull.
    @NotBlank(message = "Product Name cannot be blank")
    private String prodname;

    // 3. prodPrice (Double): Use wrapper type for @NotNull. Use @DecimalMin for minimum value.
    @NotNull(message = "Product Price cannot be null")
    @DecimalMin(value = "0.01", message = "Product Price must be greater than 0")
    private Double prodPrice; // Changed to wrapper type Double for @NotNull to work correctly
    
}