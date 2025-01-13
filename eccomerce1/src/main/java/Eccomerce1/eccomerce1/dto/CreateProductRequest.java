package Eccomerce1.eccomerce1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class CreateProductRequest {

    private Integer id;

    @NotBlank(message = "Name required")
    private String name;

    @NotBlank
    private String desc;

    @NotBlank
    private String category;

    @NotBlank
    private BigDecimal price;

    @NotBlank
    private String image;
}
