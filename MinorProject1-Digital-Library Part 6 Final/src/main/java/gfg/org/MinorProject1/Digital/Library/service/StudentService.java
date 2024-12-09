package gfg.org.MinorProject1.Digital.Library.service;

import gfg.org.MinorProject1.Digital.Library.dto.CreateStudentRequest;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.FilterStudentBy;
import gfg.org.MinorProject1.Digital.Library.enumsofdigitallibrary.Operator;
import gfg.org.MinorProject1.Digital.Library.model.Student;
import gfg.org.MinorProject1.Digital.Library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class StudentService  implements UserDetailsService {


    @Autowired
    private StudentRepository studentRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    public Student createStudent(CreateStudentRequest createStudentRequest) {

        Student student = createStudentRequest.toStudent();

        student.setPassword(passwordEncoder.encode(student.getPassword()));

        return studentRepository.save(student);


    }

//    public Student getStudent(int id) {
//
//       Student student = studentRepository.findById(id).get();
//
////       // Student student = studentRepository.findByIdAndAuthority(id, authority).get(0);
////
////        if(authority.equals("ADMIN")){
////            return student;
////        } else if (authority.equals("STUDENT") && student.getAuthority().equals(authority)){ {
////            return student;
////        }
//
//
////    }
//
//
////        if(student.getId() == id){
////            return student;
////        }
//
//        return  student;
//    }



    public Student getStudent(String studentId) {
        return studentRepository.findByStudentId(UUID.fromString(studentId));
    }

    public Student getStudentById(int id,String userName) {
        Student student = studentRepository.findById(id).get();

        int i = 1;

        int j = 0;

        int result = i/j;

        Student user = studentRepository.findByEmail(userName).get(0);

        if(user.getAuthority().equals("ADMIN") || student.getUsername().equals(userName))
            return student;

        return null;
        //return studentRepository.findById(id).orElse(null);
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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return studentRepository.findByEmail(username).get(0);
    }
}
