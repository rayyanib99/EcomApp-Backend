package com.ecomApp.Ecom.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin("*")
public class UserController 
{
    @Autowired
    private UserService userService;
    
    @GetMapping("/users")
    public List<User> listAll()
    {
        return userService.listAllUser();
    }
    
    @GetMapping("/users/{id}")
    public Optional<User> getUserById(@PathVariable Long id)
    {
        try 
        {
            Optional<User> user = userService.getUserById(id);
            System.out.println(user);
            return user;
        }
        
        catch (NoSuchElementException e) 
        {
            return null;
        }
    }

    @PostMapping("/users")
    public void addProduct(@RequestBody User user)
    {
        userService.createNewUser(user);
    }

    @DeleteMapping("/users/{id}")
    public void deleteProduct(@PathVariable Long id) 
    {
        userService.deleteUser(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> updateOrder(@PathVariable Long id, @RequestBody User user) 
    {
        user = userService.updateUser(id, user);
        return ResponseEntity.ok(user);
    }
}