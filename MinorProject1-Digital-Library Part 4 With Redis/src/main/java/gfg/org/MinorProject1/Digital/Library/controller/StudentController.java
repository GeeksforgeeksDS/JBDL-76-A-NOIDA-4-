package gfg.org.MinorProject1.Digital.Library.controller;

import gfg.org.MinorProject1.Digital.Library.dto.CreateStudentRequest;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.FilterStudentBy;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.Operator;
import gfg.org.MinorProject1.Digital.Library.model.Student;
import gfg.org.MinorProject1.Digital.Library.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return ResponseEntity.ok(studentService.createStudent(createStudentRequest));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable int id) {
        return ResponseEntity.ok(studentService.getStudent(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id,@RequestBody CreateStudentRequest createStudentRequest) {
        return ResponseEntity.ok(studentService.updateStudent(id,createStudentRequest));
    }

    @GetMapping("/filter/{operator}/{filterStudentBy}/{value}")
    public ResponseEntity<List<Student>> filterStudent(@PathVariable Operator operator, @PathVariable FilterStudentBy filterStudentBy, @PathVariable String value){
        return ResponseEntity.ok(studentService.filterStudent(operator,filterStudentBy,value));
    }


}
