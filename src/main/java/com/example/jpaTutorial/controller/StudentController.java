package com.example.jpaTutorial.controller;

import com.example.jpaTutorial.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

   /* @GetMapping("/student")
    public Student getStudent(){
        Student student = new Student(
                1,
                 "Ramesh",
                "Fadatare"
        );
        return student;
    }
    */

    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(
                1,
                "Ramesh",
                "Fadatare"
        );
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

   /*
    @GetMapping("/students")
    public List<Student> getStudents(){
        List<Student> students= new ArrayList<>();
        students.add(new Student(2, "Nilabh","Aditya"));
        students.add(new Student(3,"Ankush","Singhania"));
        students.add(new Student(4,"Akhilesh","Singh"));
        return students;
    }
  */

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(){
        List<Student> students= new ArrayList<>();
        students.add(new Student(2, "Nilabh","Aditya"));
        students.add(new Student(3,"Ankush","Singhania"));
        students.add(new Student(4,"Akhilesh","Singh"));
        return ResponseEntity.ok(students);
    }

    /*
    @GetMapping("/student/{id}")
    public Student studentPathVariable(@PathVariable("id") int studentId)
    {
        return new Student(studentId, "Zebra","Technologies");
    }
    */

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId)
    {
        return ResponseEntity.ok(new Student(studentId, "Zebra","Technologies"));
    }


    @GetMapping("/student/{id}/{first-name}/{last-name}")
    public Student studentPathVariable2(@PathVariable("id") int studentId,
                                        @PathVariable("first-name") String firstName,
                                        @PathVariable("last-name") String lastName){
        return new Student(studentId,firstName,lastName);
    }

    @GetMapping("/student/query")
    public Student studentQueryParam(@RequestParam int id, @RequestParam String firstName, @RequestParam String lastName){
        return new Student(id,firstName,lastName);
    }

    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    @PutMapping("/student/update")
    public Student updateStudent(@RequestBody Student student, @RequestParam int id){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    /*
    @DeleteMapping("/student/delete/{id}")
    public String deleteStudent(@PathVariable int studentId){
        System.out.println(studentId);
        return "Student with ID "+studentId+" deleted successfully";
    }
    */

    @DeleteMapping("/student/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int studentId){
        System.out.println(studentId);
        return ResponseEntity.ok("Student with ID "+studentId+" deleted successfully");
    }
}
