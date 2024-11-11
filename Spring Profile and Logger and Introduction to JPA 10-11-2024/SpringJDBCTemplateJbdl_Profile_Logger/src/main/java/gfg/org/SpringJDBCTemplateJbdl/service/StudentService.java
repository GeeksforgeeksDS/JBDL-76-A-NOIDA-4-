package gfg.org.SpringJDBCTemplateJbdl.service;

import gfg.org.SpringJDBCTemplateJbdl.model.Student;
import gfg.org.SpringJDBCTemplateJbdl.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public Student getByID(int id) {
        return studentRepository.getByID(id);
    }

    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    public Student update(Student student, int id) {
        return studentRepository.update(student, id);
    }


    public String delete(int id) {
        return studentRepository.delete(id);
    }
}
