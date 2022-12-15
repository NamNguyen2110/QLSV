package com.training.qlsv.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Student extends BaseModel implements Serializable {
    private static int COUNT;
    private Integer id;
    private String name;
    private String address;

    private List<Course> courseList;

    public Student() {
        this.id = ++COUNT;
    }

    public Student(String name, String address, List<Course> courseList) {
        this.id = ++COUNT;
        this.name = name;
        this.address = address;
        this.courseList = courseList;
    }

    public Student(String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, String name, String address, List<Course> courseList) {
        super(createdBy, updatedBy, createdAt, updatedAt);
        this.id = ++COUNT;
        this.name = name;
        this.address = address;
        this.courseList = courseList;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }


    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", name:'" + name + '\'' +
                ", address:'" + address + '\'' +
                ", number of course:" + courseList.size() +
            '}';
        }
    }


