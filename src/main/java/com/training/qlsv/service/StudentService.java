package com.training.qlsv.service;

import com.training.qlsv.dao.Connection;
import com.training.qlsv.model.Student;

import java.util.List;

public class StudentService {

    public static Student createStudent(Student request){
        Connection.create(request);
        return request;
    }

    public static List<Student> findAll(){
        return Connection.findAll();
    }


}
