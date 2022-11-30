package com.training.qlsv.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.training.qlsv.model.Student;
import com.training.qlsv.utils.FileUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Connection {

    private static final String pathName = "result.txt";

    public static void create(Student data) {
        try {
            File writer = new File(pathName);
            if (writer.exists()) {
                BufferedReader br
                        = new BufferedReader(new InputStreamReader(new FileInputStream(pathName)));
                String line;
                String last = null;
                while ((line = br.readLine()) != null) {
                    last = line;
                }
                Student student = new Gson().fromJson(last, Student.class);
                data.setId(student.getId() + 1);
            } else {
                writer.createNewFile();
                data.setId(1);
            }

            String dataToJson = new Gson().toJson(data);
            FileUtils.writeToFile(pathName, dataToJson, true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void findAll() {
        List<Student> studentList = new ArrayList<>();
        try {
            /**
             TODO:
             * READ FILE
             * GET ALL DATA
             * ADD TO LIST
             */
            FileReader reader = new FileReader(pathName);
            BufferedReader br = new BufferedReader(reader);
            String line = FileUtils.readFromInputStream(new FileInputStream(pathName));
            System.out.println(line);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("errors");
        }
    }
}
