package com.springboot.Repositories;

import com.springboot.Entities.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository{

    private Map<Integer, Student> DB;

    public StudentRepository() {
        DB = new HashMap<>();
    }

    public Student save(Student studentRes){
        DB.put(studentRes.getId(),studentRes);
        return studentRes;
    }

    public Student findById(Integer id){
        return DB.get(id);
    }

    public List<Student> findAll(){
        List<Student> list = new ArrayList<>();
        for(Student st :DB.values()){
            list.add(st);
        }
        return list;
    }
}
