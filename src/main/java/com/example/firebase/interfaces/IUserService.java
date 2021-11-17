package com.example.firebase.interfaces;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.firebase.models.User;

public interface IUserService {
    String Create(User model) throws InterruptedException, ExecutionException;

    User Get(String id) throws InterruptedException, ExecutionException;

    List<User> GetAll() throws InterruptedException, ExecutionException;

    String Update(User model) throws InterruptedException, ExecutionException;

    String Delete(String id) throws InterruptedException, ExecutionException;

}
