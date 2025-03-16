package com.example.library_management_system.Service;

import com.example.library_management_system.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {
    ArrayList<User> users = new ArrayList<>();

    //GET
    public ArrayList<User> getUsers(){
        return users;
    }

    //ADD
    public boolean addUsers(User user){
        for (int i = 0; i < users.size(); i++) {
            User user1 = users.get(i);
            if(user1.getId() == user.getId()){
                return false;
            }
        }
        users.add(user);
        return true;

    }
    public boolean updateUsers(int id , User user){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == id){
                users.set(i,user);
                return true;
            }
        }
        return false;
    }

    public boolean deleteUsers(int id){
        for (int i = 0; i < users.size(); i++) {
            if(users.get(i).getId() == id){
                users.remove(users.get(i));
                return true;
            }
        }
        return false;
    }

    //takesBalance
    public User balance(int balance){
        ArrayList<User> above = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User u = users.get(i);
            if(u.getBalance() >= balance){
                above.add(u);
            }
        }
        return null;
    }

    public ArrayList<User> takesAgeOrAbove(int age){
        ArrayList<User> userAge = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            User u2 = users.get(i);
            if(u2.getAge() >= age){
                userAge.add(u2);

            }
        }
        return userAge;
    }
}
