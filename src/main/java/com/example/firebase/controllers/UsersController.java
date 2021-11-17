package com.example.firebase.controllers;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.example.firebase.interfaces.IUserService;
import com.example.firebase.models.User;
import com.example.firebase.utility.Convert;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
public class UsersController {

    private IUserService _service;

    public UsersController(IUserService service) {
        _service = service;
    }

    @GetMapping("")
    public ResponseEntity<List<User>> GetAll() throws InterruptedException, ExecutionException {
        return ResponseEntity.ok(_service.GetAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> Get(@PathVariable String id) throws InterruptedException, ExecutionException {
        return ResponseEntity.ok(_service.Get(id));
    }

    @PostMapping("")
    public ResponseEntity<String> Post(@RequestBody User model) throws InterruptedException, ExecutionException {
        return ResponseEntity.ok(_service.Create(model));
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> Put(@PathVariable String id, @RequestBody User model)
            throws InterruptedException, ExecutionException {
        model.setId(id);
        return ResponseEntity.ok(_service.Update(model));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> Delete(@PathVariable String id) throws InterruptedException, ExecutionException {
        return ResponseEntity.ok(_service.Delete(id));
    }
}
