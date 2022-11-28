package com.training.qlsv.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Student extends BaseModel implements Serializable {
    private Integer id;
    private String name;
    private String address;

    public Student() {
    }

    public Student(Integer id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Student(String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, Integer id, String name, String address) {
        super(createdBy, updatedBy, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", address:'" + address + '\'' +
                '}';
    }
}
