package com.example.firebase.services;

import java.util.List;
import java.util.concurrent.ExecutionException;

import com.example.firebase.interfaces.IUserService;
import com.example.firebase.models.User;
import com.example.firebase.utility.Convert;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private Firestore dbFirestore = FirestoreClient.getFirestore();

    @Override
    public String Create(User model) throws InterruptedException, ExecutionException {
        var writeResult = dbFirestore.collection("users").document(model.getId()).set(Convert.toMap(model));
        return writeResult.get().getUpdateTime().toString();
    }

    @Override
    public User Get(String id) throws InterruptedException, ExecutionException {

        var documentReference = dbFirestore.collection("users").document(id);
        var future = documentReference.get();
        var document = future.get();
        if (document.exists()) {
            return document.toObject(User.class);
        }
        return null;
    }

    @Override
    public List<User> GetAll() throws InterruptedException, ExecutionException {
        var result = dbFirestore.collection("users").get();
        return result.get().toObjects(User.class);
    }

    @Override
    public String Update(User model) throws InterruptedException, ExecutionException {

        var writeResult = dbFirestore.collection("users").document(model.getId()).update(Convert.toMap(model));
        return writeResult.get().getUpdateTime().toString();
    }

    @Override
    public String Delete(String id) throws InterruptedException, ExecutionException {
        var writeResult = dbFirestore.collection("users").document(id).delete();
        return String.format("id:%s was removed %s", id, writeResult.get().getUpdateTime());
    }

}