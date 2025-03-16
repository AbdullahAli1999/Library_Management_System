package com.example.library_management_system.Model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @NotNull(message = "ID can not be null")
    private int id;
    @NotEmpty(message = "The name can not be empty")
    private String name;
    @NotNull(message = "Age can not be null")
    private int age;
    @NotNull(message = "The balance can not be empty")
    private int balance;
    @NotEmpty(message = "The role can not be empty")
    @Pattern(regexp = "customer|librarian" , message = "You should choose (customer or librarian)")
    private String role;
}
