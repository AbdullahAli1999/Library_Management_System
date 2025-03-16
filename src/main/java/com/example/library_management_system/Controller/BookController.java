package com.example.library_management_system.Controller;

import com.example.library_management_system.Api.ApiResponse;
import com.example.library_management_system.Model.Book;
import com.example.library_management_system.Service.BookService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/book")
//@RequiredArgsConstructor
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    //GET
    @GetMapping("/get")
    public ResponseEntity getBook(){
        ArrayList<Book> books = bookService.getAllBook();
        return ResponseEntity.status(200).body(books);
    }

    //ADD
    @PostMapping("/add")
    public ResponseEntity addBooks(@RequestBody @Valid Book book, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);

        }
        bookService.addBooks(book);
        return ResponseEntity.status(200).body(new ApiResponse("Added"));
    }

    //UPDATE
    @PutMapping("/update/{id}")
    public ResponseEntity updateBooks(@PathVariable int id, @RequestBody  Book book, Errors errors){
    if (errors.hasErrors()){
        String message = errors.getFieldError().getDefaultMessage();
        return ResponseEntity.status(400).body(message);
    }
    bookService.updateBooks(id, book);
    return ResponseEntity.status(200).body(new ApiResponse("Updated"));

    }

    //DELETE
    @DeleteMapping("/del/{id}")
    public ResponseEntity deleteBooks(@PathVariable int id){
        if(bookService.deleteBooks(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Not found"));
    }

    //SerachBookByName
    @GetMapping("/name/{name}")
    public ResponseEntity searchBookByName(@PathVariable String name ){
        return ResponseEntity.status(200).body(bookService.takeOneBook(name));
    }
    //SerachByCategory
    @GetMapping("/category/{category}")
    public ResponseEntity searchByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(bookService.byCategory(category));
    }
    //SearchBynumber
    @GetMapping("/num/{numbers_of_pages}")
    public ResponseEntity byNumOfPages(int numbers_of_pages){
        return ResponseEntity.status(200).body(bookService.byNumOfPage(numbers_of_pages));
    }

}
