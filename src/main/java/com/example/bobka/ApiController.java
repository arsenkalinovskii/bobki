package com.example.bobka;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
public class ApiController {

    List<User> users = new ArrayList<User>();
    // curl -X POST localhost:8080/users -H "Content-Type: application/json" -d "{\"age\":18,\"name\":\"Alex\"}"
    @PostMapping("users")
    public ResponseEntity<Void> addUser(@RequestBody User user){
        users.add(user);
        return  ResponseEntity.accepted().build();
    }
    // curl -X DELETE localhost:8080/users/0
    @DeleteMapping("users/{index}")
    public ResponseEntity<Void> deleteUser(@PathVariable("index") Integer index){
        users.remove((int) index);
        return ResponseEntity.noContent().build();
    }
    // curl localhost:8080/users/0
    @GetMapping("users/{index}")
    public ResponseEntity<User> getUserAtIndex(@PathVariable("index") Integer index){
        if(index >= users.size())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(users.get(index));
    }
    // curl localhost:8080/users
    @GetMapping("users")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok(users);
    }
    // curl -X PUT localhost:8080/users/0 -H "Content-Type: application/json" -d 19
    @PutMapping("users/{index}")
    public ResponseEntity<Void> setAge(
            @PathVariable("index") Integer index,
            @RequestBody Integer age) {
        if(index > users.size())
            return ResponseEntity.notFound().build();
        users.get((int) index).setAge(age);
        return ResponseEntity.accepted().build();
    }
}