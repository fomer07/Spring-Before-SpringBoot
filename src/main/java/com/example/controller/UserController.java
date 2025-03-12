package com.example.controller;

import com.example.model.User;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Alice", "alice@example.com"));
        users.add(new User(2, "Bob", "bob@example.com"));
    }

    @GetMapping
    public List<User> getAllUsers() {
        return users;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") int id) {
        return users
                .stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        user.setId(users.size()+1);
        users.add(user);
        return user;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") int id, @RequestBody User updateUser) {
        for (User user : users) {
            if (user.getId() == id) {
                user.setName(updateUser.getName());
                user.setEmail(updateUser.getEmail());
                return user;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        users.removeIf(user -> user.getId() == id);
        return "User deleted successfully!";
    }
}
