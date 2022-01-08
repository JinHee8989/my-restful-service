package com.example.myrestfulservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service){ //생성자를 이용한 의존성 주입
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        User user = service.findOne(id);
        if(user == null){
            throw new UserNotFoundException(String.format("ID[%s] not fount",id));
        }
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest() //현재 요청된 리퀘스트를 사용한다는 의미
                .path("/{id}")
                .buildAndExpand(savedUser.getId()) //가변변수 {id}에 새로 생성한 savedUser.getId()를 넣어줌
                .toUri();

        return ResponseEntity.created(location).build();    //status에 [201 created]로 오고 headers의 location에 [http://localhost:8088/users/4]이런 형식으로 오게 됨
    }
}
