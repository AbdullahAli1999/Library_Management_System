package com.example.library_management_system.Service;

import com.example.library_management_system.Model.Book;
import com.example.library_management_system.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {

    ArrayList<Book> books = new ArrayList<>();

    //GET
    public ArrayList<Book> getAllBook(){
       ArrayList<Book> b = books;
       return b;
    }

    //ADD
    public boolean addBooks(Book book){
        for (int i = 0; i < books.size(); i++) {
            Book book1 = books.get(i);
            if(book.getId() == book1.getId()){
                return false;
            }

        }
        books.add(book);
        return true;
    }

    //UPDATE
    public boolean updateBooks(int id , Book book){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == id){
                books.set(i,book);
                return true;
            }

        }
        return false;
    }

    //DELETE
    public boolean deleteBooks(int id){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getId() == id){
                books.remove(books.get(i));
                return true;
            }

        }
        return false;
    }

    public ArrayList<Book> takeOneBook(String name){
        ArrayList<Book> oneBookFromName = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b1 = books.get(i);
            if(b1.getName().equalsIgnoreCase(name)){
                oneBookFromName.add(b1);
            }
        }
        return oneBookFromName;
    }


    public ArrayList<Book> byCategory(String category){
        ArrayList<Book> byCategorys = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b3 = books.get(i);
            if(b3.getCategory().equalsIgnoreCase(category)){
                byCategorys.add(b3);
            }
        }
        return byCategorys;
    }

    public ArrayList<Book> byNumOfPage(int number_of_pages){
        ArrayList<Book> numOfPages = new ArrayList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b4 = books.get(i);
            if(b4.getNumber_of_pages() >= number_of_pages){
                numOfPages.add(b4);
            }
        }
        return numOfPages;
    }

//    public boolean isAvaialble(String name){
//
//        for (int i = 0; i < books.size(); i++) {
//           if(books.get(i).getName().equalsIgnoreCase(name) ||  )
//        }
//        return false;
//    }

}
