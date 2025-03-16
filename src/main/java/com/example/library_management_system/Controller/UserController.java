package com.example.library_management_system.Controller;

import com.example.library_management_system.Api.ApiResponse;
import com.example.library_management_system.Model.Book;
import com.example.library_management_system.Model.User;
import com.example.library_management_system.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getUsers(){
        ArrayList<User> users = userService.getUsers();
        return ResponseEntity.status(200).body(users);
    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        userService.addUsers(user);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }

    //UPDATE
    @PutMapping("/update/{id}")
     public ResponseEntity updateUser(@PathVariable int id, @RequestBody @Valid User user , Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.updateUsers(id, user);
        return ResponseEntity.status(200).body(new ApiResponse("Updated"));
     }

     //DELETE
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteUser(@PathVariable int id){
        userService.deleteUsers(id);
       return ResponseEntity.status(200).body(new ApiResponse("Deleted"));

    }
    @GetMapping("/above/{balance}")
    public ResponseEntity aboveBalance(@PathVariable int balance){
        return ResponseEntity.status(200).body(userService.balance(balance));
    }


    @GetMapping("/age/{age}")
    public ResponseEntity userAge(@PathVariable int age){
        return ResponseEntity.status(200).body(userService.takesAgeOrAbove(age));
    }


}
