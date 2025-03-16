package com.example.library_management_system.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    @NotNull(message = "ID can not be null")
    private int id;
    @NotEmpty(message = "The name can not be empty")
    private String name;
    @NotNull(message = "Number of page can not be null")
    private int number_of_pages;
    @NotNull(message = "Should have price")
    private double price;
    @NotEmpty(message = "The category can not be empty")
    @Pattern(regexp = "novel|academic" , message = "You should choose (Novel or Academic)")
    private String category;
    private boolean isAvailable = false;
}
