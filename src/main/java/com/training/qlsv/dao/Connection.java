package com.training.qlsv.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.training.qlsv.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Connection {

    private static final String pathName = "result.txt";

    // convert to fileinputstream and fileoutstream
    public static void create(Object data) {
        try {
            /**
             * TODO:
             * if exist file
                 * yes: append data
                 * no: create new file
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static List<Student> findAll() {
        try {
            List<Student> students = new ArrayList<>();
            /**
             TODO:
             * READ FILE
             * GET ALL DATA
             * ADD TO LIST
              */
            return students;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
            return new ArrayList<>();
        }
    }
}
