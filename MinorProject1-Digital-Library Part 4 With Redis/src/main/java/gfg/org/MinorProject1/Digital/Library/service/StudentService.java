package gfg.org.MinorProject1.Digital.Library.service;

import gfg.org.MinorProject1.Digital.Library.dto.CreateStudentRequest;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.FilterStudentBy;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.Operator;
import gfg.org.MinorProject1.Digital.Library.model.Student;
import gfg.org.MinorProject1.Digital.Library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {


    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(CreateStudentRequest createStudentRequest) {
       return studentRepository.save(createStudentRequest.toStudent());
    }

    public Student getStudent(int id) {
        return studentRepository.findById(id).get();
    }

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public Student updateStudent(int id, CreateStudentRequest createStudentRequest) {
        Student student = studentRepository.findById(id).get();

        student.setName(createStudentRequest.getName());
        student.setEmail(createStudentRequest.getEmail());
        student.setAddress(createStudentRequest.getAddress());
        return studentRepository.save(student);

    }

    public List<Student> filterStudent(Operator operator, FilterStudentBy filterStudentBy, String value) {

        switch (operator){
            case EQUALS :
                switch (filterStudentBy){
                    case NAME:
                        return studentRepository.findByName(value);
                    case EMAIL:
                        return studentRepository.findByEmail(value);
                }
            default:
                return new ArrayList<>();
        }
    }
}
