package com.springboot.Controller;

import com.springboot.Entities.Student;
import com.springboot.Services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student stuRes = studentService.createStudent(student);
        return ResponseEntity.ok(stuRes);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Student> getById(@PathVariable("id") Integer id){
        Student stuRes =  studentService.getStudentById(id);
        if(stuRes==null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(stuRes);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> stuRes =  studentService.getAllStudent();
        return ResponseEntity.ok(stuRes);
    }
}
