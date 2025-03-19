package com.example.UserService.Controller;

import com.example.UserService.Entity.User;
import com.example.UserService.Service.UserService;
import com.example.UserService.UserDto.UserResponse;
import com.example.UserService.feignClient.OrderClient;
import com.example.UserService.Entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderClient orderClient;

    // ✅ Fix: Added @RequestBody
    @PostMapping("/save")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserWithOrder(@PathVariable Long id) {
        User user = userService.getUserById(id);
        if (user == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        // ✅ Fix: Use the correct Order class
        List<Order> orders = orderClient.getOrderByUserId(id);

        // ✅ Fix: Handle null or empty orders
        if (orders == null) {
            orders = List.of(); // Return an empty list instead of null
        }

        UserResponse userResponse = new UserResponse(user.getId(),user.getName(), user.getEmail(), orders);
        return ResponseEntity.ok(userResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.ok("User deleted successfully");
    }
}
