package com.example.firebase.models;

import com.example.firebase.utility.GenerateUUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;
    private String name;
    private String lastname;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id.trim().isEmpty() || id == null) {
            this.id = id = GenerateUUID.create().toString();
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("{ id:%s, name:%s: lastname:%s, age:%d}", id, name, lastname, age);
    }
}
