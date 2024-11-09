package gfg.org.SpringJDBCTemplateJbdl.controller;


import gfg.org.SpringJDBCTemplateJbdl.model.Student;
import gfg.org.SpringJDBCTemplateJbdl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        return ResponseEntity.ok(studentService.save(student));
    }

    @GetMapping("/getByID/{id}")
    public ResponseEntity<Student> getByID(@PathVariable int id){
        return ResponseEntity.ok(studentService.getByID(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAll(){
        return ResponseEntity.ok(studentService.getAll());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Student> update(@RequestBody Student student, @PathVariable int id){
        return ResponseEntity.ok(studentService.update(student, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return ResponseEntity.ok(studentService.delete(id));
    }


}
