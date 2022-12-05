package com.training.qlsv.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Course extends BaseModel implements Serializable {
    private Integer id;
    private String name;

    private List<Student> students;

    public Course() {
    }

    public Course(Integer id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Course(String createdBy, String updatedBy, LocalDateTime createdAt, LocalDateTime updatedAt, Integer id, String name, List<Student> students) {
        super(createdBy, updatedBy, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.students = students;
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

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", students=" + students +
                '}';
    }
}
