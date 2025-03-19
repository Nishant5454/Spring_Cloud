package com.example.UserService.UserDto;

import com.example.UserService.Entity.Order;
import com.example.UserService.Entity.User;
//import jakarta.persistence.criteria.Order;
import lombok.*;

import java.util.List;
@Getter
@Setter
public class UserResponse {
    private Long id;
    private String name;
    private String email;
    private List<Order>orders;
    public UserResponse(Long id,String name,String email,List<Order>orders){
        this.id=id;
        this.name=name;
        this.email=email;
        this.orders=orders;
    }

}
