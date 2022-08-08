package com.ecomApp.Ecom.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin("*")
public class UserController 
{
    @Autowired
    private UserService userService;
    
    @GetMapping
    public List<User> getAllUsers()
    {
        return userService.listAllUsers();
    }
    
    @GetMapping("{id}")
    public Optional<User> getUser(@PathVariable Long id)
    {
        try 
        {
            Optional<User> user = userService.getUserById(id);
            return user;
        }
        
        catch(NoSuchElementException e) 
        {
            return null;
        }
    }

    @PostMapping
    public void addUser(@RequestBody User user)
    {
        userService.createNewUser(user);
    }

    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) 
    {
        userService.deleteUser(id);
    }

    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) 
    {
        user = userService.updateUser(id, user);
        return ResponseEntity.ok(user);
    }
}